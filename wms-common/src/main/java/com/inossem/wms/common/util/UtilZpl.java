package com.inossem.wms.common.util;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import com.inossem.wms.vo.print.ZplPrintBean;

/**
 * @Description  zpl语言生成条形码和二维码
 * @ClassName：UtilZpl :
 * @Package com.inossem.wms.common.util
 * @anthor：wyang
 * @date：2019/1/23
 * @版本：V1.0
 */
public class UtilZpl {

    private int cnCharSize = 25; // 中文字符尺寸
    private int enCharSizeX = 15; // 英文字符尺寸
    private int enCharSizeY = 25; // 英文字符尺寸

    private int lineSep = 15;
    private int width = 762; // 打印纸宽度 x

    private static String content = "";

    private static Integer SOCKET_TIME_OUT = 60000;

    /******************************************汉字转图片拼装ZPL工具******************************************************/

    public static BufferedImage source = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
    public static Graphics2D gs = source.createGraphics();

    //	public static String getFontZpl(String content, int x, int y, int size, String fontName) {
    //		return String.format("^FO%d,%d^A1N,%d,%d^FD%s^FS", x, y, size, size, content);
    //	}

    public static String getFontHexWithWidth(String content, int x, int y, int width,
                                             int maxHeight, String fontName) {
        if (content == null || "".equals(content))
            return "";
        Font f = null;
        width = (width + 7) / 8 * 8;
        int size = width / content.length();
        int retryFlag = 1;
        if (size > maxHeight) {
            size = maxHeight;
            if ("宋体".equals(fontName)) {
                f = new Font("simsun", Font.PLAIN, size);
            } else if ("黑体".equals(fontName)) {
                f = new Font("simhei", Font.BOLD, size);
            } else {
                f = new Font("simsun", Font.PLAIN, size);
            }
        } else {
            while (true) {
                if ("宋体".equals(fontName)) {
                    f = new Font("simsun", Font.PLAIN, size);
                } else if ("黑体".equals(fontName)) {
                    f = new Font("simhei", Font.BOLD, size);
                } else {
                    f = new Font("simsun", Font.PLAIN, size);
                }
                gs.setFont(f);
                FontMetrics fontMetrics = gs.getFontMetrics();
                Rectangle2D stringBounds = fontMetrics.getStringBounds(content, gs);
                int nw = (int) stringBounds.getWidth();

                if (nw > width) {
                    size--;
                    if (retryFlag == 1) {
                        break;
                    }
                    retryFlag = 0;

                } else {
                    if (size >= maxHeight)
                        break;
                    size++;
                    retryFlag = 1;
                }
            }
        }
        int height = size;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        g2.setFont(f);
        g2.setColor(Color.BLACK);
        g2.drawString(content, 1, (int) (height * 0.88));

        g2.dispose();

        StringBuilder zpl = new StringBuilder("^FO").append(x).append(",").append(y)
                .append(getImage(image)).append("^FS");

        return zpl.toString();

    }

    /**
     * 入口
     *
     * @param content  要转换的汉字
     * @param x        横坐标
     * @param y        总坐标
     * @param size     字体大小
     * @param fontName 字体"黑体"
     * @return
     */
    public static String getFontHex(String content, int x, int y, int size, String fontName) {
        if (content == null || "".equals(content))
            return "";
        Font f = null;
        if ("宋体".equals(fontName)) {
            f = new Font("simsun", Font.PLAIN, size);
        } else if ("黑体".equals(fontName)) {
            f = new Font("simhei", Font.BOLD, size);
        } else if ("roman".equals(fontName)) {
            f = new Font("simsun", Font.ROMAN_BASELINE, size);
        } else {
            f = new Font("simsun", Font.PLAIN, size);
        }
        gs.setFont(f);
        FontMetrics fontMetrics = gs.getFontMetrics();
        Rectangle2D stringBounds = fontMetrics.getStringBounds(content, gs);
        int width = (int) stringBounds.getWidth();
        int height = size;
        width = (width + 7) / 8 * 8;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        g2.setFont(f);
        g2.setColor(Color.BLACK);
        g2.drawString(content, 1, (int) (height * 0.88));

        g2.dispose();

        StringBuilder zpl = new StringBuilder("^FO").append(x).append(",").append(y)
                .append(getImage(image)).append("^FS");

        return zpl.toString();

    }

    private static final char[] HEX = "0123456789ABCDEF".toCharArray();

    public static String printImage(BufferedImage image, int x, int y) {
        if (image.getWidth() % 8 != 0) {
            BufferedImage i = new BufferedImage(((image.getWidth() + 7) / 8) * 8,
                    image.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = i.createGraphics();
            g2.drawImage(image, null, 0, 0);
            g2.dispose();
            image = i;
        }
        StringBuilder zpl = new StringBuilder("^FO").append(x).append(",").append(y)
                .append(getImage(image)).append("^FS");
        return zpl.toString();
    }

    private static String getImage(BufferedImage i) {
        int w = i.getWidth();
        int h = i.getHeight();
        boolean black[] = getBlackPixels(i, w, h);
        int hex[] = getHexValues(black);

        String data = ints2Hex(hex);

        int bytes = data.length() / 2;
        int perRow = bytes / h;

        return "^GFA," + bytes + "," + bytes + "," + perRow + "," + data;

    }


    private static String flipRows(String hex, int height) {
        String flipped = "";
        int width = hex.length() / height;

        for (int i = 0; i < height; i++) {
            flipped += new StringBuilder(hex.substring(i * width, (i + 1) * width)).reverse()
                    .toString();
        }
        return flipped;
    }

    /**
     * Returns an array of ones or zeros. boolean is used instead of int for memory considerations.
     *
     * @return
     */
    private static boolean[] getBlackPixels(BufferedImage bi, int w, int h) {
        int[] rgbPixels = ((DataBufferInt) bi.getRaster().getDataBuffer()).getData();
        int i = 0;
        boolean[] pixels = new boolean[rgbPixels.length];
        for (int rgbpixel : rgbPixels) {
            pixels[i++] = isBlack(rgbpixel);
        }

        return pixels;
    }

    private static boolean isBlack(int rgbPixel) {
        int a = (rgbPixel & 0xFF000000) >>> 24;
        if (a < 127) {
            return false; // assume pixels that are less opaque than the luma threshold should be considered to be white
        }
        int r = (rgbPixel & 0xFF0000) >>> 16;
        int g = (rgbPixel & 0xFF00) >>> 8;
        int b = rgbPixel & 0xFF;
        int luma = ((r * 299) + (g * 587) + (b * 114)) / 1000; //luma formula
        return luma < 127;
    }

    private static int[] getHexValues(boolean[] black) {
        int[] hex = new int[(int) (black.length / 8)];
        // Convert every eight zero's to a full byte, in decimal
        for (int i = 0; i < hex.length; i++) {
            for (int k = 0; k < 8; k++) {
                hex[i] += (black[8 * i + k] ? 1 : 0) << 7 - k;
            }
        }
        return hex;
    }

    public static String getHexString(byte[] b) throws Exception {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    private static String ints2Hex(int[] ints) {
        char[] hexChars = new char[ints.length * 2];
        for (int i = 0; i < ints.length; ++i) {
            hexChars[i * 2] = HEX[(ints[i] & 0xF0) >> 4];
            hexChars[i * 2 + 1] = HEX[ints[i] & 0x0F];
        }
        return new String(hexChars);
    }


    /**
     * 获取RFID标签打印ZPL
     ***/
    private static String getMatRFIDZpl(ZplPrintBean zplPrintBean) {

        //定义一个数组
//		String [] zplArray = new String[items.size()];
//		int i = 0;
//		for(Map<String, Object> co : items){

        StringBuilder sb = new StringBuilder();


        sb.append("^XA");

        //小打印机
        if(zplPrintBean.getZplType().equals((byte)1)){
            sb.append("^LH50,-10");
        }else {
            //大打印机
            sb.append("^LH0,40");
        }



        //库存地点
        if (!StringUtils.isEmpty(zplPrintBean.getLocationName())) {
            //库存地点
            sb.append("^CF0,28");
            sb.append("^FO240,40");
            sb.append("^FD").append(getFontHex(zplPrintBean.getLocationName(), 220, 40, 28, "黑体"));
            sb.append("^FS");

        }

        //物料编号
        if (!StringUtils.isEmpty(zplPrintBean.getMatCode())) {
            sb.append("^CF0,70");
            sb.append("^FO190,70");
            if (zplPrintBean.getMatCode().length() > 8) {
            	sb.append("^FD").append(getFontHex(zplPrintBean.getMatCode(), 190, 70, 50, "黑体"));
			}else {
				sb.append("^FD").append(getFontHex(zplPrintBean.getMatCode(), 190, 70, 80, "黑体"));
			}


            sb.append("^FS");

        }



        //物料描述
        sb.append("^CF0,24");
        sb.append(getFontHex("物料描述：", 60, 155, 24, "黑体"));
        sb.append("^FS");
        String matName = zplPrintBean.getMatName();
        if (!StringUtils.isEmpty(matName)) {
            sb.append("^FO180,155");
            sb.append("^FD").append(getFontHex(matName, 180, 155, 24, "宋体"));
            sb.append("^FS");
        }else{
            sb.append("^FO180,155");
            sb.append("^FD").append(getFontHex("——", 180, 155, 24, "宋体"));
            sb.append("^FS");
        }

        //海关监管批次
        if(StringUtils.isEmpty(zplPrintBean.getCusCustomsSupervisionBatch())){
            //采购订单
            sb.append(getFontHex("采购单号：", 60, 190, 24, "黑体"));
            sb.append("^FS");
            if (!StringUtils.isEmpty(zplPrintBean.getPurchaseOrderNum())) {
                sb.append("^FO180,190");
                sb.append("^FD").append(getFontHex(zplPrintBean.getPurchaseOrderNum()+"-"+zplPrintBean.getPurchaseOrderRid(), 180, 190, 24, "宋体"));
                sb.append("^FS");
            }else {
                sb.append("^FO180,190");
                sb.append("^FD").append(getFontHex("——", 180, 190, 24, "宋体"));
                sb.append("^FS");
            }

        }else {
            //监管批次
            sb.append(getFontHex("海关监管批次：", 60, 190, 24, "黑体"));
            sb.append("^FS");
            sb.append("^FO230,190");
            sb.append("^FD").append(getFontHex(zplPrintBean.getCusCustomsSupervisionBatch(), 230, 190, 24, "宋体"));
            sb.append("^FS");

            //监字图片
        try {
        		System.out.println(URLDecoder.decode(ResourceUtils.getURL("classpath:").toString(),"utf-8"));
                BufferedImage bufferedImage = ImageIO.read(new File("C:/wms/static/Supervision.png"));
                String zplImage = printImage(bufferedImage,540,35);
                sb.append(zplImage);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        //入库日期
        sb.append(getFontHex("到货日期：", 60, 225, 24, "黑体"));
        sb.append("^FS");
        if (!StringUtils.isEmpty(zplPrintBean.getInputDateName())) {
            sb.append("^FO180,225");
            sb.append("^FD").append(getFontHex(zplPrintBean.getInputDateName(), 180, 225, 24, "宋体"));
            sb.append("^FS");
        }else {
            sb.append("^FO180,225");
            sb.append("^FD").append(getFontHex("——", 180, 225, 24, "宋体"));
            sb.append("^FS");
        }


        //工厂
        sb.append(getFontHex("工厂：", 330, 225, 24, "黑体"));
        sb.append("^FS");
        if (!StringUtils.isEmpty(zplPrintBean.getFtyCode())) {
            sb.append("^FO405,225");
            sb.append("^FD").append(getFontHex(zplPrintBean.getFtyCode(), 405, 225, 24, "宋体"));
            sb.append("^FS");
        }


        //采购设施
        sb.append(getFontHex("采购设施：", 60, 260, 24, "黑体"));
        sb.append("^FS");
        if (!StringUtils.isEmpty(zplPrintBean.getPlatform())) {
            sb.append("^FO180,260");
            sb.append("^FD").append(getFontHex(zplPrintBean.getPlatform(), 180, 260, 24, "黑体"));
            sb.append("^FS");
        }else {
            sb.append("^FO180,260");
            sb.append("^FD").append(getFontHex("——", 180, 260, 24, "黑体"));
            sb.append("^FS");
        }

        //单位
        sb.append(getFontHex("单位：", 330, 260, 24, "黑体"));
        sb.append("^FS");
        if (!StringUtils.isEmpty(zplPrintBean.getMaterialUnit())) {
            sb.append("^FO405,260");
            sb.append("^FD").append(getFontHex(zplPrintBean.getMaterialUnit(), 405, 260, 24, "宋体"));
            sb.append("^FS");
        }else {
            sb.append("^FO405,260");
            sb.append("^FD").append(getFontHex("——", 405, 260, 24, "宋体"));
            sb.append("^FS");
        }

        if (!StringUtils.isEmpty(zplPrintBean.getOrCodeValue())) {
            sb.append("^FO60,295");
            sb.append("^FD").append(getFontHex(zplPrintBean.getOrCodeValue(), 60, 295, 24, "宋体"));
            sb.append("^FS");
        }

        //二维码
        if (!StringUtils.isEmpty(zplPrintBean.getOrCodeValue())) {
            //二维码
            sb.append("^FO470,195");
            sb.append("^BQ2,2,5");
            sb.append("^FD").append("IS-RM").append(zplPrintBean.getOrCodeValue());
            sb.append("^FS");
        }

        //打印类型
        if (!StringUtils.isEmpty(zplPrintBean.getType())) {

            sb.append("^FX Fourth section (the two boxes on the bottom).");
            sb.append("^FO600,210^GB50,100,3^FS");
            sb.append("^FO605,210^FD");
            sb.append("^FS").append(getFontHex(zplPrintBean.getType().substring(0, 1), 605, 215, 40, "宋体"));
            sb.append("^FO605,280^FDC").append(getFontHex(zplPrintBean.getType().substring(1), 605, 270, 40, "宋体"));
            sb.append("^FS");

        }
        //RFID写入
        if (!StringUtils.isEmpty(zplPrintBean.getRfidValue())) {
            sb.append("^RFW,H");
            sb.append("^FD");
            sb.append(zplPrintBean.getRfidValue());
            sb.append("^FS");
        }

        sb.append("^XZ");


//		}
        System.out.println(sb.toString());
        return sb.toString();
    }

    /************************************************************************************************/

    /**
     * 设置宽度
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }


    /**
     * 入口1
     * <p>
     * 设置二维码
     *
     * @param qrx     位置x轴
     * @param qry     位置y轴
     * @param type    模式1原始 2增强
     * @param size    放大系数 150dpi打印机上1
     *                200 ：2
     *                300 ：3
     * @param qrValue
     */
    public void setQRcode(String qrx, String qry, String type, String size, String qrValue) {
        String QRcode = "^FO%s,%s^BQ,%s,%s^FDQA,${data}^FS";
        QRcode = String.format(QRcode, qrx, qry, type, size);
        QRcode = QRcode.replace("${data}", qrValue);
        content = content + QRcode + "^FWR";
    }

    /**
     * 入口2
     * <p>
     * 设置一维码
     *
     * @param qrx
     * @param qry
     * @param type
     * @param size
     * @param codeValue
     */
    public void setCode128(String qrx, String qry, String type, String size, String codeValue) {
        String code128 = "^FO%s,%s^BY%s^BCN,%s,N,N,A^FD${data}^FS";
        code128 = String.format(code128, qrx, qry, type, size);
        code128 = code128.replace("${data}", codeValue);
        content = content + code128 + "^FWR";
    }

    /**
     * 设置标签数据
     *
     * @param xy
     * @param c
     * @param label
     * @param value
     * @return
     */
    public int[] setLabelValue(int[] xy, int c, String label, String value) {
        int initX = xy[0];
        if (!UtilString.isNullOrEmpty(label)) {
            xy = this.setText(label, xy);
            xy[0] = initX + 50 + c;
            xy = this.setText(":", xy);
            xy[0] = initX + 110 + c;
        }
        xy = this.setText(value, xy);
        xy[0] = initX;
        xy[1] = xy[1] + cnCharSize + lineSep;
        return xy;
    }


    /**
     * 结束
     *
     * 获取完整的ZPL
     *
     *
     * @return
     */
//    public String getZplString() {
//        return Constant.ZPL_BEGIN + content + "^CI0^PQ1" + Constant.ZPL_END;
//    }

    /**
     * 判断字符串中英文
     *
     * @param ch
     * @return
     */
    private boolean checkChar(char ch) {
        if ((ch + "").getBytes().length == 1) {
            return false; // 英文
        } else {
            return true;// 中文
        }
    }

    /**
     * 设置文本
     *
     * @param str
     * @param xy
     * @return
     */
    public int[] setText(String str, int[] xy) {
        int x = xy[0];
        int y = xy[1];
        if (str != null) {
            char[] charArray = str.toCharArray();
            int initX = x;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (checkChar(c)) {
                    setChar(String.valueOf(c), x, y, true);
                    x = x + cnCharSize;
                } else {
                    setChar(String.valueOf(c), x, y, false);
                    x = x + enCharSizeX;
                }

                if (x >= width) {
                    x = initX;
                    y = y + cnCharSize + lineSep;
                }
            }
        }

        return new int[]{x, y};
    }

    /**
     * 字符(包含数字)
     *
     * @param str 字符串
     * @param x   x坐标
     * @param y   y坐标
     * @param cn  是否为中文
     */
    public void setChar(String str, int x, int y, boolean cn) {
        if (cn) {
            content = content + "^CI14^FO" + x + "," + y + "^A1N," + cnCharSize + "," + cnCharSize + "^FD" + str + "^FS";
        } else {
            content = content + "^CI0^FO" + x + "," + y + "^A1N," + enCharSizeY + "," + enCharSizeX + "^FD" + str + "^FS";
        }

    }


    /**
     * 拼接内容
     *
     * @param str
     */
    public void appendContent(String str) {
        content = content + str;
    }


    public static String ZplPrint(ZplPrintBean zplPrintBean){
        String zpl = "";
        for(int i = 0 ; i < zplPrintBean.getPrintNumber(); i++){
             zpl = zpl + UtilZpl.getMatRFIDZpl(zplPrintBean);

        }
        return zpl;
    }

    public static void toPrint(String ip,int port, String zplString) throws Exception {
        Socket socket;

        socket = new Socket(ip, port);
        socket.setSoTimeout(SOCKET_TIME_OUT);
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(zplString.getBytes("gb2312"));
        socket.close();
    }

    public static void main(String[] args) {

        ZplPrintBean zplPrintBean = new ZplPrintBean();

        zplPrintBean.setLocationName("有限深圳基地中心库");
        zplPrintBean.setMatCode("81000000019");
        zplPrintBean.setCusCustomsSupervisionBatch("40000774716020151229");
        zplPrintBean.setFtyCode("1206");
        zplPrintBean.setPlatform("XJ-23-1");
        zplPrintBean.setMatName("油气集输用缓蚀剂TS-7019B天津正达科技有限责任公司");
        zplPrintBean.setOrCodeValue("121214541357411564ACA5D");
        zplPrintBean.setPurchaseOrderNum("4040028932-10");
        zplPrintBean.setInputDateName("20190808");
        zplPrintBean.setMaterialBatchNum("4040028932-10-20190625");
        zplPrintBean.setMaterialCategory("A22");
        zplPrintBean.setMaterialUnit("EA");
        zplPrintBean.setType("单品");
        zplPrintBean.setRfidValue("121214541357411564ACA5D");
        zplPrintBean.setZplType((byte) 2);

        String zpl = UtilZpl.getMatRFIDZpl(zplPrintBean);
        System.out.println("...");
        System.out.println(zpl);
        System.out.println("...");
        Socket socket;

        try {
            socket = new Socket("10.138.208.127", 6101);
            OutputStream socketOut = socket.getOutputStream();
            socketOut.write(zpl.getBytes(StandardCharsets.UTF_8));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

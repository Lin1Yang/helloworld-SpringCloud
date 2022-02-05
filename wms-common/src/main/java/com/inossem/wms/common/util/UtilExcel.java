package com.inossem.wms.common.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.google.common.collect.Lists;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.inossem.wms.constant.Const;
import com.inossem.wms.constant.Constant;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Excel工具类
 *
 * @author 高海涛
 * @date 2019年1月8日
 */
public class UtilExcel {
	
	private static final Logger logger = LoggerFactory.getLogger(UtilExcel.class);

    /**
     * 生成条形码  CODE128
     *
     * @param contents 内容
     * @param width    宽度
     * @param height   高度
     * @param imgPath  路径
     */
    @SuppressWarnings("deprecation")
    public static void createJbarcode(String contents, int width, int height, String imgPath) {

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.CODE_128, width, height, null);

            MatrixToImageWriter.writeToFile(bitMatrix, "png", new File(imgPath));

        } catch (Exception e) {
        	logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }


    /**
     * 生成二维码
     *
     * @param text       二维码内容
     * @param width      二维码宽
     * @param height     二维码高
     * @param outPutPath 二维码生成保存路径
     * @param imageType  二维码生成格式
     */
    public static void zxingCodeCreate(String text, int width, int height, String outPutPath, String imageType) {
        Map<EncodeHintType, Object> his = new HashMap<EncodeHintType, Object>();
        //设置编码字符集
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");
        his.put(EncodeHintType.MARGIN, 1);
        try {
            //生成二维码
            BitMatrix encode = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, his);

            //获取二维码宽高
            int codeWidth = encode.getWidth();
            int codeHeight = encode.getHeight();

            //将二维码放入缓冲流
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    //循环将二维码内容定入图片
                    image.setRGB(i, j, encode.get(i, j) ? Const.QRCODE_COLOR_BLACK : Const.QRCODE_COLOR_WHITE);
                }
            }
            File outPutImage = new File(outPutPath);
            //如果图片不存在创建图片
            if (!outPutImage.exists())
                outPutImage.createNewFile();
            //将二维码写入图片
            ImageIO.write(image, imageType, outPutImage);
        } catch (WriterException e) {
        	logger.error(e.getMessage());
            System.out.println("二维码生成失败");
        } catch (IOException e) {
        	logger.error(e.getMessage());
            System.out.println("生成二维码图片失败");
        }
    }


    /**
     * 二维码解析
     *
     * @param analyzePath 二维码路径
     * @return
     * @throws IOException
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Object zxingCodeAnalyze(String analyzePath) throws Exception {
        MultiFormatReader formatReader = new MultiFormatReader();
        Object result = null;
        try {
            File file = new File(analyzePath);
            if (!file.exists()) {
                return "二维码不存在";
            }
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            result = formatReader.decode(binaryBitmap, hints);
        } catch (NotFoundException e) {
        	logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return result;
    }


    /**
     * 通过Excel报表的URL获取到对应PDF报表的URL
     *
     * @param excelUrl
     * @return
     * @throws Exception
     */
    public static String getPdfReportUrl(String excelUrl, String pdfUrl) throws Exception {
        if (UtilString.isNullOrEmpty(excelUrl) || UtilString.isNullOrEmpty(pdfUrl)) {
            throw new Exception("找不到相应的报表");
        }
        // connect to an OpenOffice.org instance running on port 8100
        //TODO 获取端口
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
        connection.connect();
        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
        File inputFile = new File(excelUrl);
        File outputFile = new File(pdfUrl);
        converter.convert(inputFile, outputFile);
        connection.disconnect();
        return pdfUrl;
    }

    /**
     * 将一个集合分割成数个固定size的集合
     *
     * @param sourceList
     * @param count
     * @param <T>
     * @return
     */
    public static <T> List<? extends List<?>> splitCollection(List<?> sourceList, int count) {

        List<?> arrayitem = Lists.newArrayList(sourceList);
        List<? extends List<?>> subList = Lists.partition(arrayitem, count);

        return subList;
    }

    /**
     * 二维码输出路径
     * @return
     * @throws Exception
     */
    public static String getOutPutQrCodePath()throws Exception {
        String filePath = ResourceUtils.getURL("classpath:").getPath();
        File file = new File(filePath, Constant.OUTPUTFILE_QRCODE_PATH);
        if (!file.isDirectory()) FileUtils.forceMkdir(file);
        return file.getPath() + File.separator + System.currentTimeMillis();
    }

    /**
     * 单据文件输出路径
     *
     * @return
     * @throws Exception
     */
    public static String getOutPutFilePath() throws Exception {
        String filePath = ResourceUtils.getURL("classpath:").getPath();
        File file = new File(filePath, Constant.OUTPUTFILE_TABLE_PATH);
        if (!file.isDirectory()) FileUtils.forceMkdir(file);
        return file.getPath() + File.separator + System.currentTimeMillis();
    }

    /**
     * 标签文件输出路径
     *
     * @return
     * @throws Exception
     */
    public static String getOutPutLabelPath() throws Exception {
        String filePath = ResourceUtils.getURL("classpath:").getPath();
        File file = new File(filePath, Constant.OUTPUTFILE_LABEL_PATH);
        if (!file.isDirectory()) FileUtils.forceMkdir(file);
        return file.getPath() + File.separator + System.currentTimeMillis();
    }

    /**
     * 二维码文件输出路径
     *
     * @return
     * @throws Exception
     */
    public static String getOutPutQRCodePath() throws Exception {

        String filePath = ResourceUtils.getURL("classpath:").getPath();

        File file = new File(filePath, Constant.OUTPUTFILE_QRCODE_PATH);
        if (!file.isDirectory()) FileUtils.forceMkdir(file);
        return file.getPath() + File.separator + System.currentTimeMillis();
    }


    /**
     * 向excel插入图片
     *
     * @param workbook
     * @param imgPath
     * @param sheetCount
     * @param firstCol img
     * @param firstRow img
     * @param lastCol  img
     * @param lastRow  img
     * @return
     * @throws Exception
     */
    public static Workbook putImage(Workbook workbook, String imgPath, int sheetCount, short firstCol, int firstRow, short lastCol, int lastRow) throws Exception {
        Sheet sheet = workbook.getSheetAt(sheetCount);
        if (UtilString.isNullOrEmpty(imgPath)) {
            throw new Exception("传入的图片地址为空");
        }
        ByteArrayOutputStream byteArrayOutHN = new ByteArrayOutputStream();
        Drawing patriarch = sheet.createDrawingPatriarch();
        BufferedImage bufferImgHN = ImageIO.read(new File(imgPath));
        ImageIO.write(bufferImgHN, "png", byteArrayOutHN);
        patriarch = sheet.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, firstCol, firstRow, lastCol, lastRow);
        patriarch.createPicture(anchor, workbook.addPicture(byteArrayOutHN.toByteArray(), Workbook.PICTURE_TYPE_PNG));

        return workbook;
    }


    /**
     * 调用easypoi 生成execl
     *
     * @param list
     * @param title
     * @param sheetName
     * @param pojoClass
     * @param fileName
     * @param isCreateHeader
     * @param response
     * @param isDownload
     */
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response, boolean isDownload) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams, isDownload);

    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response, boolean isDownload) {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName), isDownload);
    }
    
    public static void exportExcel(List<?> list,List<ExcelExportEntity> excelExportEntity,String title, String sheetName, String fileName, HttpServletResponse response, boolean isDownload) {
        defaultExport(list, excelExportEntity, fileName, response, new ExportParams(title, sheetName), isDownload);
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list,List<ExcelExportEntity> excelExportEntity, String fileName, HttpServletResponse response, ExportParams exportParams, boolean isDownload) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, excelExportEntity, list);
        
        if (isDownload) downLoadExcel(fileName, response, workbook);
    }
    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams, boolean isDownload) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        
        if (isDownload) downLoadExcel(fileName, response, workbook);
    }
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            // throw new NormalException(e.getMessage());
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            // throw new NormalException("模板不能为空");
        } catch (Exception e) {
        	logger.error(e.getMessage());
            //  throw new NormalException(e.getMessage());
        }
        return list;
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) throws Exception {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        return list;
    }

    /**
     * 下划线转驼峰
     *
     * @param para
     * @return
     */
    public static String UnderlineToHump(String para) {

        StringBuilder result = new StringBuilder();
        String p[] = para.split("_");
        for (String s : p) {
            result.append(s.substring(0, 1).toUpperCase());
            result.append(s.substring(1).toLowerCase());
        }
        return result.toString();

    }


}

package com.inossem.wms.service.impl.common;

import java.awt.print.Book;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import javax.annotation.PostConstruct;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.printing.PDFPageable;
//import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.inossem.wms.common.util.UtilObject;
import com.inossem.wms.enums.EnumPrintType;
import com.inossem.wms.service.common.IPrintService;

/**
 *  instock打印service
 * @author : sw
 * @date : 2019/1/23
 */
@Service
public class PrintServiceImpl implements IPrintService{

    //日志对象
    private static final Logger logger = LoggerFactory.getLogger(PrintServiceImpl.class);

    //是否是windows系统
    private static Boolean IS_WINDOWS = true;

    //默认编码集
    private static String CHAR_SET = "gb2312";

    //默认打印机端口号
    private static Integer PRINT_PORT = 9100;

    // 打印机服务
    private PrintService printService = null;

    /**
     * 核心打印方法
     * @param printer 打印机名称：linux打印zpl可以为空/pdf空取默认打印服务
     * @param ip 打印机ip： windows下可以为空
     * @param printType 打印类型 ：EnumPrintType
     * @param param 打印参数 ：1.pdf为url 2.zpl为zpl表达式
     * @return 打印成功次数
     */
    @Override
    public Integer print(String printer,String ip, Byte printType, String... param){
        Integer result = 0;
        if(param.length >0){
            initPrintService(printer);
            if(printType.equals(EnumPrintType.PDF.getValue())){
                for(String u : param){
                    printPdf(u);
                    result++;
                }
            } else if(printType.equals(EnumPrintType.ZPL.getValue())){
                for(String u : param){
                    printZpl(ip,u);
                    result++;
                }
            }
        } else{
            logger.info("打印异常 > {}","param 数据错误为空");
        }
        return result;
    }

    /**
     * 打印pdf方法
     * @param url
     */
    private void printPdf(String url){
        logger.info("打印信息 > {}","当前系统环境为IS_WINDOWS = "+IS_WINDOWS);
        if(printService != null){
            File file = new File(url);
            if(file.exists()){
                InputStream fis = null ;
                try {
                    fis = new FileInputStream(file);
                    PDDocument document = PDDocument.load(fis);
                    Book book =new PDFPageable(document);
                    PrinterJob job = PrinterJob.getPrinterJob();
                    job.setPrintService(printService);
                    job.setPageable(book);
                    job.print();
                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
                    logger.info("打印信息 > {}",e.getMessage());
                } catch (InvalidPasswordException e) {
//                    e.printStackTrace();
                    logger.info("打印信息 > {}",e.getMessage());
                } catch (IOException e) {
//                    e.printStackTrace();
                    logger.info("打印信息 > {}",e.getMessage());
                } catch (PrinterException e) {
//                    e.printStackTrace();
                    logger.info("打印信息 > {}",e.getMessage());
                }
            }else{
                logger.info("打印信息 > {}",url+"文件不存在");
            }
        } else{
          logger.info("打印信息 > {}","没有找到合适的打印服务");
        }
    }

    /**
     * zpl打印
     * @param ip
     * @param zpl
     */
    private void printZpl(String ip,String zpl) {
        logger.info("打印信息 > {}","当前系统环境为IS_WINDOWS = "+IS_WINDOWS);
        logger.info("打印信息 > {}","zpl表达式为: "+zpl);
        if(IS_WINDOWS){
            if(printService != null){
                DocPrintJob job = printService.createPrintJob();
                byte[] bytes = new byte[0];
                try {
                    bytes = zpl.getBytes(CHAR_SET);
                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
                    logger.info("打印信息 > {}",e.getMessage());
                }
                DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
                Doc doc = new SimpleDoc(bytes, flavor, null);
                try {
                    job.print(doc, null);
                } catch (PrintException e) {
//                    e.printStackTrace();
                    logger.info("打印信息 > {}",e.getMessage());
                }
            } else{
                logger.info("打印信息 > {}","没有找到合适的打印服务");
            }
        } else {
            try {
                Socket socket = new Socket(ip, PRINT_PORT);
                logger.info("打印信息 > {}","socket连接创建成功: "+ip+":"+PRINT_PORT);
                OutputStream socketOut = socket.getOutputStream();
                socketOut.write(zpl.getBytes("gb2312"));
                logger.info("打印信息 > {}",socket);
                socket.close();
            } catch (IOException e) {
//                e.printStackTrace();
                logger.info("打印信息 > {}",e.getMessage());
            }
        }
    }

    /**
     * 通用初始化打印服务
     * @param printer
     */
    private void initPrintService(String printer){
        if(UtilObject.getStringOrNull(printer) != null){
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            if(services!=null && services.length>0){
                for (PrintService service : services) {
                    if (printer.equals(service.getName())) {
                        printService = service;
                        logger.info("打印信息 > {}","成功匹配打印机"+printer);
                        break;
                    }
                }
            } else{
                logger.error("打印信息 > {}","没有找到合适的打印服务");
            }
        } else {
            //没有传入打印机名字取系统默认打印机
            printService = PrintServiceLookup.lookupDefaultPrintService();
        }
    }

    /**
     * 查询系统os
     */
    @PostConstruct
    private void init(){
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            IS_WINDOWS = true;
        } else if (os.toLowerCase().startsWith("linux")){
            IS_WINDOWS = false;
        } else{
            IS_WINDOWS = false;
            logger.info("打印信息 > {}","不支持win,linux以外的系统");
        }
    }
    //测试用例
    //@Test
//    public void test(){
//        try {
//            String zpl = "^XA^RFW,H^FD112233445566778899001122^FS^XZ";
//            print("ZDesigner ZT410R-203dpi ZPL", "", EnumPrintType.ZPL.getValue(), zpl);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

}

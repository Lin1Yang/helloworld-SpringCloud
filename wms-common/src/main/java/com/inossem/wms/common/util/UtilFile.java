package com.inossem.wms.common.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import com.inossem.wms.constant.Const;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class UtilFile {

    public static boolean previewPdf(String fileName, HttpServletResponse response) throws IOException {

        boolean status = false;
        if(fileName != null){
            File file = new File(fileName);
            if(file.exists()){
                response.reset();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition",
                        "inline;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
                InputStream inputStream = null;
                try {
                    ServletOutputStream outputStream = response.getOutputStream();
                    inputStream = new FileInputStream(file);
                    int i = IOUtils.copy(inputStream,outputStream);
                    status = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(inputStream!=null){
                        inputStream.close();
                    }
                }
            }
        }
        return status;
    }

    public static boolean downloadExcel(String fileName, HttpServletResponse response) throws IOException {

        boolean status = false;
        if(fileName != null){
            File file = new File(fileName);
            if(file.exists()){
                response.reset();
                response.setCharacterEncoding("UTF-8");
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
                InputStream inputStream = null;
                try {
                    ServletOutputStream outputStream = response.getOutputStream();
                    inputStream = new FileInputStream(file);
                    int i = IOUtils.copy(inputStream,outputStream);
                    status = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(inputStream!=null){
                        inputStream.close();
                    }
                }
            }
        }
        return status;
    }

    public static String convertTemplatePath(String path) {

        Resource resource = new ClassPathResource(path);
        FileOutputStream fileOutputStream = null;
        // 将模版文件写入到 tomcat临时目录
        String folder = System.getProperty("catalina.home");
        File tempFile = new File(folder + File.separator + path);
        // System.out.println("文件路径：" + tempFile.getPath());
        // 文件存在时 不再写入
//        if (tempFile.exists()) {
//            return tempFile.getPath();
//        }
        File parentFile = tempFile.getParentFile();
        // 判断父文件夹是否存在
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(resource.getInputStream());
            fileOutputStream = new FileOutputStream(tempFile);
            byte[] buffer = new byte[10240];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tempFile.getPath();
    }
    
    /**
     * 校验上传的文件拓展名是否在白名单中
     * 
     * @param extension
     * @return true 在, false 不在
     * @author 李斌
     */
    public static boolean checkFileExtension(String extension) {
    	return Const.ALLOWED_UPLOAD_FILE_EXTENSION_SET.contains(extension.toLowerCase());
    }
}

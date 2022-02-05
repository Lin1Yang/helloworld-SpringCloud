package com.inossem.wms.common.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
/**
 * 图片压缩与裁剪工具类
 * @author cdq
 *
 */
public class UtilImage {
	
	private static final Logger logger = LoggerFactory.getLogger(UtilImage.class);
    /**
     * 制定大小缩放，以设置参数横200高300为例，若图片横比200小，高比300小，不变
     * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
     * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
     * @param input 输入图片文件
     * @param output 图片输出目标文件
     * @param width 设置缩放宽度
     * @param height 设置缩放高度
     * @param autoRename 自动重命名，改属性为true的时候输出路径可以是个目录，输出图片将自动重命名成：【输入图片文件名_宽度*高度.输入文件扩展名】;
     *                   如果输出文件为文件，将重命名为：【输出图片文件名_宽度*高度.输入文件扩展名】
     * @param changeFileType 是否改变图片格式，true改变格式，应用输出扩展名格式
     * @param keepAspectRatio  是否保持缩放比例
     * @return 输出路径
     * @throws IOException
     */
    public static File zoomByHeightAndWidth(File input,File output,int width,int height,boolean autoRename,boolean changeFileType,boolean keepAspectRatio) throws IOException{
        if(!input.isFile()){
            return null;
        }
        String inputFileType=input.getName().substring(input.getName().lastIndexOf("."));
        String outputFileType;
        StringBuilder sb;
        if(output.isDirectory()){
            outputFileType = inputFileType;
            sb = new StringBuilder(output.getPath()).append(File.separatorChar).append(input.getName().replaceAll("[.][^.]+$", ""));
        }else{
            outputFileType = output.getName().substring(input.getName().lastIndexOf("."));
            sb = new StringBuilder(output.getPath().replaceAll("[.][^.]+$", ""));
        }
        if(autoRename){
            sb.append("_").append(width).append("X").append(height);
        }

        if (changeFileType) {
            output = new File(sb.append(outputFileType).toString());
            Thumbnails.of(input).size(width, height).keepAspectRatio(keepAspectRatio).toFile(output);
        } else {
            output = new File(sb.append(inputFileType).toString());
            Thumbnails.of(input).size(width, height).keepAspectRatio(keepAspectRatio).outputFormat(outputFileType.replace(".", "")).toFile(output);
        }
        return output;
    }

    /**
     * 制定大小缩放，以设置参数横200高300为例，若图片横比200小，高比300小，不变
     * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
     * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
     * @param input 输入图片文件
     * @param output 图片输出目标文件
     * @param width 设置缩放宽度
     * @param height 设置缩放高度
     * @param keepAspectRatio  是否保持缩放比例
     * @return 输出路径
     * @throws IOException
     */
    public static File zoomByHeightAndWidth(File input,File output,int width,int height,boolean keepAspectRatio) throws IOException {
        return UtilImage.zoomByHeightAndWidth(input,output,width,height,false,false,keepAspectRatio);
    }
    /**
     * 制定大小缩放，以设置参数横200高300为例，若图片横比200小，高比300小，不变
     * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
     * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
     * @param input 输入图片文件
     * @param output 图片输出目标文件
     * @param width 设置缩放宽度
     * @param height 设置缩放高度
     * @return 输出路径
     * @throws IOException
     */
    public static File zoomByHeightAndWidth(File input,File output,int width,int height) throws IOException {
        return UtilImage.zoomByHeightAndWidth(input,output,width,height,false,false,false);
    }


        /**
         * ***********按比例进行缩放***********
         * @param input 输入图片文件
         * @param output 图片输出目标文件
         * @param proportion 设置缩放比例，float类型，0.5表示50%
         * @param autoRename 自动重命名，改属性为true的时候输出路径可以是个目录，输出图片将自动重命名成：【输入图片文件名_宽度*高度.输入文件扩展名】;
         *                   如果输出文件为文件，将重命名为：【输出图片文件名_宽度*高度.输入文件扩展名】
         * @param changeFileType 是否改变图片格式，true改变格式，应用输出扩展名格式
         * @return
         * @throws IOException
         */
    public static File zoomByHeightAndWidthInProportion(File input,File output,float proportion,boolean autoRename,boolean changeFileType) throws IOException{
        if(!input.isFile()){
            return null;
        }
        String inputFileType=input.getName().substring(input.getName().lastIndexOf("."));
        String outputFileType;
        StringBuilder sb;
        if(output.isDirectory()){
            outputFileType = inputFileType;
            sb = new StringBuilder(output.getPath()).append(File.separatorChar).append(input.getName().replaceAll("[.][^.]+$", ""));
        }else{
            outputFileType = output.getName().substring(input.getName().lastIndexOf("."));
            sb = new StringBuilder(output.getPath().replaceAll("[.][^.]+$", ""));
        }
        if(autoRename){
            sb.append("_").append(proportion*100).append("%");
        }

        if (changeFileType) {
            output = new File(sb.append(outputFileType).toString());
            Thumbnails.of(input).scale(proportion).toFile(output);
        } else {
            output = new File(sb.append(inputFileType).toString());
            Thumbnails.of(input).scale(proportion).outputFormat(outputFileType.replace(".", "")).toFile(output);
        }
        return output;
    }
    /**
	 * 裁剪图片按坐标
	 * @throws IOException
	 */
	public static void region(File input, File output, int x, int y, int width, int height)
			throws IOException {
		String inputFileType = input.getName().substring(input.getName().lastIndexOf("."));
		String outputFileType = null;
		StringBuilder sb = null;
		if (output.isDirectory()) {
			outputFileType = inputFileType;
			sb = new StringBuilder(output.getPath()).append(File.separatorChar)
					.append(input.getName().replaceAll("[.][^.]+$", "")).append("_cut");
		}
		if(outputFileType!=null&&!outputFileType.equals("")){
			output = new File(sb.append(outputFileType).toString());
		}
		// 指定坐标
		Thumbnails.of(input).sourceRegion(x, y, width, height)// x轴、y轴，裁剪宽、裁剪高
				.size(width, height)// 裁剪后的图片生成的尺寸
				// 设置是否按比例 false,图片可能会走形 默认true,必须在设置尺寸后设置
				.keepAspectRatio(false).toFile(output);

	}
	/**
	 * 裁剪图片按位置   例如 中心区域   左上角  
	 * @throws IOException
	 */
	public static File region(File input, File output,int width,int height, Positions position) throws IOException {
		String inputFileType = input.getName().substring(input.getName().lastIndexOf("."));
		String outputFileType = null;
		StringBuilder sb = null;
		if (output.isDirectory()) {
			outputFileType = inputFileType;
			sb = new StringBuilder(output.getPath()).append(File.separatorChar)
					.append(input.getName().replaceAll("[.][^.]+$", "")).append("_cut");
		}
		if(outputFileType!=null&&!outputFileType.equals("")){
			//文件(不是文件夹)
			File newoutput = new File(sb.append(outputFileType).toString());
			// 指定位置
			Thumbnails.of(input).sourceRegion(position, width, height)// x轴、y轴，裁剪宽、裁剪高
					.size(width, height)// 裁剪后的图片生成的尺寸
					// 设置是否按比例 false,图片可能会走形 默认true,必须在设置尺寸后设置
					.keepAspectRatio(false).toFile(newoutput);
			return newoutput;
		}else{
			return null;
		}
		
	}
	/**
	 * 旋转图片
	 * @param sourceImage 原图片
	 * @param newImage 生成的新图片
	 * @param degrees 旋转度数
	 * @throws IOException
	 */
	public static void rorate(File input, File output,double degrees) throws IOException{
		String inputFileType = input.getName().substring(input.getName().lastIndexOf("."));
		String outputFileType = null;
		StringBuilder sb = null;
		if (output.isDirectory()) {
			outputFileType = inputFileType;
			sb = new StringBuilder(output.getPath()).append(File.separatorChar)
					.append(input.getName().replaceAll("[.][^.]+$", "")).append("_rotate");
		}
		if(outputFileType!=null&&!outputFileType.equals("")){
			output = new File(sb.append(outputFileType).toString());
			Thumbnails.of(input)
			.rotate(degrees)//旋转度数
			.scale(1)//缩放比例
			.toFile(output);
		}
		
	}
	/**
	 * 添加图片水印
	 * 
	 * @param targetImg
	 *            目标图片路径，如：C:\\myPictrue\\1.jpg
	 * @param waterImg
	 *            水印图片路径，如：C:\\myPictrue\\logo.png
	 * @param positions 水印图片所在位置
	 * 
	 * @param alpha
	 *            透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明) * @param quality 压缩清晰度
	 *            <b>建议为1.0</b>
	 * @throws IOException 
	 */
	public final static void pressImage(File input, File output, Positions positions, float alpha) throws IOException {
		String inputFileType = input.getName().substring(input.getName().lastIndexOf("."));
		String outputFileType = null;
		StringBuilder sb = null;
		if (output.isDirectory()) {
			outputFileType = inputFileType;
			sb = new StringBuilder(output.getPath()).append(File.separatorChar)
					.append(input.getName().replaceAll("[.][^.]+$", "")).append("_watermark");
		}
		if(outputFileType!=null&&!outputFileType.equals("")){
			output = new File(sb.append(outputFileType).toString());
			Thumbnails.of(input)
			.watermark(positions, ImageIO.read(output), alpha)
			.scale(1)//缩放比例
			.toFile(input);
		}
		
	}
    public static void main(String args[]){
  	  File file = new File("C:\\Users\\cdq\\Desktop\\img\\2537d07bb5fb98cdcfc54b5e885f3f1a.jpg");
      File out = new File("C:\\Users\\cdq\\Desktop\\img");
      File fileOut=null;
      try {
//          fileOut =UtilImage.zoomByHeightAndWidth(file,out,400,300,true,false,false);
//          zoomByHeightAndWidthInProportion(file, out, 1f, true, false);
//      	File newoutput = region(file,out,Positions.CENTER);
    	  Image img = ImageIO.read(file);
			int imgWidth = img.getWidth(null), imgHeight = img.getHeight(null);
			int width = 0, height = 0;
    	  if (imgWidth > imgHeight) {
				width = 200;
				height =(imgHeight*200/imgWidth);
				System.out.println(height);
			} else {
				
				height = 200;
				width =(imgWidth*200/imgHeight);
				System.out.println(width);
			}
    	  zoomByHeightAndWidth(file, out, width, height, true, false, false);
      } catch (IOException e) {
    	  logger.error(e.getMessage());
      }
    }
//    @Test
//    public void test(){
//    
//    }
}

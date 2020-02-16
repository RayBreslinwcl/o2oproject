package com.java.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageUtil {
//	public static void main(String[] args) {
//		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		try {
//			Thumbnails.of(new File("E:\\Tools\\picture\\测试图片1.png")).size(200,200)
//    //				.watermark(Positions.BOTTOM_CENTER,ImageIo.read)
//            .outputQuality(0.8f).toFile("E:\\Tools\\picture\\测试图片1new.png");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();


	/**
	 * 创建缩略图片文件
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
		String realFileName = PathUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail); //获取文件扩展名称
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}


	/**
	 * 获得目标路径，如果没有则创建
	 *
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
//

	/**
	 * 扩展名
	 * @param cFile
	 * @return
	 */
	private static String getFileExtension(CommonsMultipartFile cFile) {
		String originalFileName = cFile.getOriginalFilename();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}
}

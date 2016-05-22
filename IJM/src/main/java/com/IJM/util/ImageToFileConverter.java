package com.IJM.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.IJM.model.Image;

public class ImageToFileConverter {

	private static String destination = "C:\\IJM\\Images\\Product" ;
	public static boolean convertStringToFile(Image image) throws NullPointerException, FileAlreadyExistsException, IOException
	{
		InputStream in = new ByteArrayInputStream(image.getFile());
		BufferedImage f=ImageIO.read(in);
		
		String imageFolder = destination+"\\"+image.getProduct().getCode();
		File destFolder  = new File(imageFolder);
		(destFolder).mkdirs();
		
		String name = image.getProduct().getCode()+"."+image.getExtension();
		
		ImageProcessor.processImage(f, destFolder , "xhdpi", "ldpi",name);
		ImageProcessor.processImage(f, destFolder , "xhdpi", "mdpi",name);
		ImageProcessor.processImage(f, destFolder , "xhdpi", "hdpi",name);
		return true;
	}
}

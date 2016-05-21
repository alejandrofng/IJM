package com.IJM.util;

import java.io.File;

import com.IJM.model.Image;

public class ImageToFileConverter {

	public static boolean convertStringToFile(Image image)
	{
		File destination = new File("C:\\IJM\\images\\product");
		//ImageProcessor.processImage(f, destination , originalSize, resFolder);
		return true;
	}
}

package com.IJM.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;

import org.w3c.dom.NodeList;


public class DpiCalculator {
	
	private ImageInputStream stream;
	private Iterator<ImageReader> readers;
	private File file;
	private IIOMetadata metadata; 
    private IIOMetadataNode standardTree;
    private IIOMetadataNode dimension;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) throws IOException {
		
		try {
			stream = ImageIO.createImageInputStream(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.file = file;
        readers = ImageIO.getImageReaders(stream);
        
        if (readers.hasNext()) {
            ImageReader reader = readers.next();
            reader.setInput(stream);

            metadata = reader.getImageMetadata(0);
            standardTree = (IIOMetadataNode) metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);
            dimension = (IIOMetadataNode) standardTree.getElementsByTagName("Dimension").item(0);
        }
        
	}

	public double getHorizontal()
	{
        int horizontalPixelSizeMM = getPixelSizeMM(dimension, "HorizontalPixelSize");
        return horizontalPixelSizeMM*25.4;
	}
	public double getVertical()
	{
	    int verticalPixelSizeMM = getPixelSizeMM(dimension, "VerticalPixelSize");
	    return verticalPixelSizeMM*25.4;
	}
	
	private static int getPixelSizeMM(final IIOMetadataNode dimension, final String elementName) {
	    // NOTE: The standard metadata format has defined dimension to pixels per millimeters, not DPI...
	    NodeList pixelSizes = dimension.getElementsByTagName(elementName);
	    IIOMetadataNode pixelSize = pixelSizes.getLength() > 0 ? (IIOMetadataNode) pixelSizes.item(0) : null;
	    return pixelSize != null ? Integer.parseInt(pixelSize.getAttribute("value")) : -1;
	}
}


package com.IJM.service;

import com.IJM.model.Image;

public interface ImageService {
	public void saveImage(Image  image);
	
	void updateImage(Image image);
	
	public void deleteImage(long id);
	
	public Image findImageById (long id);
}

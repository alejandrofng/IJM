package com.IJM.service;

import com.IJM.dto.ImageDto;
import com.IJM.model.Image;

public interface ImageService {
	public void saveImage(ImageDto  imageDto);
	
	public void saveImage(Image  image);
	
	void updateImage(ImageDto ImageDto);
	
	public void deleteImage(long id);
	
	public ImageDto findImageDtoById (long id);

	Image findImageById(long id);
}

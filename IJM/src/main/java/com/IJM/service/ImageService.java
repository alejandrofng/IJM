package com.IJM.service;

import com.IJM.dto.ImageDto;

public interface ImageService {
	public void saveImage(ImageDto  imageDto);
	
	void updateImage(ImageDto ImageDto);
	
	public void deleteImage(long id);
	
	public ImageDto findImageDtoById (long id);
}

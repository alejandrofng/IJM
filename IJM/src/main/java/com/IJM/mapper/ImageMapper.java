package com.IJM.mapper;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.IJM.dto.ImageDto;
import com.IJM.model.Image;
import com.IJM.util.ChecksumConverter;

public class ImageMapper {

	public static ImageDto EntityToDto(Image image) {
		ImageDto imageDto = new ImageDto();
		imageDto.setId(image.getId());
		imageDto.setFile(Base64.getEncoder().encodeToString((image.getFile())));
		System.out.print(imageDto.getFile());
		return imageDto;
	}


	public static Image DtoToEntity(ImageDto imageDto) {
		Image image = new Image();
		byte[] newPicture = Base64.getDecoder().decode(imageDto.getFile());
		image.setFile(newPicture);
		try {
			image.setChecksum(ChecksumConverter.getSHA(newPicture));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static Image DtoToEntity(ImageDto imageDto, Image image) {
		byte[] newPicture = Base64.getDecoder().decode(imageDto.getFile());
		image.setFile(newPicture);
		try {
			image.setChecksum(ChecksumConverter.getSHA(newPicture));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return image;
	}
}

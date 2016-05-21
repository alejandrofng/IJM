package com.IJM.mapper;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import com.IJM.dto.ImageDto;
import com.IJM.model.FileType;
import com.IJM.model.Image;
import com.IJM.util.ChecksumConverter;

public class ImageMapper {

	public static ImageDto EntityToDto(Image image) {
		ImageDto imageDto = new ImageDto();
		imageDto.setId(image.getId());
		imageDto.setFile(Base64.getEncoder().encodeToString((image.getFile())));
		imageDto.setExtension(image.getExtension());
		imageDto.setChecksum(image.getChecksum());
		imageDto.setFile_name(image.getFile_name());
		imageDto.setSize(image.getSize());
		return imageDto;
	}


	public static Image DtoToEntity(ImageDto imageDto) {
		Image image = new Image();
		byte[] newPicture = Base64.getDecoder().decode(imageDto.getFile());
		image.setFile(newPicture);
		try {
			image.setChecksum(ChecksumConverter.getSHA(newPicture));
			image.setExtension(imageDto.getExtension());
			image.setFile_name(imageDto.getFile_name());
			image.setSize(imageDto.getSize());
			FileType ft = new FileType();
			ft.setId(1);
			image.setFileType(ft);
			java.util.Date date= new java.util.Date();
			image.setLast_Updated(new Timestamp(date.getTime()));
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
			image.setExtension(imageDto.getExtension());
			image.setFile_name(imageDto.getFile_name());
			image.setSize(imageDto.getSize());
			java.util.Date date= new java.util.Date();
			image.setLast_Updated(new Timestamp(date.getTime()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return image;
	}
	public static Set<ImageDto> EntitySetToDtoSet(Set<Image> images) {
		Set<ImageDto> imagesDto = new HashSet<ImageDto>();
		for (Image image : images) {
		    ImageDto imageDto = ImageMapper.EntityToDto(image);
		    imagesDto.add(imageDto);
		}
		return imagesDto;
	}
	public static Set<Image> DtoSetToEntitySet(Set<ImageDto> imagesDto) {
		Set<Image> images = new HashSet<Image>();
		for (ImageDto imageDto : imagesDto) {
			Image image = ImageMapper.DtoToEntity(imageDto);
			images.add(image);
		}
		return images;
	}
}

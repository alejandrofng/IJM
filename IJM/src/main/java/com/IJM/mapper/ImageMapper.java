package com.IJM.mapper;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.IJM.dto.ImageDto;
import com.IJM.model.Directory;
import com.IJM.model.Image;
import com.IJM.service.ImageService;
import com.IJM.util.ChecksumConverter;

public class ImageMapper {

	@Autowired
	ImageService imageService;
	
	public ImageDto EntityToDto(Image image) {
		ImageDto imageDto = new ImageDto();
		imageDto.setId(image.getId());
		imageDto.setFile(DatatypeConverter.printBase64Binary((image.getFile())));
		imageDto.setExtension(image.getExtension());
		imageDto.setChecksum(image.getChecksum());
		imageDto.setFile_name(image.getFile_name());
		imageDto.setSize(image.getSize());
		return imageDto;
	}


	public Image DtoToEntity(ImageDto imageDto) {
		Image image = new Image();
		if(imageDto.getId()==null)
		{
			String file = imageDto.getFile().replace("data:image/jpeg;base64,","");
			byte[] newPicture = DatatypeConverter.parseBase64Binary(file);
			String extension = imageDto.getExtension().replace("image/","");
			image.setExtension(extension);
			image.setFile_name(imageDto.getFile_name());
			image.setSize(imageDto.getSize());
			java.util.Date date= new java.util.Date();
			image.setLast_Updated(new Timestamp(date.getTime()));
			
			image.setFile(newPicture);
			try {
				image.setChecksum(ChecksumConverter.getSHA(newPicture));
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		else image= imageService.findImageById(imageDto.getId());
		return image;
	}
	
	public Image DtoToEntity(ImageDto imageDto, Image image) {
		byte[] newPicture = DatatypeConverter.parseBase64Binary(imageDto.getFile());
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
	public Set<ImageDto> EntitySetToDtoSet(Set<Image> images) {
		Set<ImageDto> imagesDto = new HashSet<ImageDto>();
		for (Image image : images) {
		    ImageDto imageDto = this.EntityToDto(image);
		    imagesDto.add(imageDto);
		}
		return imagesDto;
	}
	public Set<Image> DtoSetToEntitySet(Set<ImageDto> imagesDto, Directory directory) {
		Set<Image> images = new HashSet<Image>();
		for (ImageDto imageDto : imagesDto) {
			Image image = this.DtoToEntity(imageDto);
			image.setDirectory(directory);
			images.add(image);
		}
		return images;
	}
}

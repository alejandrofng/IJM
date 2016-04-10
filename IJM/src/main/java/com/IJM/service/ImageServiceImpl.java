package com.IJM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.ImageDao;
import com.IJM.dto.ImageDto;
import com.IJM.mapper.ImageMapper;
import com.IJM.model.Image;

@Transactional
@Service("imageService")
public class ImageServiceImpl implements ImageService{

	@Autowired
	ImageDao imageDao;
	
	@Override
	public ImageDto findImageDtoById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveImage(ImageDto imageDto) {
		imageDao.save(ImageMapper.DtoToEntity(imageDto));
		
	}

	@Override
	public void updateImage(ImageDto imageDto) {
		Image image = imageDao.findById(imageDto.getId());
		imageDao.update(ImageMapper.DtoToEntity(imageDto,image));
		
	}

	@Override
	public void deleteImage(long id) {
		Image image = imageDao.findById(id);
		imageDao.delete(image);
		
	}

}
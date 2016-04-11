package com.IJM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.ImageDao;
import com.IJM.model.Image;

@Transactional
@Service("imageService")
public class ImageServiceImpl implements ImageService{

	@Autowired
	ImageDao imageDao;
	
	@Override
	public Image findImageById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveImage(Image image) {
		imageDao.save(image);
		
	}

	@Override
	public void updateImage(Image image) {
		imageDao.update(image);
		
	}

	@Override
	public void deleteImage(long id) {
		Image image = imageDao.findById(id);
		imageDao.delete(image);
		
	}

}

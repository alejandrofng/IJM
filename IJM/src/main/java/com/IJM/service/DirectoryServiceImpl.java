package com.IJM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.DirectoryDao;
import com.IJM.model.Directory;
@Transactional
@Service("directoryService")
public class DirectoryServiceImpl implements DirectoryService{

	@Autowired
	DirectoryDao directoryDao;
	
	@Override
	public void saveDirectory(Directory directory) {
		directoryDao.save(directory);
		
	}

	@Override
	public void updateDirectory(Directory directory) {
		directoryDao.update(directory);
		
	}

	@Override
	public void deleteDirectory(long id) {
		Directory directory = directoryDao.findById(id);
		directoryDao.delete(directory);
		
	}

	@Override
	public Directory findDirectoryById(long id) {
		return directoryDao.findById(id);
	}

	@Override
	public Directory findDirectoryByName(String name) {
		return directoryDao.findByName(name);
	}

}

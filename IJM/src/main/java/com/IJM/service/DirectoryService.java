package com.IJM.service;

import com.IJM.model.Directory;

public interface DirectoryService {
	public void saveDirectory(Directory  directory);
	
	void updateDirectory(Directory directory);
	
	public void deleteDirectory(long id);
	
	public Directory findDirectoryById (long id);
	
	public Directory findDirectoryByName(String name);
}

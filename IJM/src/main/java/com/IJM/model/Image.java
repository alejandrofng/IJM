package com.IJM.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private long id;
	
	@Lob
	@Column(name = "File", nullable = false)
	private byte[] file;
	
	@Column(name = "Checksum",nullable = false)
	private String checksum;
	
	@Column(name = "Extension",nullable = false)
	private String extension;
	
	@Column(name = "File_Name",nullable = false)
	private String file_name;
	
	@Column(name = "Size",nullable = false)
	private int size;
	
	@Column(name = "Id_File_Type",nullable = false)
	private FileType fileType;

	@Column(name = "Last_Updated",nullable = false)
	private Timestamp last_Updated;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public Timestamp getLast_Updated() {
		return last_Updated;
	}

	public void setLast_Updated(Timestamp last_Updated) {
		this.last_Updated = last_Updated;
	}
	
	
	
}

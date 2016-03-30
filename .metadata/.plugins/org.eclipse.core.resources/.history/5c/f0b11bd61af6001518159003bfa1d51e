package com.ktds.muco.util.file;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

public class MultipartFile {
	private String fileName;
	private long fileSize;
	private String contentType;
	private FileItem fileItem;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setFileItem(FileItem fileItem) {
		this.fileItem = fileItem;
	}

	public File write(String dest) {
		File file = new File(dest);
		try {
			fileItem.write(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file;
	}
}
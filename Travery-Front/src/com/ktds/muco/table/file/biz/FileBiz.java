package com.ktds.muco.table.file.biz;

import java.io.File;

import com.ktds.muco.table.file.dao.FileDAO;

/**
 * 
 * @author 백지경
 *
 */
public class FileBiz {

	private FileDAO fileDAO;

	public FileBiz() {
		fileDAO = new FileDAO();
	}

	/**
	 * 
	 * @author 백지경
	 *
	 */
	public void uploadPackImgFile(int packId, File file) {
		fileDAO.uploadPackImgFile(packId, file);

	}

}

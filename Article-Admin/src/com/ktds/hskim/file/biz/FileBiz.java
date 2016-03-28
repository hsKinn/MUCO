package com.ktds.hskim.file.biz;

import com.ktds.hskim.file.dao.FileDAO;
import com.ktds.hskim.file.vo.FileVO;

public class FileBiz {
	
	private FileDAO fileDAO;
	
	public FileBiz() {
		fileDAO = new FileDAO();
	}
	
	
	/**
	 * 파일 테이블 추가
	 */
	public boolean addFileList ( FileVO file ) {
		
		int checkAddFile = fileDAO.addFile(file);
		
		if ( checkAddFile > 0 ) {
			return true;
		}
		else {
			return false;
		}
	} //addFileList end
	
}

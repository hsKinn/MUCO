package com.ktds.muco.table.pack.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.pack.dao.PackDAO;
import com.ktds.muco.table.pack.vo.PackVO;

/**
 * 
 * @author 김광민
 *
 */
public class PackBiz {
	
	
	/**
	 * @author 백지경
	 */
	private PackDAO packDAO;
	
	public PackBiz() {
		packDAO = new PackDAO();
	}
	
	public List<PackVO> getPackListByEmail(String email){
		List<PackVO> packs = packDAO.getPackListByEmail(email);
		return packs;
	}

	public PackVO getPackDataByPackId(int packId) {
		PackVO pack = packDAO.getPackDataByPackId(packId);
		return pack;
	}
	
	

}

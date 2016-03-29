package com.ktds.muco.table.pack.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.pack.dao.PackDAO;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.table.place.vo.PlaceVO;

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

	public int addPack(PackVO newAddPack) {
		int packId = packDAO.addPack(newAddPack);
		return packId;
	}

	public int deletePacks(String[] deletePackIds) {
		int deleteCount = 0;
		for (String deletePackId : deletePackIds) {
			deleteCount=packDAO.deletePack(Integer.parseInt(deletePackId));
		}
		return deleteCount;
	}

	public List<PlaceVO> getPlaceListByPackId(int packId) {
		List<PlaceVO> places = packDAO.getPlaceListByPackId(packId);
		return places;
	}

	public int deletePlaceOfPack(int placeId, int packId) {
		int deletePlaceOfPackCount = 0;
		deletePlaceOfPackCount = packDAO.deletePlaceOfPack(placeId, packId);
		return deletePlaceOfPackCount;
	}

	public int modifyPack(PackVO modifyPack) {
		int modifyCount = 0;
		modifyCount = packDAO.modifyPack(modifyPack);
		return modifyCount;
	}
	
	

}

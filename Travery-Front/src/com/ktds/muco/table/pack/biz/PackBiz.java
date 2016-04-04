package com.ktds.muco.table.pack.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.hashtag.dao.HashTagDAO;
import com.ktds.muco.table.hashtag.vo.HashTagVO;
import com.ktds.muco.table.pack.dao.PackDAO;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.table.place.dao.PlaceDAO;
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
	private HashTagDAO hashTagDAO;
	private PlaceDAO placeDAO;

	public PackBiz() {
		packDAO = new PackDAO();
		hashTagDAO = new HashTagDAO();
		placeDAO = new PlaceDAO();
	}

	public List<PackVO> getPackListByEmail(String email) {
		List<PackVO> packs = packDAO.getPackListByEmail(email);
		List<PlaceVO> placeList = new ArrayList<PlaceVO>();
		
		// 김광민
		if(packs != null){
			
			for (PackVO packVO : packs) {
				
				placeList = placeDAO.getPlaceListByPackId( packVO.getPackId() );
				
				if( placeList != null) {
					packVO.setPlaceList( placeList );
				}
			}
		}
		
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
			deleteCount = packDAO.deletePack(Integer.parseInt(deletePackId));
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

	public int addHashTagInPack(int packId, String hashtags) {
		int insertCount = 0;
		// 1. hashtags string을 split하여 배열로 바꾼다.
		hashtags = hashtags.trim();
		String hashtagArray[] = hashtags.split(" ");
		
		// 2. hashtag vo들로 만든다.
		// 3. dao로 tag를 넘겨 db에 넣는다.
		for (String tag : hashtagArray) {
			HashTagVO hashTagVO = new HashTagVO();
			hashTagVO.setPackId(packId);
			hashTagVO.setHashtagName(tag);
			insertCount = hashTagDAO.addHashTagInPack(hashTagVO);
		}		
		
		return insertCount;
	}

	public String getHashTagsByPackId(int packId) {
		List<HashTagVO> tags = new ArrayList<HashTagVO>();
		tags = hashTagDAO.getHashTagOfPackage(packId);
		String hashtagOfPack = "";
		
		for (HashTagVO hashTagVO : tags) {
			String tag = hashTagVO.getHashtagName();
			hashtagOfPack = hashtagOfPack + " #" + tag;
		}
		
		return hashtagOfPack;
	}

	
	/**
	 * 
	 * @author 유병훈
	 * 
	 */
	public boolean getAddMyPackByPlace(String[] selectedPlaceId, int packId) {
		
		int isSuccess = 0;
		//packDAO.getAddMyPackByPlace(selectedPlaceId, packId);
		for (String placeId : selectedPlaceId) {
			int ori_placeId = Integer.parseInt(placeId);
			isSuccess = packDAO.getAddMyPackByPlace(ori_placeId, packId);
		}
		if ( isSuccess > 0) {
			return true;
		}
		
		return false;
	}
}

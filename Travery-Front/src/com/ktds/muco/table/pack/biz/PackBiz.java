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
<<<<<<< HEAD
=======
	private PlaceDAO placeDAO;
>>>>>>> origin/KGM8

	public PackBiz() {
		packDAO = new PackDAO();
		hashTagDAO = new HashTagDAO();
<<<<<<< HEAD
=======
		placeDAO = new PlaceDAO();
>>>>>>> origin/KGM8
	}

	public List<PackVO> getPackListByEmail(String email) {
		List<PackVO> packs = packDAO.getPackListByEmail(email);

		return packs;
	}

	public PackVO getPackDataByPackId(int packId) {
		PackVO pack = packDAO.getPackDataByPackId(packId);

		List<PlaceVO> placeList = new ArrayList<PlaceVO>();

		// 김광민
		if (pack != null) {

			placeList = placeDAO.getPlaceListByPackId(pack.getPackId());

			if (placeList != null) {

				pack.setPlaceList(placeList);
			}
		}

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
<<<<<<< HEAD
		
=======

>>>>>>> origin/KGM8
		// 2. hashtag vo들로 만든다.
		// 3. dao로 tag를 넘겨 db에 넣는다.
		for (String tag : hashtagArray) {
			HashTagVO hashTagVO = new HashTagVO();
			hashTagVO.setPackId(packId);
			hashTagVO.setHashtagName(tag);
			insertCount = hashTagDAO.addHashTagInPack(hashTagVO);
<<<<<<< HEAD
		}		
		
=======
		}

>>>>>>> origin/KGM8
		return insertCount;
	}

	public String getHashTagsByPackId(int packId) {
		List<HashTagVO> tags = new ArrayList<HashTagVO>();
		tags = hashTagDAO.getHashTagOfPackage(packId);
		String hashtagOfPack = "";
<<<<<<< HEAD
		
=======

>>>>>>> origin/KGM8
		for (HashTagVO hashTagVO : tags) {
			String tag = hashTagVO.getHashtagName();
			hashtagOfPack = hashtagOfPack + " #" + tag;
		}
<<<<<<< HEAD
		
		return hashtagOfPack;
	}
=======

		return hashtagOfPack;
	}

	/**
	 * pack Id convert String to Integer
	 * 
	 * @param packIdString
	 * @return
	 * @author 김광민
	 */
	public int convertPackIdStringToInteger(String packIdString) {

		if (packIdString != null) {
			String[] splitId = packIdString.split("s");
			System.out.println("packId to Int : " + splitId[1]);
			int packId = 0;
			try {
				packId = Integer.parseInt(splitId[1]);
			} catch (NumberFormatException nfe) {
			}
			return packId;
		}
		return 0;
	}

	/**
	 * 
	 * @author 유병훈
	 * 
	 */
	public boolean getAddMyPackByPlace(String[] selectedPlaceId, int packId) {

		int isSuccess = 0;
		// packDAO.getAddMyPackByPlace(selectedPlaceId, packId);
		for (String placeId : selectedPlaceId) {
			int ori_placeId = Integer.parseInt(placeId);
			isSuccess = packDAO.getAddMyPackByPlace(ori_placeId, packId);
		}
		if (isSuccess > 0) {
			return true;
		}

		return false;
	}
>>>>>>> origin/KGM8
}

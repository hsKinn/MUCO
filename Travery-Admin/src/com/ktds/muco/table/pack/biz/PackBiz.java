package com.ktds.muco.table.pack.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.pack.dao.PackDAO;
import com.ktds.muco.table.pack.vo.PackListVO;
import com.ktds.muco.table.pack.vo.PackSearchVO;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.web.Paging;

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

	public List<PackVO> getPackListByEmail(String email) {
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
			deleteCount = packDAO.deletePack(Integer.parseInt(deletePackId));
		}
		return deleteCount;
	}

	/**
	 * Pack List Detail를 볼 수 있는 Biz 
	 * @param packId
	 * @return
	 */
	public List<PlaceVO> getPlaceListByPackId(int packId) {
		List<PlaceVO> places = packDAO.getPlaceListByPackId(packId);
		return places;
	}
	
	/**
	 * Pack List 받아오는 method
	 * @author 이기연 
	 * @param packSearchVO
	 * @return
	 */
	public PackListVO getPackList(PackSearchVO packSearchVO, int sortOption) {
		// 1. 전체 게시글의 수
		int allPackCount = packDAO.getPackListCount();
		// 1-1. 기본으로 페이지를 만들어준다. 
		Paging paging = new Paging(20);
		paging.setTotalArticleCount(allPackCount);
		// 1-2. page 가져올 때 계산 쉽게 하기 위해서 page number은 0부터 시작 
		paging.setPageNumber(packSearchVO.getPageNO()+"");
		
		packSearchVO.setStartIndex(paging.getStartArticleNumber());
		packSearchVO.setEndIndex(paging.getEndArticleNumber());
		
		//전체 article 받아오기
		List<PackVO> packs = packDAO.getAllPackage(packSearchVO, sortOption);
		
		// 2. DAO로부터 받아온 결과를 출력
		PackListVO packList = new PackListVO();
		packList.setPackList(packs);
		// 2-2. 페이지 추가 
		packList.setPaging(paging);
		
		return packList;	
	}
}

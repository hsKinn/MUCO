package com.ktds.muco.biz;

import com.ktds.muco.dao.ImageDAO;
import com.ktds.muco.dao.NewPlaceDAO;
import com.ktds.muco.vo.MemberVO;
import com.ktds.muco.vo.PlaceVO;
import com.ktds.muco.web.MultipartHttpServletRequest;

public class RecommendPlaceBiz {

	private NewPlaceDAO npdao;
	private ImageDAO idao;

	public RecommendPlaceBiz () {
		npdao = new NewPlaceDAO();
		idao = new ImageDAO();	
	}
	
	public PlaceVO getDetail(int placeId) {

		PlaceVO place = npdao.getDetail(placeId);
		place.setFileList(idao.getFileListByArticleId(placeId));
		return place;
	}
	
	public boolean getDelete(MemberVO loginMember, PlaceVO placeInfo) {
		
		if ( loginMember.isAdmin() || loginMember.getMemberId().equals(placeInfo.getMemberId())) {

			npdao.getDelete( placeInfo.getPlaceId());
			idao.deleteFile(placeInfo.getPlaceId());
			npdao.deleteArticle(placeInfo.getPlaceId());
			return true;
		}
		else {
			return false;
		}
	}
	public void deleteArticles(String[] deleteArticleIds, MemberVO member) {
		
		if ( member.isAdmin() ) {
			for ( String articleId : deleteArticleIds ) {
				npdao.deleteArticle(Integer.parseInt(articleId));
			}
		}
	}
	
	
	public int placeInfoCreate(PlaceVO placeVO) {
		
		npdao.insertNewPlaceInfo(placeVO);
		
		String Description = placeVO.getDescription();
		Description = Description.replaceAll("\n", "<br/>");
		placeVO.setDescription(Description);
		return npdao.getWrite(placeVO);
	}
	
	public boolean modifyArticle( MultipartHttpServletRequest request ) {
		
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		
		// 원본
		PlaceVO originplace = getDetail(placeId);
		int changeCount = 0;
		String placeName = request.getParameter("placeName");
		String description = request.getParameter("description");
		
		PlaceVO changedPlace = new PlaceVO();
		if ( !originplace.getPlaceName().equals(placeName)) {
			changeCount++;
			changedPlace.setPlaceName(placeName);
		}
		
		description = description.replaceAll("\n", "<br/>");
		
		if ( !originplace.getDescription().equals(description)) {
			changeCount++;
			changedPlace.setDescription(description);
		}
		if ( changeCount == 0 ) {
			// DAO 글을 수정도중 관리자가 삭제시에 남는 후속성에 대한 처리 
			throw new RuntimeException("Not thing to change anything.");
		}
		else {
			changedPlace.setPlaceId(placeId);
			return npdao.updateArticle(changedPlace) > 0;
		}
	}
}

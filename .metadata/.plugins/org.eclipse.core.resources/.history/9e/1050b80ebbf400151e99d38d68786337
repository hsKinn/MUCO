package com.ktds.muco.table.pack.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.pack.dao.SharePackDAO;
import com.ktds.muco.table.pack.vo.PackListVO;
import com.ktds.muco.table.pack.vo.PackSearchVO;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.util.web.Paging;

public class SharePackBiz {
	private SharePackDAO sharePackDAO;
	
	public SharePackBiz() {
		sharePackDAO = new SharePackDAO();
	}

	
	/**
	 * Get All Package List
	 * 
	 * @author 김현섭
	 * 
	 * @param packSearchVO
	 * @return
	 */
	public PackListVO getAllPackageList(PackSearchVO packSearchVO, MemberVO member, int sortOption) {
		
		int allPackageCount = 0;
		int allPackageCountByHashTag = 0;
		
		Paging paging = new Paging(6);
		List<PackVO> packages = new ArrayList<PackVO>();
		
		// Count
		if ( packSearchVO.getSearchKeyword().equals("") ) {
			allPackageCount = sharePackDAO.getAllPackageListCount(packSearchVO);
			paging.setTotalArticleCount(allPackageCount);
		}
		else {
			allPackageCountByHashTag = sharePackDAO.getAllPackageCountByHashTag(packSearchVO);
			paging.setTotalArticleCount(allPackageCountByHashTag);
		}
		
		paging.setPageNumber( packSearchVO.getPageNo() + "");
		
		packSearchVO.setStartIndex( paging.getStartArticleNumber());
		packSearchVO.setEndIndex( paging.getEndArticleNumber() );
		
		// Get List
		/* 
		 * Sort Option
		 * 1 : Like Count DESC
		 * 2 : View Count DESC
		 * 3 : Create Date ASC
		 * 
		 */
		if ( packSearchVO.getSearchKeyword().equals("") ) {
			if ( sortOption == 1 ) {
				packages = sharePackDAO.getAllPackageList(packSearchVO, member);
			}
			else if ( sortOption == 2 ) {
				packages = sharePackDAO.getAllPackageListOrderByView(packSearchVO, member);
			}
			else if ( sortOption == 3 ) {
				packages = sharePackDAO.getAllPackageListOrderByDate(packSearchVO, member);
			}
		}
		else {
			if ( sortOption == 1 ) {
				packages = sharePackDAO.getAllPackageListByHashTag(packSearchVO, member);
			}
			else if ( sortOption == 2 ) {
				packages = sharePackDAO.getAllPackageListByHashTagOrderByView(packSearchVO, member);
			}
			else if ( sortOption == 3 ) {
				packages = sharePackDAO.getAllPackageListByHashTagOrderByDate(packSearchVO, member);
			}			
		}		
		
		PackListVO packList = new PackListVO();
		packList.setPackList(packages);
		packList.setPaging(paging);
		
		return packList;
	} // getAllPackageList END
	
	
	/**
	 * Hit the Count By Pack
	 * 
	 * @author 김현섭
	 * 
	 */
	public boolean hitCountPack ( int packId ) {
		
		return sharePackDAO.hitCountPack(packId) > 0;
		
	} // hitCountPack END
	
	
	
	
}	

package com.ktds.muco.table.pack.biz;

import java.util.ArrayList;
import java.util.List;

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

	public PackListVO getAllPackageList(PackSearchVO packSearchVO) {
		
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
		if ( packSearchVO.getSearchKeyword().equals("") ) {
			packages = sharePackDAO.getAllPackageList(packSearchVO);
		}
		else {
			packages = sharePackDAO.getAllPackageListByHashTag(packSearchVO);
		}		
		
		PackListVO packList = new PackListVO();
		packList.setPackList(packages);
		packList.setPaging(paging);
		
		return packList;
	}
}

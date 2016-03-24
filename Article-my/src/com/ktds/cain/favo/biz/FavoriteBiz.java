package com.ktds.cain.favo.biz;

import com.ktds.cain.favo.dao.FavoriteDAO;
import com.ktds.cain.favo.vo.FavoVO;

public class FavoriteBiz {

	private FavoriteDAO favoriteDAO;
	
	public FavoriteBiz() {
		favoriteDAO = new FavoriteDAO();
	}
	
	public boolean isExistFavoriteData( FavoVO favoriteVO ) {
		return favoriteDAO.selectFavoriteCount(favoriteVO) > 0;
	}
	
	public void insertOrDeleteFavoriteData( FavoVO favoriteVO ) {
		if ( isExistFavoriteData(favoriteVO) ) {
			favoriteDAO.deleteFavorite(favoriteVO);
		}
		else { 
			favoriteDAO.insertFavorite(favoriteVO);
		}
	}
}

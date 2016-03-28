package com.ktds.cain.favo.vo;

import com.ktds.cain.article.vo.ArticleVO;

public class FavoVO extends ArticleVO{

	private int favoriteId;
	private String createDate;
	
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}	
}

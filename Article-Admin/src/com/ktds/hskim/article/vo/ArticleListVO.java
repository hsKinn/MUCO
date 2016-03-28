package com.ktds.hskim.article.vo;

import java.util.List;

import com.ktds.hskim.util.web.Paging;

public class ArticleListVO {
	
	private List<ArticleVO> articleList;
	
	private Paging paging;

	public List<ArticleVO> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleVO> articleList) {
		this.articleList = articleList;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
}

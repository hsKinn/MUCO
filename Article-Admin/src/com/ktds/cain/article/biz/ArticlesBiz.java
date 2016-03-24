package com.ktds.cain.article.biz;

import java.util.List;


import com.ktds.cain.article.dao.ArticlesDAO;
import com.ktds.cain.article.vo.ArticleListVO;
import com.ktds.cain.article.vo.ArticleSearchVO;
import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.cain.article.web.MultipartHttpServletRequest;
import com.ktds.cain.file.DAO.FileDAO;
import com.ktds.cain.member.vo.MemberVO;
import com.ktds.cain.reply.dao.ReplyDAO;
import com.ktds.cain.util.web.Paging;

public class ArticlesBiz {
	private ArticlesDAO adao;
	private FileDAO fdao;
	private ReplyDAO rdao;

	public ArticlesBiz() {
		adao = new ArticlesDAO();
		fdao = new FileDAO();
		rdao = new ReplyDAO();
		}

	public ArticleListVO articlesList(ArticleSearchVO searchVO) {
		
		// 1page가 0번으로 시작한다는 이야기 - 페이지가 시작하는 번호와 끝나는 번호를 같이 불러올 수 있다.(paging 유틸 내부에서 지정되어있음)
		int allArticleCount = 0;
		List<ArticleVO> articles = null;

		
		if ( searchVO.getSearchType().equals("1")) {
			allArticleCount = adao.getAllArticleCount(searchVO);
		} else if ( searchVO.getSearchType().equals("2")) {
			allArticleCount = adao.getSearchMemberIdCount(searchVO);
		} else if ( searchVO.getSearchType().equals("3")) {
			allArticleCount = adao.getSearchNickNameCount(searchVO);
		}
		
		Paging paging = new Paging();
		paging.setTotalArticleCount(allArticleCount);
		paging.setPageNumber(searchVO.getPageNo() + ""); 
		
		searchVO.setStartIndex( paging.getStartArticleNumber() );
		searchVO.setEndIndex( paging.getEndArticleNumber() );

		if ( searchVO.getSearchType().equals("1")) {
			articles = adao.allArticle(searchVO);
		} else if ( searchVO.getSearchType().equals("2")) {
			articles = adao.searchMemberId(searchVO);
		} else if ( searchVO.getSearchType().equals("3")) {
			articles = adao.searchNickName(searchVO);
		}
		
		ArticleListVO articleList = new ArticleListVO();
		articleList.setArticleList(articles);
		articleList.setPaging(paging);
		
		return articleList;
		
	}

	public ArticleVO getDetail(int articleId) {

		ArticleVO article = adao.getDetail(articleId);
		article.setFileList(fdao.getFileListByArticleId(articleId));
		article.setReplyList(rdao.getReplyListByArticleId(articleId));
		return article;
	}
	
	public boolean getHit(int articleId) {
		if ( articleId > 0) {
			adao.getHit(articleId);
			return true;
		}	
		return false;
	}
	
	public void getRecommend(int articleId) {

		adao.getRecommend(articleId);
		
	}
	
	public boolean getDelete(MemberVO loginMember, ArticleVO targetArticleInfo) {
		
		if ( loginMember.isAdmin() || loginMember.getMemberId().equals(targetArticleInfo.getMemberId())) {

			adao.getDelete( targetArticleInfo.getArticleId());
//			fdao.deleteFile(targetArticleInfo.getArticleId());
//			rdao.deleteReply(targetArticleInfo.getArticleId());
			adao.deleteArticle(targetArticleInfo.getArticleId());
			return true;
		}
		else {
			return false;
		}
	}
	
	public int insertArticle(ArticleVO vo) {
		
		String descript = vo.getDescript();
		descript = descript.replaceAll("\n", "<br/>");
		vo.setDescript(descript);
		
		return adao.getWrite(vo);
		
	}	
	
	public boolean modifyArticle( MultipartHttpServletRequest request ) {
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		// 원본
		ArticleVO originArticle = getDetail(articleId);
		int changeCount = 0;
		String title = request.getParameter("title");
		String descript = request.getParameter("descript");
		
		ArticleVO changedArticle = new ArticleVO();
		if ( !originArticle.getTitle().equals(title)) {
			changeCount++;
			changedArticle.setTitle(title);
		}
		
		descript = descript.replaceAll("\n", "<br/>");
		
		if ( !originArticle.getDescript().equals(descript)) {
			changeCount++;
			changedArticle.setDescript(descript);
		}
		if ( changeCount == 0 ) {
			// DAO 글을 수정도중 관리자가 삭제시에 남는 후속성에 대한 처리 
			throw new RuntimeException("Not thing to change anything.");
		}
		else {
			changedArticle.setArticleId(articleId);
			return adao.updateArticle(changedArticle) > 0;
		}
	}

	public void deleteArticles(String[] deleteArticleIds, MemberVO member) {
		
		if ( member.isAdmin() ) {
			for ( String articleId : deleteArticleIds ) {
				adao.deleteArticle(Integer.parseInt(articleId));
			}
		}
	}	
}

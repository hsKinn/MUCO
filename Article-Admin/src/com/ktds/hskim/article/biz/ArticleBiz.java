package com.ktds.hskim.article.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.article.dao.ArticleDAO;
import com.ktds.hskim.article.vo.ArticleListVO;
import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.file.dao.FileDAO;
import com.ktds.hskim.member.vo.MemberVO;
import com.ktds.hskim.reply.dao.ReplyDAO;
import com.ktds.hskim.util.MultipartHttpServletRequest;
import com.ktds.hskim.util.web.Paging;

public class ArticleBiz {
	
	private ArticleDAO articleDAO;
	private FileDAO fileDAO;
	private ReplyDAO replyDAO;
	
	
	public ArticleBiz() {
		articleDAO = new ArticleDAO();
		fileDAO = new FileDAO();
		replyDAO = new ReplyDAO();
		
	} //생성자
	
	
	/**
	 * 게시글 리스트 (페이지)
	 */
	public ArticleListVO getAllArticleList( ArticleSearchVO searchVO, String searchType ) {
		
		int allArticleCount = 0;
		int allArticleCountByNickName = 0;
		int allArticleCountByWriterId = 0;
		Paging paging = new Paging();
		List<ArticleVO> articles = new ArrayList<ArticleVO>(); 
		
		// Count 메소드
		if ( searchType != null ) {
			if ( searchType.equals("id") ) {
				allArticleCountByWriterId = articleDAO.getAllArticleCountByWriterId(searchVO);
				paging.setTotalArticleCount(allArticleCountByWriterId);
			}
			else if ( searchType.equals("nickName") ) {
				allArticleCountByNickName = articleDAO.getAllArticleCountByNickName(searchVO);
				paging.setTotalArticleCount(allArticleCountByNickName);
			}
			else {
				allArticleCount = articleDAO.getAllArticleCount(searchVO);
				paging.setTotalArticleCount(allArticleCount);	
				
			}
		}
		else {
			allArticleCount = articleDAO.getAllArticleCount(searchVO);
			paging.setTotalArticleCount(allArticleCount);
		}
		
		paging.setPageNumber( searchVO.getPageNo() + "" );

		searchVO.setStartIndex( paging.getStartArticleNumber() );
		searchVO.setEndIndex( paging.getEndArticleNumber() );
		
		// 리스트 메소드
		if ( searchType != null ) {
			if ( searchType.equals("id") ) {
				articles = articleDAO.getAllArticleListByWriterId(searchVO);
			}
			else if ( searchType.equals("nickName") ) {
				articles = articleDAO.getAllArticleListByNickName(searchVO);			
			}
			else {
				articles = articleDAO.getArticleList(searchVO);		
			}
		}
		else {
			articles = articleDAO.getArticleList(searchVO);				
		}
		
		ArticleListVO articleList = new ArticleListVO();
		articleList.setArticleList(articles);
		articleList.setPaging(paging);
		
		return articleList;
		
	} //getAllArticleList end
	
	
	/**
	 * 게시글 상세 페이지
	 */
	public ArticleVO getDetailArticle ( int articleId ) {
		
		ArticleVO article = articleDAO.getDetailArticle(articleId);
		article.setFileList(fileDAO.getFileListByArticleId(articleId));
		article.setReplyList(replyDAO.getReplyListByArticleId(articleId));
		
		return article;
	} //getDetailArticle end
	
	
	/**
	 * 게시글 추천수 증가
	 */
	public void addRecommends ( int articleId ) {
		
		articleDAO.addRecommends(articleId);
		
	} //addRecommends end
	
	
	/**
	 * 멤버 확인
	 */
	public boolean checkMemberId ( String loginMember, String articleInfo ) {
		
		if ( loginMember.equals(articleInfo) ) {
			return true;
		}
		else {
			return false;
		}
		
	} //checkMemberId end
	
	
	/**
	 * 게시글 삭제
	 */
	public boolean deleteArticle ( MemberVO loginMember, ArticleVO articleInfo ) {
		
		if ( checkMemberId(loginMember.getMemberId(), articleInfo.getMemberId()) || loginMember.isAdmin() ) {
			
			// 작성자 ID와 로그인 세션 ID가 같은 경우 게시글 삭제
			int checkDeleteAction = articleDAO.deleteArticle(articleInfo.getArticleId());
			
			// 게시글 삭제 성공시
			if ( checkDeleteAction > 0) {
				
				// 파일 존재 여부 체크
				int checkDeleteFile = fileDAO.checkFile(articleInfo.getArticleId());
				if ( checkDeleteFile > 0 ) {
					// 파일 존재 시 삭제
					fileDAO.deleteFile(articleInfo.getArticleId());
				}
				
				//TODO ReplyDAO 리플 지우기
				
				return true;
				
			}
			else {
				
				return false;
			}
		}
		else {
			
			// 작성자 ID와 로그인 세션 ID가 다른 경우 리턴
			return false;
		}
		
	} // deleteAction end

	
	/**
	 * 게시글 작성
	 */
	public int writeArticle ( ArticleVO article ) {
		
		String description = article.getDescript();
		description = description.replaceAll("\n", "<br/>");
		article.setDescript(description);
		
		int writtenArticleId = articleDAO.writeArticle(article);
		
		if ( writtenArticleId != 0 ) {
			return writtenArticleId;
		}
		else {
			return 0;
		}
		
	} //writeArticle end
	
	
	/**
	 * 게시글 수정 
	 */
	public boolean modifyArticle ( MultipartHttpServletRequest request ) {
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		// 원본 내용
		ArticleVO originArticle = getDetailArticle(articleId);
		
		int changeCount = 0;
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		ArticleVO changedArticle = new ArticleVO();
		
		if ( !originArticle.getTitle().equals(title) ) {
			changeCount++;
			changedArticle.setTitle(title);
		}
		if ( !originArticle.getDescript().equals(description) ) {
			changeCount++;
			description = description.replaceAll("\n", "<br/>");
			changedArticle.setDescript(description);
		}
		
		if ( changeCount == 0 ) {
			throw new RuntimeException("변경된 사항이 없습니다");
		}
		else {
			changedArticle.setArticleId(articleId);
			return articleDAO.updateArticle(changedArticle) > 0;
		}
	}


	public void deleteArticles(String[] deleteArticleIds, MemberVO member) {
		
		if ( member.isAdmin() ) {
			
			for (String articleId : deleteArticleIds ) {
				articleDAO.deleteArticle(Integer.parseInt(articleId));
			}
		}
	}
	
	
}

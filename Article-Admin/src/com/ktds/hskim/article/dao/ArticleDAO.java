package com.ktds.hskim.article.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.hskim.article.vo.ArticleSearchVO;
import com.ktds.hskim.article.vo.ArticleVO;
import com.ktds.hskim.util.Const;
import com.ktds.hskim.util.xml.XML;

public class ArticleDAO {
	
	/**
	 * 모든 게시글 개수  [ 내용 + 제목 ]
	 */
	public int getAllArticleCount( ArticleSearchVO searchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVO article = new ArticleVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/article/getAllArticleCount/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setString(2, searchVO.getSearchKeyword());	
			
			rs = stmt.executeQuery();
			
			int articleCount = 0;
			rs.next();
			articleCount = rs.getInt(1);
			
			return articleCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	/**
	 * 게시글 리스트  [ 내용 + 제목 ]
	 */
	public List<ArticleVO> getArticleList ( ArticleSearchVO searchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ArticleVO> articles = new ArrayList<ArticleVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/getAllArticleList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setString(2, searchVO.getSearchKeyword());
			stmt.setInt(3, searchVO.getEndIndex());
			stmt.setInt(4, searchVO.getStartIndex());
			
			rs = stmt.executeQuery();
			
			ArticleVO article = null;
			
			while ( rs.next() ) {
				
				article = new ArticleVO();
				
	            article.setArticleId(rs.getInt("ARTICLE_ID"));
	            article.setMemberId(rs.getString("MEMBER_ID"));
	            article.setTitle(rs.getString("TITLE"));
	            article.setDescript(rs.getString("DESCRIPT"));
	            article.setHits(rs.getInt("HITS"));
	            article.setRecommends(rs.getInt("RECOMMENDS"));
	            article.setNickName(rs.getString("NICK_NAME"));
	            article.setFileCount(rs.getInt("FILE_COUNT"));
				
				articles.add(article);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return articles;
	}
	
	/**
	 * 모든 게시글 개수  [ 사용자 NICK_NAME ]
	 */
	public int getAllArticleCountByNickName( ArticleSearchVO searchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVO article = new ArticleVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/article/getAllArticleCountByNickName/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchVO.getSearchKeyword());
			
			rs = stmt.executeQuery();
			
			int articleCount = 0;
			rs.next();
			articleCount = rs.getInt(1);
			
			return articleCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	/**
	 * 게시글 리스트  [ 사용자 NICK_NAME ]
	 */
	public List<ArticleVO> getAllArticleListByNickName ( ArticleSearchVO searchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ArticleVO> articles = new ArrayList<ArticleVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/getAllArticleListByNickName/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setInt(2, searchVO.getEndIndex());
			stmt.setInt(3, searchVO.getStartIndex());
			
			rs = stmt.executeQuery();
			
			ArticleVO article = null;
			
			while ( rs.next() ) {
				
				article = new ArticleVO();
				
				article.setArticleId(rs.getInt("ARTICLE_ID"));
				article.setMemberId(rs.getString("MEMBER_ID"));
				article.setTitle(rs.getString("TITLE"));
				article.setDescript(rs.getString("DESCRIPT"));
				article.setHits(rs.getInt("HITS"));
				article.setRecommends(rs.getInt("RECOMMENDS"));
				article.setNickName(rs.getString("NICK_NAME"));
				article.setFileCount(rs.getInt("FILE_COUNT"));
				
				articles.add(article);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return articles;
	}
	
	/**
	 * 모든 게시글 개수  [ 사용자 ID ]
	 */
	public int getAllArticleCountByWriterId( ArticleSearchVO searchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVO article = new ArticleVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/article/getAllArticleCountByWriterId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchVO.getSearchKeyword());
			
			rs = stmt.executeQuery();
			
			int articleCount = 0;
			rs.next();
			articleCount = rs.getInt(1);
			
			return articleCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	/**
	 * 게시글 리스트  [ 사용자 ID ]
	 */
	public List<ArticleVO> getAllArticleListByWriterId ( ArticleSearchVO searchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ArticleVO> articles = new ArrayList<ArticleVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/getAllArticleListByWriterId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, searchVO.getSearchKeyword());
			stmt.setInt(2, searchVO.getEndIndex());
			stmt.setInt(3, searchVO.getStartIndex());
			
			rs = stmt.executeQuery();
			
			ArticleVO article = null;
			
			while ( rs.next() ) {
				
				article = new ArticleVO();
				
				article.setArticleId(rs.getInt("ARTICLE_ID"));
				article.setMemberId(rs.getString("MEMBER_ID"));
				article.setTitle(rs.getString("TITLE"));
				article.setDescript(rs.getString("DESCRIPT"));
				article.setHits(rs.getInt("HITS"));
				article.setRecommends(rs.getInt("RECOMMENDS"));
				article.setNickName(rs.getString("NICK_NAME"));
				article.setFileCount(rs.getInt("FILE_COUNT"));
				
				articles.add(article);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return articles;
	}
	
	
	
	
	/**
	 * 게시글 상세 페이지
	 */
	public ArticleVO getDetailArticle ( int articleId ) {
		
		addHits(articleId);
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVO article = new ArticleVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/article/getDetailArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
			
			rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				article.setArticleId(rs.getInt("ARTICLE_ID"));
				article.setMemberId(rs.getString("MEMBER_ID"));
				article.setTitle(rs.getString("TITLE"));
				article.setDescript(rs.getString("DESCRIPT"));
				article.setHits(rs.getInt("HITS"));
				article.setRecommends(rs.getInt("RECOMMENDS"));
				article.setNickName(rs.getString("NICK_NAME"));
			}

			return article;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
	} //getDatilArticle end
	
	
	/**
	 * 게시글 조회수 증가
	 */
	public void addHits ( int articleId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/addHits/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, articleId);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} //addHits end		
	
	
	/**
	 * 게시글 추천수 증가
	 */
	public void addRecommends ( int articleId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/addRecommends/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, articleId);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} //addRecommends end	
	
	
	/**
	 * 게시글 삭제
	 */
	public int deleteArticle ( int articleId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/deleteArticle/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, articleId);
			
			int deleteAction = stmt.executeUpdate();
			
			return deleteAction;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} //deleteArticle end
	
	
	/**
	 * 게시글 작성
	 */
	public int writeArticle ( ArticleVO article ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int writtenArticleId = 0;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/article/writeArticle/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, article.getMemberId());
			stmt.setString(2, article.getTitle());
			stmt.setString(3, article.getDescript());
			
			if ( stmt.executeUpdate() > 0 ) {
				
				stmt.close();

				ResultSet rs = null;
				
				query = XML.getNodeString("//query/article/getWrittenArticleId/text()");
				stmt = conn.prepareStatement(query);
				
				rs = stmt.executeQuery();
				
				if ( rs.next() ) {
					writtenArticleId = rs.getInt("CURRVAL");
				}
				
				rs.close();
				
			}
			
			return writtenArticleId;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} //wirteArticle end
	
	
	/**
	 * 게시글 수정
	 */
	public int updateArticle(ArticleVO changedArticle) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "";
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
		
			// 조건 별 Query 설정
			if ( changedArticle.getTitle() != null && changedArticle.getTitle().length() > 0 ) {
				
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0 ) {
					query = XML.getNodeString("//query/article/updateArticle/text()");
				}
				else {
					query = XML.getNodeString("//query/article/updateArticleOnlyTitle/text()");
				}
				
			}
			else {
				
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0 ) {
					query = XML.getNodeString("//query/article/updateArticleOnlyDescription/text()");
				}
				
			}
			
			// 조건 별 ? 변수 값 넘김
			stmt = conn.prepareStatement(query);
			if ( changedArticle.getTitle() != null && changedArticle.getTitle().length() > 0 ) {
				
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0 ) {
					stmt.setString(1, changedArticle.getTitle());
					stmt.setString(2, changedArticle.getDescript());
					stmt.setInt(3, changedArticle.getArticleId());
				}
				else {
					stmt.setString(1, changedArticle.getTitle());
					stmt.setInt(2, changedArticle.getArticleId());
				}
				
			}
			else {
				
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0 ) {
					stmt.setString(1, changedArticle.getDescript());
					stmt.setInt(2, changedArticle.getArticleId());
				}
				
			}
			
			int modifyAction = stmt.executeUpdate();
			
			return modifyAction;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} // updateArticle end
	

	/**
	 * Oracle Driver
	 */
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Close DB
	 */
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
}

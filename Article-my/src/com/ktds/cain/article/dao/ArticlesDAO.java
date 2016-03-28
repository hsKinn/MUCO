package com.ktds.cain.article.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.article.vo.ArticleSearchVO;
import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.cain.util.xml.XML;


public class ArticlesDAO {
	
	public List<ArticleVO> allArticle(ArticleSearchVO searchVO) {
		
		List<ArticleVO> avo = new ArrayList<ArticleVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVO vo = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/article/allArticle/text()");
			stmt = conn.prepareStatement(query);
			// 인덱스 추가부분
			stmt.setInt(1, searchVO.getEndIndex());
			stmt.setInt(2, searchVO.getStartIndex());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new ArticleVO();
				vo.setArticleId(rs.getInt("ARTICLE_ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setNickName(rs.getString("NICK_NAME"));
				vo.setHits(rs.getInt("HITS"));
				vo.setRecommends(rs.getInt("RECOMMENDS"));
				vo.setFileCount(rs.getInt("FILE_COUNT"));
				
				avo.add(vo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return avo;
	}
	
	public ArticleVO getDetail(int articleId) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVO art = new ArticleVO();
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/detail/getDetail/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
				
			rs = stmt.executeQuery();

			if ( rs.next()) {
				art.setArticleId(rs.getInt("ARTICLE_ID"));
				art.setTitle(rs.getString("TITLE"));
				art.setMemberId(rs.getString("MEMBER_ID"));
				art.setNickName(rs.getString("NICK_NAME"));
				art.setDescript(rs.getString("DESCRIPT"));
				art.setHits(rs.getInt("HITS"));
				art.setRecommends(rs.getInt("RECOMMENDS"));
				}
		
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			finally {
				closeDB(conn, stmt, rs);
			}
			return art;
		}

	public int getHit ( int articleId ) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String 	query = XML.getNodeString("//query/detail/getHit/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, articleId);

			int count = stmt.executeUpdate();
			return count;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	public int getRecommend ( int articleId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String 	query = XML.getNodeString("//query/detail/getRecommend/text()");


			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);

			int count = stmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public int getDelete( int articleId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String 	query = XML.getNodeString("//query/detail/getDelete/text()");

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);

			int count = stmt.executeUpdate();
			return count;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public int getWrite(ArticleVO article) {
		
		int insertCount = 0;
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");

			String query = XML.getNodeString("//query/write/getWrite/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, article.getMemberId());
			stmt.setString(2, article.getTitle());
			stmt.setString(3, article.getDescript());
			
			insertCount = stmt.executeUpdate();
			
			if ( insertCount > 0 ) {
				stmt.close();
				query = XML.getNodeString("//query/write/getReturnArticleId/text()");
				stmt = conn.prepareStatement(query);
				
				ResultSet rs = stmt.executeQuery();
				
				int articleId = 0;
				
				if ( rs.next() ) {
					articleId = rs.getInt(1);
				}
				rs.close();
				return articleId;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return insertCount;
	}
	
	public int updateArticle(ArticleVO changedArticle) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = "";
			if ( changedArticle.getTitle() != null && changedArticle.getTitle().length() > 0 ) {
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {					
					query = XML.getNodeString("//query/write/updateArticle/text()");
				}
				else {
					query = XML.getNodeString("//query/write/updateArticleOnlyTitle/text()");
				}
			}
			else {
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {
					query = XML.getNodeString("//query/write/updateArticleOnlyDescript/text()");
				}
			}

			stmt = conn.prepareStatement(query);
			System.out.println(query);
			
			if ( changedArticle.getTitle() != null && changedArticle.getTitle().length() > 0 ) {
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {
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
				if ( changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {
					stmt.setString(1, changedArticle.getDescript());
					stmt.setInt(2, changedArticle.getArticleId());
				}
			}
			return stmt.executeUpdate();
			 
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public int getAllArticleCount() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/article/getAllArticleCount/text()");
			stmt = conn.prepareStatement(query);
				
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

	public void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
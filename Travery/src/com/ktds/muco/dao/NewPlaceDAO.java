package com.ktds.muco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.cain.article.vo.ArticleVO;
import com.ktds.muco.util.xml.XML;
import com.ktds.muco.vo.PlaceVO;


public class NewPlaceDAO {

	public int insertNewPlaceInfo( PlaceVO place) {
		int insertCount = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		loadOracleDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/newPlace/insertNewPlaceInfo/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setDouble(1, place.getLatitude());
			stmt.setDouble(2, place.getLongitude());
			stmt.setString(3, place.getAddress());
//			stmt.setString(4, place.getImage());
//			stmt.setString(5, place.getText());
						
			insertCount = stmt.executeUpdate();
			return insertCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public int getWrite(PlaceVO placeVO) {

		int insertCount = 0;

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");

			String query = XML.getNodeString("//query/write/getWrite/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, placeVO.getPlaceId());
			stmt.setString(2, placeVO.getPlaceName());
			stmt.setString(3, placeVO.getDescription());

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				query = XML.getNodeString("//query/write/getReturnArticleId/text()");
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				int articleId = 0;

				if (rs.next()) {
					articleId = rs.getInt(1);
				}
				return articleId;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return insertCount;
	}

	public int getDelete(int articleId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");
			String query = XML.getNodeString("//query/detail/getDelete/text()");

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

			if (insertCount > 0) {
				stmt.close();
				query = XML.getNodeString("//query/write/getReturnArticleId/text()");
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				int articleId = 0;

				if (rs.next()) {
					articleId = rs.getInt(1);
				}
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
			if (changedArticle.getTitle() != null && changedArticle.getTitle().length() > 0) {
				if (changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {
					query = XML.getNodeString("//query/write/updateArticle/text()");
				} else {
					query = XML.getNodeString("//query/write/updateArticleOnlyTitle/text()");
				}
			} else {
				if (changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {
					query = XML.getNodeString("//query/write/updateArticleOnlyDescript/text()");
				}
			}

			stmt = conn.prepareStatement(query);
			System.out.println(query);

			if (changedArticle.getTitle() != null && changedArticle.getTitle().length() > 0) {
				if (changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {
					stmt.setString(1, changedArticle.getTitle());
					stmt.setString(2, changedArticle.getDescript());
					stmt.setInt(3, changedArticle.getArticleId());
				} else {
					stmt.setString(1, changedArticle.getTitle());
					stmt.setInt(2, changedArticle.getArticleId());
				}
			} else {
				if (changedArticle.getDescript() != null && changedArticle.getDescript().length() > 0) {
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
	
	public void deleteArticle(int articleId) {

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "toor");

			String query = XML.getNodeString("//query/newPlace/deleteArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}

	}

	public void loadOracleDriver(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		if( conn !=null ) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}

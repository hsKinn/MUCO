package com.ktds.muco.table.pack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.pack.vo.PackSearchVO;
import com.ktds.muco.table.pack.vo.PackVO;
import com.ktds.muco.util.xml.XML;

public class SharePackDAO {
	
	
	/**
	 * Get Package Count By Hash Tag
	 * 
	 * @author 김현섭
	 * 
	 * @param packSearchVO
	 * @return
	 */
	public int getAllPackageCountByHashTag( PackSearchVO packSearchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/sharePack/getAllPackageCountByHashTag/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, packSearchVO.getSearchKeyword());
			
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
		
	} // getAllPackageCountByHashTag END

	
	/**
	 * Get Package List By Hash Tag
	 * 
	 * @author 김현섭
	 * 
	 * @param packSearchVO
	 * @return
	 */
	public List<PackVO> getAllPackageListByHashTag ( PackSearchVO packSearchVO ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<PackVO> packages = new ArrayList<PackVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/sharePack/getAllPackageListByHashTag/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, packSearchVO.getSearchKeyword());
			stmt.setInt(2, packSearchVO.getEndIndex());
			stmt.setInt(3, packSearchVO.getStartIndex());
			
			rs = stmt.executeQuery();
			
			PackVO pack = null;
			
			while ( rs.next() ) {
				
				pack = new PackVO();
				
				pack.setPackId(rs.getInt("PACK_ID"));
				pack.setPackTitle(rs.getString("PACK_TITLE"));
				pack.setViewCount(rs.getInt("VIEW_COUNT"));
				pack.setLikeCount(rs.getInt("LIKE_COUNT"));
				pack.setName(rs.getString("NAME"));
				pack.setImage_location(rs.getString("IMAGE_LOCATION"));
				
				packages.add(pack);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return packages;
	}	
	
	
	
	
	
	/**
	 * 
	 * Load Oracle Driver
	 * 
	 * @author 김광민
	 * 
	 */
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	} // loadOracleDriver END
	
	/**
	 * 
	 * Close DB
	 * 
	 * @author 김광민
	 * 
	 */
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	} // closeDB END


	public int getAllPackageListCount(PackSearchVO packSearchVO) {

		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/sharePack/getAllPackageListCount/text()");
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
		
	} //getAllPackageListCount END


	public List<PackVO> getAllPackageList(PackSearchVO packSearchVO) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<PackVO> packages = new ArrayList<PackVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/sharePack/getAllPackageList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, packSearchVO.getEndIndex());
			stmt.setInt(2, packSearchVO.getStartIndex());
			
			rs = stmt.executeQuery();
			
			PackVO pack = null;
			
			while ( rs.next() ) {
				
				pack = new PackVO();
				
				pack.setPackId(rs.getInt("PACK_ID"));
				pack.setPackTitle(rs.getString("PACK_TITLE"));
				pack.setViewCount(rs.getInt("VIEW_COUNT"));
				pack.setLikeCount(rs.getInt("LIKE_COUNT"));
				pack.setName(rs.getString("NAME"));
				pack.setImage_location(rs.getString("IMAGE_LOCATION"));
				
				packages.add(pack);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return packages;
		
	}
	
	
	
}

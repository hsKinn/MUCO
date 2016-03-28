package com.ktds.muco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.util.xml.XML;
import com.ktds.muco.vo.ImageVO;

public class ImageDAO {
	
	public void insertImage(ImageVO imageVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/image/insertImage/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, imageVO.getImageId());
			stmt.setString(2, imageVO.getImageName());
			stmt.setString(3, imageVO.getImageLocation());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public List<ImageVO> getImageListByPlaceId(int PlaceId) {
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ImageVO> imageList = new ArrayList<ImageVO>();
		ImageVO imageVO = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.225.152.191:1521:XE", "TRAVERY", "TRAVERY");
			String query = XML.getNodeString("//query/image/getImageListByPlaceId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, PlaceId);
			rs = stmt.executeQuery();
			
			while ( rs.next() ) {
				imageVO = new ImageVO();
				imageVO.setImageId(rs.getInt("IMAGE_ID"));
				imageVO.setImageName(rs.getString("IMAGE_NAME"));
				imageVO.setImageLocation(rs.getString("IMAGE_LOCATION"));
				imageList.add(imageVO);
			}
			if ( imageVO == null ) {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return imageList;
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

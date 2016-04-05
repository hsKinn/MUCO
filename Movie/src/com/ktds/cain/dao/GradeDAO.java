package com.ktds.cain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.cain.util.xml.XML;
import com.ktds.cain.vo.GradeVO;

public class GradeDAO {
	
	public List<GradeVO> getAllGrades() {
		
		List<GradeVO> gvo = new ArrayList<GradeVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		GradeVO vo = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PWD);
			String query = XML.getNodeString("//query/movie/getAllGrades/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new GradeVO();
				vo.setGradeId(rs.getInt("GRADE_ID"));
				vo.setGradeTitle(rs.getString("GRADE_TITLE"));
				
				gvo.add(vo);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
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
			if( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return gvo;
	}
	
}

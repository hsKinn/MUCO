package com.ktds.muco.table.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.vo.MemberSearchVO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class MemberDAO {

	/**
	 * 
	 * 회원가입
	 * 
	 * @author 유병훈
	 * 
	 */
	public void addNewMember(MemberVO memberVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/member/addNewMember/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberVO.getEmail());
			stmt.setString(2, memberVO.getPassword());
			stmt.setString(3, memberVO.getName());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	/**
	 * 
	 * 로그인하기위해 해당 유저가 존재하는지 확인
	 * 
	 * @author 김광민
	 * 
	 * validMemberVO.setPhoneNumber(rs.getString("PHONE_NUMBER")); @author 이기연 수정 
	 */
	public MemberVO getMemberByEmailAndPassword(MemberVO memberVO) {

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/member/getMemberByIdAndPassword/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, memberVO.getEmail());
			stmt.setString(2, memberVO.getPassword());

			rs = stmt.executeQuery();

			MemberVO validMemberVO = null;

			if (rs.next()) {

				validMemberVO = new MemberVO();

				validMemberVO.setEmail(rs.getString("EMAIL"));
				validMemberVO.setPassword(rs.getString("PASSWORD"));
				validMemberVO.setName(rs.getString("NAME"));
				// 이부분 추가 
				validMemberVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				validMemberVO.setIsAdmin(rs.getInt("IS_ADMIN"));
				validMemberVO.setMainImageName(rs.getString("MAIN_IMAGE_NAME"));
				validMemberVO.setMainImageLocation(rs.getString("MAIN_IMAGE_LOCATION"));
				validMemberVO.setJoinDate(rs.getString("JOIN_DT"));
				validMemberVO.setRecentAccessDate(rs.getString("RECENT_ACCESS_DT"));

			}

			return validMemberVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	/**
	 *
	 * 회원 이름 수정 
	 * 
	 * @author 이기연
	 * 
	 */
	public void updateName(MemberVO memberVO) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/member/updateName/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberVO.getName());
			stmt.setString(2, memberVO.getEmail());
			
			stmt.executeUpdate();

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);	
		}		
	}
	
	/**
	 * 회원 번호 수정
	 * 
	 * @author 이기연
	 * 
	 */
	public void updatePhoneNumber(MemberVO memberVO) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/member/updatePhoneNumber/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberVO.getPhoneNumber());
			stmt.setString(2, memberVO.getEmail());
			
			stmt.executeUpdate();

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);	
		}		
	}
	
	/**
	 * 회원 비밀번호 수정
	 * 
	 * @author 이기연
	 * 
	 */
	public void updatePassword(MemberVO memberVO) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/member/updatePassword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberVO.getPassword());
			stmt.setString(2, memberVO.getEmail());
			
			stmt.executeUpdate();

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);	
		}		
	}
	
	/**
	 * 이름 중복 체크
	 * 0: 중복 X 
	 * 1: 중복 O
	 * 
	 * @author 이기연
	 * 
	 * 
	 */
	public int isExistName(String name) {
	
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/member/isExistName/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, name);

			rs = stmt.executeQuery();

			if (rs.next()) {
				return  rs.getInt("COUNT");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		
		return 0;
	}

	/**
	 * 회원 프로필 이미지 등록
	 * 
	 * @author 이기연
	 * 
	 */
	public void addMainImage(MemberVO memberVO) {
	
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			String query = XML.getNodeString("//query/member/addMainImage/text()");
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberVO.getMainImageName());
			stmt.setString(2, memberVO.getMainImageLocation());
			stmt.setString(3, memberVO.getEmail());
			
			stmt.executeUpdate();

			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);	
		}		
		
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
	}

	/**
	 * 
	 * Close DB
	 * 
	 * @author 김광민
	 * 
	 */
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

	/**
	 * @author 이기연 
	 * memberCount 받아오기
	 * @return
	 */
	public int getAllMemberCount() {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/member/getAllMemberCount/text()");
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();

			int placeCount = 0;
			
			if ( rs.next() ) {
				placeCount = rs.getInt(1);
			}
			return placeCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	/**
	 * @author 이기연
	 * 모든 memberList 받아오기
	 * @param memberSearchVO
	 * @return
	 */
	public List<MemberVO> getAllMembers(MemberSearchVO memberSearchVO) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<MemberVO> members = new ArrayList<MemberVO>();

		try {

			MemberVO memberVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			// article을 꺼내온다.
			String query = XML.getNodeString("//query/member/getAllMembers/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, memberSearchVO.getEndIndex());
			stmt.setInt(2, memberSearchVO.getStartIndex());
					
			rs = stmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();

				memberVO.setEmail(rs.getString("EMAIL"));
				memberVO.setPassword(rs.getString("PASSWORD"));
				memberVO.setIsAdmin(rs.getInt("IS_ADMIN"));
				memberVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				memberVO.setMainImageName(rs.getString("MAIN_IMAGE_NAME"));
				memberVO.setMainImageLocation(rs.getString("MAIN_IMAGE_LOCATION"));
				memberVO.setName(rs.getString("NAME"));
				memberVO.setJoinDate(rs.getString("JOIN_DT"));
				memberVO.setRecentAccessDate(rs.getString("RECENT_ACCESS_DT"));
				
				members.add(memberVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}

		return members;
	}


}

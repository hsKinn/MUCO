package com.ktds.muco.table.place.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.muco.table.member.dao.Const;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.table.place.vo.PlaceSearchVO;
import com.ktds.muco.table.place.vo.PlaceVO;
import com.ktds.muco.util.xml.XML;

/**
 * 
 * @author 김광민
 *
 */
public class PlaceDAO {
	/**
	 * 
	 * placeInfoRecommendedList
	 * 
	 * @author 김동규
	 * 
	 */
	public List<PlaceVO> placeInfoRecommendedList() {
		List<PlaceVO> listPlaceVO = new ArrayList<PlaceVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PlaceVO placeVO = null;

		loadOracleDriver();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			String query = XML.getNodeString("//query/place/placeInfoRecommendedList/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				placeVO = new PlaceVO();
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				// placeVO.set(rs.getString("START_DATE"));

				listPlaceVO.add(placeVO);
			} // if data is done finish.
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return listPlaceVO;
	}

	/**
	 * 
	 * insertPlaceInfo
	 * 
	 * @author 김동규
	 * 
	 */
	public int insertPlaceInfo(PlaceVO placeVO) {

		int placeId = 0;
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/insertPlaceInfo/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, placeVO.getPlaceName());
			stmt.setString(2, placeVO.getAddress());
			stmt.setDouble(3, placeVO.getLatitude());
			stmt.setDouble(4, placeVO.getLongitude());
			stmt.setString(5, placeVO.getDescription());

			placeId = stmt.executeUpdate();

			if (placeId > 0) {
				stmt.close();
				query = XML.getNodeString("//query/place/getReturnPlaceId/text()");
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					placeId = rs.getInt(placeId);
				}
				return placeId;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		return placeId;

	}
	
	/** 
	 * @author 이기연
	 * @param sortOption 
	 * @return
	 */
	public List<PlaceVO> getAllPlaces(PlaceSearchVO placeSearchVO, int sortOption, int placeType) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<PlaceVO> places = new ArrayList<PlaceVO>();

		try {

			PlaceVO placeVO = null;
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			// article을 꺼내온다.
			String query = "";
			
			// order by 여행자명
			if ( sortOption == 1 ) {
				if (placeSearchVO.getSearchList().equals("placeName")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyPlaceNameSearchedByPlaceName/text()");
					
					stmt = conn.prepareStatement(query);
					
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());
				} else if (placeSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyPlaceNameSearchedByEmail/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else if (placeSearchVO.getSearchList().equals("countryId")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyPlaceNameSearchedByCountryId/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());				
				}
				else {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyPlaceName/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setInt(2, placeSearchVO.getEndIndex());
					stmt.setInt(3, placeSearchVO.getStartIndex());
				}
			}
			// order by 등록자 이름
			else if ( sortOption == 2 ) {
				if (placeSearchVO.getSearchList().equals("placeName")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyEmailSearchedByPlaceName/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());	
				} else if (placeSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyEmailSearchedByEmail/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else if (placeSearchVO.getSearchList().equals("countryId")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyEmailSearchedByCountryId/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyEmail/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setInt(2, placeSearchVO.getEndIndex());
					stmt.setInt(3, placeSearchVO.getStartIndex());
				}
			}
			// order by 나라ID
			else if ( sortOption == 3 ) {
				if (placeSearchVO.getSearchList().equals("placeName")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyCountryIdSearchedByPlaceName/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());
				} else if (placeSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyCountryIdSearchedByEmail/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());				
				}
				else if (placeSearchVO.getSearchList().equals("countryId")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyCountryIdSearchedByCountryId/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyCountryId/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setInt(2, placeSearchVO.getEndIndex());
					stmt.setInt(3, placeSearchVO.getStartIndex());
				}
			}
			// order by 추천수
			else if ( sortOption == 4 ) {
				if (placeSearchVO.getSearchList().equals("placeName")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyLikeCountSearchedByPlaceName/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());	
				} else if (placeSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyLikeCountSearchedByEmail/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else if (placeSearchVO.getSearchList().equals("countryId")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyLikeCountSearchedByCountryId/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyLikeCount/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setInt(2, placeSearchVO.getEndIndex());
					stmt.setInt(3, placeSearchVO.getStartIndex());
				}				
			}
			// order by 조회수
			else if ( sortOption == 5 ) {
				if (placeSearchVO.getSearchList().equals("placeName")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyViewCountSearchedByPlaceName/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());	
				} else if (placeSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyViewCountSearchedByEmail/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else if (placeSearchVO.getSearchList().equals("countryId")) {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyViewCountSearchedByCountryId/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());					
				}
				else {
					query = XML.getNodeString("//query/place/getAllPlacesOrderbyViewCount/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setInt(2, placeSearchVO.getEndIndex());
					stmt.setInt(3, placeSearchVO.getStartIndex());
				}					
			} 
			else {
				if (placeSearchVO.getSearchList().equals("placeName")) {
					query = XML.getNodeString("//query/place/getAllPlacesSearchedByPlaceName/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());	
				} else if (placeSearchVO.getSearchList().equals("email")) {
					query = XML.getNodeString("//query/place/getAllPlacesSearchedByEmail/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());						
				}
				else if (placeSearchVO.getSearchList().equals("countryId")) {
					query = XML.getNodeString("//query/place/getAllPlacesSearchedByCountryId/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setString(2, placeSearchVO.getSearchKeyword());
					stmt.setInt(3, placeSearchVO.getEndIndex());
					stmt.setInt(4, placeSearchVO.getStartIndex());						
				}
				else {
					query = XML.getNodeString("//query/place/getAllPlaces/text()");
					
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, placeType);
					stmt.setInt(2, placeSearchVO.getEndIndex());
					stmt.setInt(3, placeSearchVO.getStartIndex());
				}				
			}
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				placeVO = new PlaceVO();
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setLatitude(rs.getInt("LATITUDE"));
				placeVO.setLongitude(rs.getInt("LONGITUDE"));
				placeVO.setAddress(rs.getString("ADDRESS"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				placeVO.setDescription(rs.getString("DESCRIPTION"));
				placeVO.setIsNewPlace(rs.getInt("IS_NEW_PLACE"));
				String email = rs.getString("EMAIL");
				placeVO.setCountryId(rs.getInt("COUNTRY_ID"));
				
				MemberVO member = new MemberVO();
				
				member.setEmail(email);
				placeVO.setWriter(member);
				
				places.add(placeVO);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}

		return places;
		
	}

	/** 
	 * 
	 * 모든 Place 총 개수 출력
	 * @author 이기연
	 * @return
	 */
	public int getAllPlaceCount(PlaceSearchVO placeSearchVO, int placeType) {
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int placeCount = 0;
		String query = "";

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);
			
			if (placeSearchVO.getSearchList().equals("placeName")) { 
				query = XML.getNodeString("//query/place/getAllPlaceCountSearchedByPlaceName/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, placeType);
				stmt.setString(2, placeSearchVO.getSearchKeyword());
			}
			else if (placeSearchVO.getSearchList().equals("email")) {
				query = XML.getNodeString("//query/place/getAllPlaceCountSearchedByEmail/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, placeType);
				stmt.setString(2, placeSearchVO.getSearchKeyword());
			} 
			else if (placeSearchVO.getSearchList().equals("countryId")) {
				query = XML.getNodeString("//query/place/getAllPlaceCountSearchedByCountryId/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, placeType);
				stmt.setString(2, placeSearchVO.getSearchKeyword());
			}
			else {
				query = XML.getNodeString("//query/place/getAllPlaceCount/text()");
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, placeType);
			}
			
			rs = stmt.executeQuery();

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
	 * place Detail 보여주기
	 * @author 이기연
	 * @param placeId
	 * @return
	 */
	public PlaceVO getPlaceDetailByPlaceId(String placeId) {
		
		PlaceVO placeVO = new PlaceVO();
		
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/getPlaceDetailByPlaceId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, placeId);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				
				placeVO.setPlaceId(rs.getInt("PLACE_ID"));
				placeVO.setPlaceName(rs.getString("PLACE_NAME"));
				placeVO.setLatitude(rs.getInt("LATITUDE"));
				placeVO.setLongitude(rs.getInt("LONGITUDE"));
				placeVO.setAddress(rs.getString("ADDRESS"));
				placeVO.setViewCount(rs.getInt("VIEW_COUNT"));
				placeVO.setLikeCount(rs.getInt("LIKE_COUNT"));
				placeVO.setDescription(rs.getString("DESCRIPTION"));
				placeVO.setIsNewPlace(rs.getInt("IS_NEW_PLACE"));
				String email = rs.getString("EMAIL");
				placeVO.setCountryId(rs.getInt("COUNTRY_ID"));
				
				MemberVO member = new MemberVO();
				
				member.setEmail(email);
				placeVO.setWriter(member);
							
			}
			return placeVO;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
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
	 * placeId로 place 삭제
	 * @author 이기연
	 * @param placeId
	 */
	public void deletePlaceByPlaceId(int placeId) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/deletePlaceByPlaceId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, placeId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				System.out.println("place 삭제 성공");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}		
	}

	/**
	 * PlaceId로 New place를 Origin Place로 고치는 작업
	 * @author 이기연
	 * @param parseInt
	 */
	public void goOriginPlaceByPlaceId(int placeId) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/goOriginPlaceByPlaceId/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);

			stmt.setInt(1, placeId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				System.out.println("place 를 origin place로 보내기 성공");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}			
	}

	/**
	 * PlaceId로 Origin place를 New Place로 고치는 작업
	 * @author 이기연
	 * @param placeId
	 */
	public void goNewPlaceByPlaceId(int placeId) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/goNewPlaceByPlaceId/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);

			stmt.setInt(1, placeId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
				System.out.println("Origin place를 New Place로 고치는 작업 성공");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	/**
	 * @author 이기연 placeName을 수정/ 업데이트 
	 * @param updatedPlaceName 
	 * @param placeId 
	 */
	public void updatePlaceName(String placeId, String updatedPlaceName) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/updatePlaceName/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);

			stmt.setString(1, updatedPlaceName);
			stmt.setString(2, placeId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}

	/**
	 * @author 이기연 place 내용을 수정/ 업데이트 
	 * @param updatedDescription 
	 * @param placeId 
	 */
	public void updateDescription(String placeId, String updatedDescription) {
		int insertCount = 0;
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_TRAVERY_USER, Const.DB_TRAVERY_PASSWORD);

			String query = XML.getNodeString("//query/place/updateDescription/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);

			stmt.setString(1, updatedDescription);
			stmt.setString(2, placeId);

			insertCount = stmt.executeUpdate();

			if (insertCount > 0) {
				stmt.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}


}

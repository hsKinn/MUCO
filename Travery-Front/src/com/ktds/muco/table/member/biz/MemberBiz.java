package com.ktds.muco.table.member.biz;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.muco.table.member.dao.MemberDAO;
import com.ktds.muco.table.member.vo.MemberVO;
import com.ktds.muco.util.file.MultipartFile;
import com.ktds.muco.util.file.MultipartHttpServletRequest;

/**
 * 
 * @author 김광민
 *
 */
public class MemberBiz {

	private MemberDAO memberDAO;

	public MemberBiz() {
		memberDAO = new MemberDAO();
	}

	/**
	 * 
	 * 회원가입
	 * 
	 * @author 유병훈
	 * 
	 */
	public void addNewMember(HttpServletRequest request) {

		MemberVO memberVO = new MemberVO();
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		String name = request.getParameter("userName");

		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setName(name);

		memberDAO.addNewMember(memberVO);

	}

	/**
	 * 
	 * 로그인
	 * 
	 * @author 김광민
	 * 
	 */
	public boolean login(HttpServletRequest request) {

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(request.getParameter("userEmail"));
		memberVO.setPassword(request.getParameter("userPw"));

		MemberVO loginMemberVO = memberDAO.getMemberByEmailAndPassword(memberVO);

		// 해당 유저가 있으면 세션에 등록
		if (loginMemberVO != null) {

			HttpSession session = request.getSession();
			session.setAttribute("_MEMBER_", loginMemberVO);
		}

		return loginMemberVO != null;
	}

	public boolean logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		
		return true;

	}

	/**
	 * 회원 정보 변경 
	 * 
	 * @author 이기연
	 * 
	 */
	public boolean updatePersonalInfo(MultipartHttpServletRequest request) {
		boolean updateCheck = false;
		
		//1. 세션정보
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_MEMBER_");
		
		// 파일 받아오기 위한 
		MultipartFile file = request.getFile("file");
		File upFile = file.write("D:\\" + file.getFileName());
		
		String fileName = file.getFileName();
		String fileLocation = upFile.getPath(); 
		
		System.out.println(fileName);
		System.out.println(fileLocation);
		
		// 파일 check & send to DAO
		if (fileName.length() > 0 ) {
			memberVO.setMainImageName(fileName);
			memberVO.setMainImageLocation(fileLocation);
			
			memberDAO.addMainImage(memberVO);
			System.out.println("등록한 프로필 사진: " + fileName);
		}

		String name = request.getParameter("name");
		String password = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String phoneNumber = request.getParameter("phoneNumber");
		
		// name 비교
		if ( !name.equals(memberVO.getName()) ) {
			memberVO.setName(name);
			memberDAO.updateName(memberVO);
			updateCheck =  true;
		} 
		// password 비교 
		if ( !password.equals(memberVO.getPassword()) && newPassword.length() > 0 ) {
			memberVO.setPassword(newPassword);
			memberDAO.updatePassword(memberVO);
			updateCheck = true;
		}
		// phonenumber 비교
		if ( !phoneNumber.equals(memberVO.getPhoneNumber()) ) {
			memberVO.setPhoneNumber(phoneNumber);
			memberDAO.updatePhoneNumber(memberVO);
			updateCheck = true;
		} 
		
		
		// 사진 썸네일 생성하기 
		 try {
	            //썸네일 가로사이즈
	            int thumbnail_width = 100;
	            //썸네일 세로사이즈
	            int thumbnail_height = 100;
	            //원본이미지파일의 경로+파일명
	            File origin_file_name = new File("D:"+File.separator+fileName);
	            //생성할 썸네일파일의 경로+썸네일파일명
	            File thumb_file_name = new File("D:"+File.separator+"thumbnail" + fileName);
	 
	            BufferedImage buffer_original_image = ImageIO.read(origin_file_name);
	            BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height, BufferedImage.TYPE_3BYTE_BGR);
	            Graphics2D graphic = buffer_thumbnail_image.createGraphics();
	            graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
	            ImageIO.write(buffer_thumbnail_image, "jpg", thumb_file_name);
	            System.out.println("썸네일 생성완료");
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		return updateCheck;
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
	public boolean isExistName(String name) {

		return memberDAO.isExistName(name) > 0;
	}

}

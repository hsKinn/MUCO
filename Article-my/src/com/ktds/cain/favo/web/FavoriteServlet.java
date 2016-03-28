package com.ktds.cain.favo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.cain.favo.biz.FavoriteBiz;
import com.ktds.cain.favo.vo.FavoVO;
import com.ktds.cain.history.biz.OperationHistoryBiz;
import com.ktds.cain.history.vo.OperationHistoryVO;
import com.ktds.cain.member.vo.MemberVO;

/**
 * Servlet implementation class FavoriteServlet
 */
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FavoriteBiz favoriteBiz;
    private OperationHistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteServlet() {
        super();
        favoriteBiz = new FavoriteBiz();
        historyBiz = new OperationHistoryBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		FavoVO favoriteVO = new FavoVO();
		favoriteVO.setArticleId(articleId);
		favoriteVO.setMemberId(member.getMemberId());
		favoriteBiz.insertOrDeleteFavoriteData(favoriteVO);
		
		OperationHistoryVO historyVO =  (OperationHistoryVO) request.getAttribute("OperationHistoryVO");
		historyVO.setActionCode("AR_F");
		String message = "[%s]가 [%s]글을 즐겨찾기에 등록";
		
		boolean isExistFavoriteData = favoriteBiz.isExistFavoriteData(favoriteVO);
		if ( favoriteBiz.isExistFavoriteData(favoriteVO)) {
			message = "[%s]가 [%s]글을 즐겨찾기에서 삭제";
		}
		historyVO.setDescription( String.format(message, member.getMemberId(), articleId + "") );
		historyBiz.addHistory(historyVO);

		StringBuffer json = new StringBuffer();
		
		json.append("{");
		json.append("\"result\" : true");
		json.append(", \"isFavorite\" : " + isExistFavoriteData);
		json.append("}");
		
		// 해당 데이터가 json기술을 응용하여 jsp쪽의 데이터쪽으로 넘긴다.
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}

}

package com.ktds.muco.table.evaluation.biz;

import java.util.List;

import com.ktds.muco.table.evaluation.dao.EvaluationDAO;
import com.ktds.muco.table.evaluation.vo.EvaluationListVO;
import com.ktds.muco.table.evaluation.vo.EvaluationVO;

/**
 * 
 * @author 김광민
 *
 */
public class EvaluationBiz {

	EvaluationDAO evaluationDAO;
	
	public EvaluationBiz() {
		evaluationDAO = new EvaluationDAO();
	}

	/**
	 * @author 이기연
	 * 평가 점수의 평균을 받아오는 Biz
	 * @param placeId
	 * @return
	 */
	public EvaluationListVO getAvgEvaluationListByPlaceId(String placeId) {

		List<EvaluationVO> evaluations = evaluationDAO.getAvgEvaluationByPlaceId(placeId);
		EvaluationListVO evaluationList = new EvaluationListVO();
		evaluationList.setEvaluationList(evaluations);
		
		return evaluationList;
	}
	


}

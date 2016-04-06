package com.ktds.muco.table.evaluation.biz;

import com.ktds.muco.table.evaluation.dao.EvaluationDAO;
import com.ktds.muco.table.evaluation.vo.EvaluationVO;

/**
 * 
 * @author 김현섭
 *
 */
public class EvaluationBiz {
	
	private EvaluationDAO evaluationDAO;
	
	public EvaluationBiz() {
		evaluationDAO = new EvaluationDAO();
	}
	
	/**
	 * 
	 * Set Vote Score
	 * 
	 * @author 김현섭
	 * 
	 * @param voteScore
	 * @param member
	 * @return
	 */
	public boolean setVoteScore(int[] voteScore, EvaluationVO evaluation) {
		
		int check = 0;
		
		// 가져온 점수 만큼 반복하며 Score와 StandardId Set
		for ( int i=1; i <= voteScore.length ; i++ ) {
			
			evaluation.setScore(voteScore[i-1]);
			evaluation.setStandardId(i);
			
			check += evaluationDAO.setVoteScore( evaluation );
		}
		
		// Score 입력 Check
		if ( check == voteScore.length ) {
			return true;
		}
		else {
			return false;
		}
		
	} // setVoteScore END

	public boolean isExistVote(EvaluationVO evaluation) {
		
		return evaluationDAO.isExistVote ( evaluation ) > 0;
			
	}
	
	
	
	
}
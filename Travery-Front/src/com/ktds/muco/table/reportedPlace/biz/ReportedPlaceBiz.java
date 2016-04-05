package com.ktds.muco.table.reportedPlace.biz;

import com.ktds.muco.table.reportedPlace.dao.ReportedPlaceDAO;
import com.ktds.muco.table.reportedPlace.vo.ReportedPlaceVO;

/**
 * 
 * @author 김현섭
 *
 */
public class ReportedPlaceBiz {
	
	private ReportedPlaceDAO reportPlaceDAO;
	
	public ReportedPlaceBiz() {
		reportPlaceDAO = new ReportedPlaceDAO();
	}
	
	/**
	 * Set Report Place 
	 * 
	 * @author 김현섭
	 * 
	 * @param reportPlace
	 * @return
	 */
	public boolean setReportPlace(ReportedPlaceVO reportPlace) {
		
		return reportPlaceDAO.setReportPlace( reportPlace ) > 0;
	} // setReportPlace END
	
}

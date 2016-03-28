package com.ktds.cain.vo;

public class MovieVO extends GradeVO {

	private int movieId;
	private String title;
	private String startDate;
	private Double rate;
	private String runTime;
	private int gradeId;
	
	/**
	 *  Actor instants
	 *  query adding counts
	 */
	
	private int actorCount;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getActorCount() {
		return actorCount;
	}
	public void setActorCount(int actorCount) {
		this.actorCount = actorCount;
	}
	
}

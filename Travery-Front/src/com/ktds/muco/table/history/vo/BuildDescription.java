package com.ktds.muco.table.history.vo;

/**
 * 
 * @author 김광민
 *
 */
public class BuildDescription {

	public static String get(String format, String... args) {

		String desc = String.format(format, args);
		return desc;
	}
}

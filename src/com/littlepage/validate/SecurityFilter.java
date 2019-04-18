package com.littlepage.validate;

public class SecurityFilter {
	
	/**
	 * security 1=1
	 * when the 1=1 data enter to database, the database will be unsecurity.
	 */
	public static String securityFilter(String str){
		return str.replace("1=1", "");
	}
}

package utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_BASIC_TIME=20;

	public static String getEmailWithTimeStamp() {
		Date date = new Date();
		return "kpatil"+ date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}

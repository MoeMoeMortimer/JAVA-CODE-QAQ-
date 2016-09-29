package com.hpe.t9.date;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class TimeUtil {
	public static String getNow(){
		Date now = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.format(now);
		
	}
}

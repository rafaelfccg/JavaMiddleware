package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

	public static void log(String msg){
		SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		System.out.println(timeFormatter.format(System.currentTimeMillis()) + " - " + msg);
	}
	
}

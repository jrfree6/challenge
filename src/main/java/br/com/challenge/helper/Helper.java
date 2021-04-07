package br.com.challenge.helper;

import java.sql.Time;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	
	public static Date stringToDate(String strDate) { 
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd"); 
		
		Date date2;
		try {
			date2 = formatter2.parse(strDate.replace("\"", ""));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} 
		return date2; 
	}
	
	
	public static Time stringToTime(String strTime) {
		
		SimpleDateFormat formatter2=new SimpleDateFormat("HH:mm"); 
		
		Date date2;
		try {
			date2 = formatter2.parse(strTime.replace("\"", ""));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} 
		Time time = new Time(date2.getTime());
		
		return time;
	}
	public static String removeAccents(String str) {
		String retorno = new String("");
		if (str != null && !str.isEmpty()) {
		    str = Normalizer.normalize(str, Normalizer.Form.NFD);
		    str = str.replaceAll("[^\\p{ASCII}]", "");
		    str = str.replace("&", "E");
		    retorno =  str.toUpperCase(); 
		}else{
			retorno = new String("");
		}
	    return retorno;
	}
	
	

}

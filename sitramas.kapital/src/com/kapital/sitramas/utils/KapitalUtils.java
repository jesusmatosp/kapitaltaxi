package com.kapital.sitramas.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KapitalUtils {

	public static Date convertStringToDate(String dateString)
	{
	    Date date = null;
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    try{
	        date = df.parse(dateString);
	    }
	    catch ( Exception ex ){
	        System.out.println(ex);
	    }
	    return date;
	}
	
	public static String convertDateToString(Date date){
		String dateString = null;
		SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");
		try{
			dateString = fmt.format(date);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dateString;
	}
	
	public static String getCurrentDateYYYYMMDD(Date date){
		String dateString = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		try{
			dateString = fmt.format(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dateString;
	}
	
	public static Date getCurrentDate(){
		return new Date();
	}
}

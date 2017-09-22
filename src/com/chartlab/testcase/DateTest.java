package com.chartlab.testcase;
import java.lang.Math;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
     
		DateFormat newsDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm z");
		Date newsDate = newsDateFormat.parse("Wed, 16 Aug 2017 10:18 GMT");
		print(newsDate);
	}
	
	private static void print(Object data){
		System.out.println(data);
	}

}

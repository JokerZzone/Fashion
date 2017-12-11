package com.lanou.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String times) {
		// TODO Auto-generated method stub
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = dFormat.parse(times);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("时间转换器error");
			e.printStackTrace();
		}
		return date;
	}
	
	
}

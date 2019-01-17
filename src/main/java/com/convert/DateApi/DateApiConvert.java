package com.convert.DateApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateApiConvert {
	public static LocalDate convertUtilCalendarToTimeLocalDate(Calendar c)
	{	 
		return c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalTime convertUtilCalendarToTimeLocalTime(Calendar c)
	{
		return c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}
	
	public static LocalDateTime convertUtilCalendarToTimeLocalDateTime(Calendar c)
	{
		return c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
	}
	public static Date convertTimeLocalTimeToUtilDate(LocalDateTime dateTime)
 	{	
 		Date in = new Date();
 		dateTime = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
 		return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
 	}
 	
 	public static Date convertStringToUtilDate(String str)throws Exception
 	{
 		DateFormat f = new SimpleDateFormat("MM/dd/yy");
 		return  f.parse(str);	
 	}
	
	public static ZonedDateTime convertCalendarToZonedTime(Calendar c,ZoneId zid)
	{	
		return ZonedDateTime.of(convertUtilCalendarToTimeLocalDateTime(c), zid);
		
	}
	
	public static OffsetDateTime convertDateToOffsetDateTime(Calendar cal,ZoneOffset offset)
	{

       return OffsetDateTime.of(convertUtilCalendarToTimeLocalDateTime(cal), offset);
       
	}
	
	public static int usingUtilCalenderToFetchMonthDay(Calendar cal)
	{
		return convertUtilCalendarToTimeLocalDateTime(cal).getDayOfMonth();
	}
	
	public static Period usingUtilClaendarToTimeFindPeriod( LocalDate d1,LocalDate d2)
	{
		
		return Period.between(d1, d2);	
	}
	
 	public static Date convertUtilDateToTimeLocalDate(LocalDate dat)
 	{
 		return Date.from(dat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

 	}
 	

}

package com.convert.DateApi;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
//import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

//import org.junit.Before;
import org.junit.Test;

import org.junit.Test;

public class DateApiConvertTest {

	@Test
	public void testConvertJavaUtilCalendarToJavaTimeLocalDate() {
		Calendar c = Calendar.getInstance();
		c.set(2018, Calendar.APRIL, 05);
		LocalDate l = LocalDate.of(2018, 04, 05);
		LocalDate l1 = LocalDate.now();

		assertEquals(l, DateApiConvert.convertUtilCalendarToTimeLocalDate(c));
		assertNotEquals(l1, DateApiConvert.convertUtilCalendarToTimeLocalDate(c));
	}

	public void testConvertJavaUtilCalendarToJavaTimeLocalTime() {
		Calendar c = Calendar.getInstance();
		int h = LocalTime.now().getHour();
		int m = LocalTime.now().getMinute();

		assertEquals(h, DateApiConvert.convertUtilCalendarToTimeLocalTime(c));
		assertEquals(m, DateApiConvert.convertUtilCalendarToTimeLocalTime(c));

	}

	public void testConvertJavaUtilCalendarToJavaTimeLocalDateTime() {
		Calendar c = Calendar.getInstance();
		LocalDateTime l = LocalDateTime.now();

		assertEquals(l.getYear(), DateApiConvert.convertUtilCalendarToTimeLocalDateTime(c).getYear());
		assertEquals(l.getMonth(), DateApiConvert.convertUtilCalendarToTimeLocalDateTime(c).getMonth());
		assertEquals(l.getHour(), DateApiConvert.convertUtilCalendarToTimeLocalDateTime(c).getHour());
		assertEquals(l.getMinute(), DateApiConvert.convertUtilCalendarToTimeLocalDateTime(c).getMinute());
	}

	@Test
	public void testConvertJavaUtilCalendarToZonedTime() {
		ZoneId zoneid = ZoneId.of("America/Los_Angeles");
		Calendar c = Calendar.getInstance();
		ZonedDateTime z = ZonedDateTime.of(LocalDateTime.now(), zoneid);

		assertEquals(z.getHour(), DateApiConvert.convertCalendarToZonedTime(c, zoneid).getHour());
		assertEquals(z.getMinute(), DateApiConvert.convertCalendarToZonedTime(c, zoneid).getMinute());
	}

	@Test
	public void testConvertJavaUtilDateToOffsetDateTime() {
		Calendar cal = Calendar.getInstance();
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(1, 30);
		OffsetDateTime d = OffsetDateTime.of(LocalDateTime.of(2017, 05, 12, 05, 45), ZoneOffset.ofHoursMinutes(6, 30));

		assertNotEquals(d, DateApiConvert.convertDateToOffsetDateTime(cal, offset));

	}

	@Test
	public void testUsingJavaUtilCalenderToFetchMonthDay() {
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.JANUARY, 3);
		LocalDate ld = LocalDate.of(2019, 1, 3);

		assertEquals(ld.getDayOfMonth(), DateApiConvert.usingUtilCalenderToFetchMonthDay(cal));
	}

	@Test
	public void testUsingJavaUtilClaendarToFindPeriod() {
		LocalDate da2 = LocalDate.of(2019, 1, 16);
		LocalDate da1 = LocalDate.of(1895, 1, 16);
		Period p = Period.between(da1, da2);

		assertEquals(p.getYears(), DateApiConvert.usingUtilClaendarToTimeFindPeriod(da1, da2).getYears());
	}

	@Test
	public void testConvertJavaTimeLocalTimeToJavaUtilDate() throws Exception {
		String str = "11/23/2015";
		Date d1 = DateApiConvert.convertStringToUtilDate(str);
		LocalDate d2 = LocalDate.of(2015, 11, 23);

		assertEquals(d1, DateApiConvert.convertUtilDateToTimeLocalDate(d2));
	}

}

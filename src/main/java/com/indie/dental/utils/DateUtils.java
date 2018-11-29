package com.indie.dental.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateUtils {
    public static Date covertDatePattern(String date) throws ParseException {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return inputFormat.parse(date.toString());
    }

    public static Date covertDateUTCPattern(String date) throws ParseException {
//        new Locale("th", "TH")
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return inputFormat.parse(date.toString());
    }
}

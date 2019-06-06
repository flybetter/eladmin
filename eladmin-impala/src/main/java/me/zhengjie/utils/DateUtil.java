package me.zhengjie.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private DateUtil() {

    }

    private static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        return simformat.format(date);
    }

    public static Date getDateParse(String date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        try {
            return simformat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatCSTTime(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date d = sdf.parse(date);
        return DateUtil.getDateFormat(d, format);
    }
}

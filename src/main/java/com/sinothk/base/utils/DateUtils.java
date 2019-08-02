package com.sinothk.base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 根据自定格式获取当前日期:pattern:YYYYMMDD
     *
     * @param pattern 时间的格式：YYYYMMDD或yyyyMMddkkmmssSSS等
     */
    public static String getDateTime(String pattern) {
        if (pattern == null || "".equals(pattern)) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.DAY_OF_MONTH, 0);
        return sdf.format(rightNow.getTime());
    }

    /**
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateTime(Date date, String pattern) {
        if (date == null) {
            return "";
        }

        if (pattern == null || "".equals(pattern)) {
            pattern = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}

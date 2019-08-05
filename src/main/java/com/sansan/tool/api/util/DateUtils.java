package com.sansan.tool.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

    /**
     * 每周的第一天和最后一天
     * @param dataStr
     * @param dateFormat
     * @param resultDateFormat
     * @return
     * @throws ParseException
     */
    public static String getFirstAndLastOfWeek(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        return data1 + "_" + data2;
    }

    public static String getAllDaysOfWeek(String dataStr) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // Mon
        String data1 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 1);
        // Tue
        String data2 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 1);
        // Wed
        String data3 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 1);
        // Thu
        String data4 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 1);
        // Fri
        String data5 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 1);
        // Sat
        String data6 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 1);
        // Sun
        String data7 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return data1 + "_" + data2 + "_" + data3 +"_" + data4 + "_" + data5 + "_" + data6 + "_" + data7;
    }
}

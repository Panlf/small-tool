package com.plf.tool.common.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author panlf
 * @date 2023/6/25
 */
public class DateUtils {
    public static Date getLastYear(Date date){
        return toDate(toLocalDate(date).minusYears(1));
    }

    public static Date toDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static LocalDate toLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDate();
    }

    public static long getDays(Date date1, Date date2){
        long milliseconds1 = date1.getTime();
        long milliseconds2 = date2.getTime();
        long diff = milliseconds2 - milliseconds1;
        return diff / (24 * 60 * 60 * 1000);
    }
}

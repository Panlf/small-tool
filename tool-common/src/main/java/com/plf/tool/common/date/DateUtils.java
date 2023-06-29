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

    private static Date toDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    private static LocalDate toLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDate();
    }
}

package com.plf.tool.common.date;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CompareTwoDateUtils {
    private static final List<String> xiuArray;
    private static final List<String> buArray;

    public static void main(String[] args) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(flag.compareTo(endTime));
        //3 4 5
        //System.out.println(DateUtil.date());
        System.out.println(CompareTwoDateUtils.calLeaveDays(simpleDateFormat.parse("2022-06-23 10:00:00"),simpleDateFormat.parse("2022-07-08 12:00:00")));
    }

    // http://timor.tech/api/holiday/year/2022
    // 获取休息和补班
    static {
        xiuArray =
                Arrays.asList("2022-01-01", "2022-01-02", "2022-01-03", "2022-01-31", "2022-02-01", "2022-02-02"
                        , "2022-02-03", "2022-02-04", "2022-02-05", "2022-02-06", "2022-04-03", "2022-04-04",
                        "2022-04-05", "2022-04-30", "2022-05-01", "2022-05-02", "2022-05-03", "2022-05-04",
                        "2022-06-03", "2022-06-04", "2022-06-05", "2022-09-10", "2022-09-11", "2022-09-12",
                        "2022-10-01", "2022-10-02", "2022-10-03", "2022-10-04", "2022-10-05", "2022-10-06", "2022-10-07");

        buArray = Arrays.asList("2022-01-29", "2022-01-30", "2022-04-02",
                "2022-04-24", "2022-05-07", "2022-10-08", "2022-10-09");
    }

    public static int calLeaveDays(Date startTime, Date endTime) {
        int leaveDays = 0;
        //从startTime开始循环，若该日期不是节假日或者不是周六日，或者在补班内则天数+1
        Date flag = startTime;//设置循环开始日期
        Calendar cal = Calendar.getInstance();
        //循环遍历每个日期
        while (flag.compareTo(endTime) < 0) {
            cal.setTime(flag);
            //判断是否在补班内，如果在补班内，则+1
            if (!isExist(flag, buArray)) {
                //判断是否为周六日
                int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
                if (week == 0 || week == 6) {//0为周日，6为周六
                    //跳出循环进入下一个日期
                    cal.add(Calendar.DAY_OF_MONTH, +1);
                    flag = cal.getTime();
                    continue;
                }
                //判断是否为节假日
                try {
                    if (isExist(flag, xiuArray)) {
                        //跳出循环进入下一个日期
                        cal.add(Calendar.DAY_OF_MONTH, +1);
                        flag = cal.getTime();
                        continue;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //不是节假日或者周末，或者在调休中，天数+1
            leaveDays = leaveDays + 1;
            //日期往后加一天
            cal.add(Calendar.DAY_OF_MONTH, +1);
            flag = cal.getTime();
        }
        return leaveDays;
    }

    private static boolean isExist(Date date, List<String> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(date.getTime());
        for (String s : list) {
            if (s.equalsIgnoreCase(time)) {
                return true;
            }
        }
        return false;
    }
}

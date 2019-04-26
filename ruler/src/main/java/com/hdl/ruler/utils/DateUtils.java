package com.hdl.ruler.utils;


import com.hdl.ruler.bean.TimeSlot;

import java.text.SimpleDateFormat;

/**
 * 时间工具
 * Created by HDL on 2017/7/25.
 */

public class DateUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    /**
     * 获取当前时间的起点（00:00:00）
     *
     * @param currentTime
     * @return
     */
    public static long getTodayStart(long currentTime) {
        return 3600 * 1000 * 24;
    }

    /**
     * 获取当前时间的小时值
     *
     * @param currentTime
     * @return
     */
    public static int getHour(long currentTime) {
        currentTime = currentTime / 1000;
        currentTime %= 3600 * 24;
        return (int) (currentTime / 3600);

    }

    /**
     * 获取当前时间的分钟值
     *
     * @param currentTime
     * @return
     */
    public static int getMinute(long currentTime) {
        currentTime = currentTime / 1000;
        currentTime %= 3600;
        return (int) (currentTime / 60);
    }

    /**
     * 获取当前时间的秒数
     *
     * @param currentTime
     * @return
     */
    public static int getSecond(long currentTime) {
        currentTime = currentTime / 1000;
        return (int) (currentTime % 60);
    }

    /**
     * 获取当前时间的分钟值+毫秒值
     *
     * @param currentTime
     * @return
     */
    public static int getMinuteMillisecond(long currentTime) {
        return (int) (currentTime % (3600 * 1000));
    }

    /**
     * 获取当前时间的毫秒值
     *
     * @param currentTime
     * @return
     */
    public static int getMillisecond(long currentTime) {
        return (int) (currentTime % (1000));
    }

    /**
     * 获取当前时间的终点（23:59:59）
     *
     * @param currentTime
     * @return
     */
    public static long getTodayEnd(long currentTime) {
        return getTodayStart(currentTime) + 24 * 60 * 60 * 1000L - 1000;
    }

    /**
     * 获取指定时间的年月日
     *
     * @param currentTime
     * @return
     */
    public static String getDateByCurrentTiem(long currentTime) {
        currentTime /= 1000;
        int hour = (int) ((currentTime % (3600 * 24)) / 3600);
        int min = (int) ((currentTime % (3600)) / 60);
        int sec = (int) (currentTime % 60);
        return String.format("%02d:%02d:%02d",hour,min,sec);
    }

    /**
     * 获取指定时间的年月日
     *
     * @param currentTime
     * @return
     */
    public static String getDateTime(long currentTime) {
        currentTime /= 1000;
        int hour = (int) ((currentTime % (3600 * 24)) / 3600);
        int min = (int) ((currentTime % (3600)) / 60);
        int sec = (int) (currentTime % 60);
        return String.format("%02d:%02d:%02d",hour,min,sec);
    }

    /**
     * 根据下标获取HH:mm格式的时间
     *
     * @param timeIndex
     * @return
     */
    public static String getHourMinute(int timeIndex) {
        return format.format(timeIndex * 60 * 1000 + 16 * 60 * 60 * 1000);
    }

    /**
     * 根据下标获取HH:mm格式的时间
     *
     * @param timeIndex
     * @return
     */
    public static String getHourMinute(int timeIndex, int second) {
        return format.format(timeIndex * 60 * 1000 + 16 * 60 * 60 * 1000 + second * 1000);
    }

    /**
     * 获取指定日期的时间（如：10:11:12）
     *
     * @param currentTime
     * @return
     */
    public static String getTime(long currentTime) {
        currentTime /= 1000;
        int hour = (int) ((currentTime % (3600 * 24)) / 3600);
        int min = (int) ((currentTime % (3600)) / 60);
        int sec = (int) (currentTime % 60);
        return String.format("%02d:%02d:%02d",hour,min,sec);

    }

    /**
     * 根据当前的秒数计算时间
     *
     * @param currentSecond
     * @return
     */
    public static String getTimeByCurrentSecond(int currentSecond) {
        currentSecond = currentSecond / 60;
        int minute = currentSecond % 60;
        int hour = currentSecond / 60;
        if (hour >= 24) {
            hour = hour % 24;
        }
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    }

    /**
     * 根据当前的秒数计算时间
     *
     * @param currentSecond
     * @return
     */
    public static String getTimeByCurrentHours(int currentSecond) {
        currentSecond = currentSecond * 10;
        currentSecond = currentSecond / 60;
        int minute = currentSecond % 60;
        int hour = currentSecond / 60;
        if (hour >= 24) {
            hour = hour % 24;
        }
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    }

    public static void main(String[] args) {
        TimeSlot timeSlot = new TimeSlot(DateUtils.getTodayStart(System.currentTimeMillis()), DateUtils.getTodayStart(System.currentTimeMillis()) - 60 * 60 * 1000, DateUtils.getTodayStart(System.currentTimeMillis()) + 120 * 60 * 1000);
        System.out.println(timeSlot.toString());
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean isCurrentTimeArea(long nowTime, long beginTime, long endTime) {
        return nowTime >= beginTime && nowTime <= endTime;
    }

    /**
     * 判断指定时间段是否包含在某个时间段
     *
     * @return
     */
    public static boolean isContainTime(TimeSlot timeSlot, long beginTime, long endTime) {
//        ELog.e(timeSlot);
//        ELog.e("beginTime = "+beginTime);
//        ELog.e("endTime = "+endTime);
        return beginTime >= timeSlot.getStartTimeMillis() && endTime <= timeSlot.getEndTimeMillis();
    }
}

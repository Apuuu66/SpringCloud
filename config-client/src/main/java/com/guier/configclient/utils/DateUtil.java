package com.guier.configclient.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DateUtil {
    public static void main(String[] args) {
//        LocalDateTime to = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);//当天24点
//        long start = to.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
//        System.out.println(to);
//        System.out.println(start);
//        System.out.println(LocalDateTime.now());
//        System.out.println(date2timestamp(LocalDateTime.now()));
//        System.out.println(new Date().getTime());
//        System.out.println(timestamp2date(new Date().getTime()));
//        localDateTime2date(LocalDateTime.now());
//        date2localDateTime(new Date());
//         System.out.println(LocalDateTime.parse("2020-10-01 10:20:03", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//         System.out.println(LocalDateTime.now().minusHours(1));


        // LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
        // LocalDateTime now = LocalDateTime.now();
        // LocalDateTime startTime = now.minusHours(1);
        // LocalDateTime from = LocalDateTime.of(startTime.toLocalDate(), LocalTime.of(startTime.getHour(), 0, 0));
        // LocalDateTime to = LocalDateTime.of(now.toLocalDate(), LocalTime.of(now.getHour(), 0, 0));
        // System.out.println(from);
        // System.out.println(to);
        List<String> betweenDate = getBetweenDate("2020-02-01", "2020-03-03");
        System.out.println(betweenDate);
    }

    /**
     * LocalDateTime转时间戳
     *
     * @param localDateTime
     * @return long
     */
    public static long date2timestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }


    /**
     * 时间戳转LocalDateTime
     *
     * @param timestamp
     * @return LocalDateTime
     */
    public static LocalDateTime timestamp2date(long timestamp) {

//        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * LocalDateTime转Date
     *
     * @param localDateTime
     * @return Date
     */
    public static Date localDateTime2date(LocalDateTime localDateTime) {
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = localDateTime.atZone(zoneId);
//        Date date = Date.from(zdt.toInstant());
//        System.out.println("LocalDateTime = " + localDateTime);
//        System.out.println("Date = " + date);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转LocalDateTime
     *
     * @param date
     * @return LocalDateTime
     */
    public static LocalDateTime date2localDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    /**
     * 获取近X小时的整点时间，eg：当前2020-03-02 14:15，hour=1，输出2020-03-02 13:00
     *
     * @param hour
     * @return LocalDateTime
     */
    public static LocalDateTime approachXHour(int hour) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = now.minusHours(hour);
        LocalDateTime localDateTime = LocalDateTime.of(startTime.toLocalDate(), LocalTime.of(startTime.getHour(), 0, 0));
        return localDateTime;
    }

    /**
     * 获取近X天的时间，eg：当前2020-03-20 14:15，day=10，输出2020-03-10 14:15
     *
     * @param day
     * @return LocalDateTime
     */
    public static LocalDateTime approachXDay(int day) {
        return LocalDateTime.now().minusDays(day);
    }

    /**
     * 格式化日期，默认返回 yyyy-MM-dd HH:mm:ss
     * 特殊格式自己指定，如 yyyy-MM-dd HH:mm:ss:SSS
     *
     * @param localDateTime
     * @return String
     */
    public static String format(LocalDateTime localDateTime) {
        // System.out.println(LocalDateTime.parse("2020-10-01 10:20:03", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 从字符串解析时间,默认解析格式 yyyy-MM-dd HH:mm:ss
     *
     * @param text
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String text) {
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     *
     *
     */
    /**
     *获取一段时间
     * @param start "2020-02-01"
     * @param end "2020-03-03"
     * @return
     */
    public static List<String> getBetweenDate(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println(distance);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusDays(1)).limit(distance + 1).forEach(f -> list.add(f.toString()));
        return list;
    }

    /**
     * 字符串格式时间戳转date
     */
    public static String tempToDate (String sTime){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long slongTimeStamp = new Long(Long.parseLong(sTime));
        Date sTimeDate = new Date(slongTimeStamp);
        String timeformat = simpleDateFormat.format(sTimeDate);
        return timeformat;
    }

}

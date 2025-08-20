/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 19:32:42 UTC+08:00
 ****************************************************/
package org.example.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("date = " + date);
        System.out.println("date.getTime() = " + date.getTime());
        // 获取1天前的时间
        Date beforeDate = new Date(new Date().getTime() - (60 * 60 * 24 * 1000L));
        System.out.println("beforeDate = " + beforeDate);
        // 时间字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EE");
        String dateFormat = simpleDateFormat.format(new Date());
        System.out.println("dateFormat = " + dateFormat);
        // 字符串转Date
        String stringDate = "2028-11-20 15:23:45";
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDate);
        System.out.println("parse = " + parse);
        
        String result = new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse("2000-11-11"));
        System.out.println("result = " + result);
        
        // ZoneId - 时区
        // 获取Java支持的所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("availableZoneIds.toString() = " + availableZoneIds.toString());
        // 获取当前默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId.toString() = " + zoneId.toString());
        // 获取指定的时区
        ZoneId zoneId1 = ZoneId.of("Asia/Shanghai");
        
        // Instant - 时间
        Instant now = Instant.now();
        System.out.println("now = " + now);
        ZonedDateTime zonedDateTime = now.atZone(zoneId1);
        System.out.println("zonedDateTime = " + zonedDateTime);
        Instant before = now.minusSeconds(24 * 60 * 60);
        System.out.println("before = " + before);
        
        // ZoneDateTime - 带时区的日期时间
        System.out.println("ZonedDateTime.now() = " + ZonedDateTime.now());
        System.out.println("ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()) = " + ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        
        // DateTimeFormatter
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ZonedDateTime.now());
        System.out.println("format = " + format);
        
        // LocalDate
        System.out.println("LocalDate.now() = " + LocalDate.now());
        System.out.println("LocalDate.now().getDayOfMonth() = " + LocalDate.now().getDayOfMonth());
        System.out.println("LocalDate.now().getMonth() = " + LocalDate.now().getMonthValue());
        System.out.println("LocalDate.now().getYear() = " + LocalDate.now().getYear());
        
        // LocalTime
        System.out.println("LocalTime.now() = " + LocalTime.now());
        System.out.println("LocalTime.now().getHour() = " + LocalTime.now().getHour());
        System.out.println("LocalTime.now().getMinute() = " + LocalTime.now().getMinute());
        System.out.println("LocalTime.now().getSecond() = " + LocalTime.now().getSecond());
        System.out.println("LocalTime.now().getNano() = " + LocalTime.now().getNano());
        
        // LocalDateTime
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        System.out.println("LocalDateTime.now().getYear() = " + LocalDateTime.now().getYear());
        System.out.println("LocalDateTime.now().getMonthValue() = " + LocalDateTime.now().getMonthValue());
        System.out.println("LocalDateTime.now().getDayOfMonth() = " + LocalDateTime.now().getDayOfMonth());
        System.out.println("LocalDateTime.now().getHour() = " + LocalDateTime.now().getHour());
        System.out.println("LocalDateTime.now().getMinute() = " + LocalDateTime.now().getMinute());
        System.out.println("LocalDateTime.now().getSecond() = " + LocalDateTime.now().getSecond());
        System.out.println("LocalDateTime.now().format(DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss\")) = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        LocalDateTime from = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2015-02-14 14:34:21"));
        System.out.println("from = " + from);
        
    }
}

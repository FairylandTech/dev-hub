/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 20:08:36 UTC+08:00
 ****************************************************/
package org.example.calender;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        
        calendar.add(Calendar.DATE, -1);
        
        String beforeDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
        System.out.println("beforeDay = " + beforeDay);
        System.out.println("calendar.getTimeInMillis() = " + calendar.getTimeInMillis());
    }
}

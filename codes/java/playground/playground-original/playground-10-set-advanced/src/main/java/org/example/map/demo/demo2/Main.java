/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 20:25:48 UTC+08:00
 ****************************************************/
package org.example.map.demo.demo2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Lionel Johnson
 */
public class Main {
    /*
     * 某个班级80名学生，现在需要组成秋游活动，班长提供了四个景点依次是（A、B、C、D）,每个学生只
     * 能选择一个景点，请统计出最终哪个景点想去的人数最多。
     * */
    public static void main(String[] args) {
        HashMap<String, Integer> ticketHashMap = getTicketHashMap();
        
        System.out.println("ticketHashMap = " + ticketHashMap);
        
        int maxValue = 0;
        for (Map.Entry<String, Integer> entry : ticketHashMap.entrySet()) {
            if (maxValue < entry.getValue()) {
                maxValue = entry.getValue();
            }
        }
        System.out.println("maxValue = " + maxValue);
        
        for (Map.Entry<String, Integer> entry : ticketHashMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey());
            }
        }
    }
    
    private static HashMap<String, Integer> getTicketHashMap() {
        String[] ticketsName = {"A", "B", "C", "D"};
        HashMap<String, Integer> ticketHashMap = new HashMap<>();
        Random random = new Random();
        
        for (int i = 0; i < 80; i++) {
            String ticketName = ticketsName[random.nextInt(4)];
            
            if (ticketHashMap.containsKey(ticketName)) {
                ticketHashMap.put(ticketName, ticketHashMap.get(ticketName) + 1);
            } else {
                ticketHashMap.put(ticketName, 1);
            }
        }
        return ticketHashMap;
    }
}

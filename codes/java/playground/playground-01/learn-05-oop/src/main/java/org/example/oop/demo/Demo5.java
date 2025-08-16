/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 13:32:27 UTC+08:00
 ****************************************************/
package org.example.oop.demo;

import org.example.enums.Gender;
import org.example.oop.demo.cls.GirlFriend;

/**
 * @author Lionel Johnson
 */
public class Demo5 {
    /*
     * 定义数组存储4个女朋友的对象
     * 女朋友的属性：姓名、年龄、性别、爱好
     * 要求1：计算出四个女朋友的平均年龄
     * 要求2：统计年龄比平均值低的女朋友有几个？并把她们的所有信息打印出来。
     * */
    public static void main(String[] args) {
        GirlFriend[] girlFriends = {
                new GirlFriend("何瑾春", 18, Gender.FEMALE, "吃饭"),
                new GirlFriend("郝欣宜", 20, Gender.FEMALE, "睡觉"),
                new GirlFriend("方淑华", 22, Gender.FEMALE, "看剧"),
                new GirlFriend("傅娟", 21, Gender.FEMALE, "美食"),
        };
        
        int ageSum = 0;
        for (GirlFriend girlFriend : girlFriends) {
            ageSum += girlFriend.getAge();
        }
        
        int ageAvg = ageSum / girlFriends.length;
        
        int counter = 0;
        for (GirlFriend girlFriend : girlFriends) {
            if (girlFriend.getAge() < ageAvg) {
                counter++;
                System.out.println(girlFriend.toString());
            }
        }
        
        System.out.printf("平均年龄: %s", ageAvg);
        System.out.printf("比平均值低的女朋友有%s个", counter);
    }
}

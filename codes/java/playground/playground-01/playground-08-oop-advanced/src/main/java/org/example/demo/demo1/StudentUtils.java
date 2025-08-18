/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-17 22:01:55 UTC+08:00
 ****************************************************/
package org.example.demo.demo1;


import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class StudentUtils {
    public static int averageAge(@NotNull ArrayList<Student> students) {
        int ageSum = 0;
        for (Student student : students) {
            ageSum += student.getAge();
        }
        return ageSum / students.size();
    }
    
    public static int maxAge(@NotNull ArrayList<Student> students) {
        int max = students.get(0).getAge();
        
        for (int i = 1; i < students.size(); i++) {
            if (max < students.get(i).getAge()) {
                max = students.get(i).getAge();
            }
        }
        
        return max;
    }
}

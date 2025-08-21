/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 21:51:43 UTC+08:00
 ****************************************************/
package org.example.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Lionel Johnson
 */
public class ForzenSet {
    public static void main(String[] args) {
        List<String> strings = Collections.unmodifiableList(Arrays.asList("1", "2"));
        
        // JDK 9+ List<String> strings = List.of("1", "2")
        
        for (String s : strings) {
            System.out.println(s);
        }
    }
}

/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 15:43:16 UTC+08:00
 ****************************************************/
package org.example.build;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class StringBuild {

    public static String build(ArrayList<String> stringArrayList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : stringArrayList) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

}

/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 14:33:44 UTC+08:00
 ****************************************************/
package org.example.generics;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class ListUtils {
    private ListUtils() {
    }
    
    public static <E> void addAll(ArrayList<E> list, E... e) {
        for (E e1 : e) {
            list.add(e1);
        }
    }
}

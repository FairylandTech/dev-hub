package org.example;

import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        
        ArrayList<Byte> byteList = new ArrayList<>();
        Collections.addAll(byteList, (byte) 98, (byte) 75, (byte) 54);
        
        System.out.println(byteList);
    }
}

package com.prashhanth.secuirty.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateRecord {
    static List<String> al= new ArrayList<>();
    static{
        al.add("Lenovo");
        al.add("Asus");
        al.add("Acer");
        al.add("Mi");
    }
    public static boolean isBrandChk(String laptop){
        for (String chineseLaptop:
             al) {
            if(laptop.equals(chineseLaptop))
                throw new RuntimeException("Chinese not allowed");
        }
        return false;
    }
}

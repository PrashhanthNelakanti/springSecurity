package com.prashhanth.secuirty.rnd;

import java.util.Scanner;

public class Sample {


    public static void main(String[] args) {
        Sample sample= new Sample();
        String str=sample.returnWord();
        System.out.println("Hello "+str);
        //String output= reverse(str);
        int lenght=a(str);
        System.out.println(lenght);
    }

    public  String returnWord(){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter any text");
        return s.nextLine();
    }

    //mahesh
    public static String reverse(String s){
        String rev=null;
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >=0 ; i--) {
            System.out.println(chars[i]);
            rev= String.valueOf(chars[i])+"";
        }
        return rev;
    }
    public static int a(String str){
        int len=str.length();
        return len;
    }




}

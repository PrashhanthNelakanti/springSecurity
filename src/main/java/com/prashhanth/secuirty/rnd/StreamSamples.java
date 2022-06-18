package com.prashhanth.secuirty.rnd;

public class StreamSamples {

    public static void main(String[] args) {
        String str="aabbbccccdd";
        char[] chars = str.toCharArray();
        int count=0;
        String res="";
        for (int i = 0; i < chars.length-1; i++) {
             if(chars[i]==chars[i+1]){
                 count=count+1;
                 res=res+count;
             }
             else{
                 //count=+1;
                 res=res+chars[i+1];
             }
            System.out.println(res);

        }


    }
}

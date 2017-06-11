package com.inmotion.chapter1;

import sun.tools.jconsole.Worker;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ラムダ式構文の実装サンプル。
 */
public class LambdaSyntax {

    public String[] before(String[] strings){
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        });
        return strings;
    }

    public String[] after(String[] strings){
        Arrays.sort(strings, (String first, String second) -> Integer.compare(first.length(), second.length()));
        return strings;
    }

    public String[] multipleLines(String[] strings){
        Arrays.sort(strings, (String first, String second) -> {
            if(first.length() < second.length()){
                return -1;
            }else if(first.length() > second.length()){
                return 1;
            }else{
                return 0;
            }
        });
        return strings;
    }

    public void beforeNoneParameter(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println("before:" + i);
                }
            }
        }).start();
    }

    public void afterNoneParameter(){
        new Thread(() -> {
            for (int i= 0; i < 10; i++) { System.out.println("after:" + i); }
        }).start();
    }

}

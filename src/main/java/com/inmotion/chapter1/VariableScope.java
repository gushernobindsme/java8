package com.inmotion.chapter1;

/**
 * 変数スコープに関する実装サンプル。
 */
public class VariableScope {
    public void repeatMessage(String text, int count){
        Runnable r = () -> {
            for(int i = 0; i < count; i++){
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }

    public void callRepeatMessage(){
        repeatMessage("Hello", 1000);
    }
}

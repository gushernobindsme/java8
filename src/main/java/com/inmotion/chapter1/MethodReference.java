package com.inmotion.chapter1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.Comparator;

/**
 * メソッド参照実装サンプル。
 */
public class MethodReference {

    public void before(){
        Button button = new Button();
        button.setOnAction(event -> System.out.print(event));
    }

    public void after(){
        Button button = new Button();
        button.setOnAction(System.out::println);
    }

    public String[] before2(String[] strings){
        Arrays.sort(strings, (first, second) -> first.compareToIgnoreCase(second));
        return strings;
    }

    public String[] after2(String[] strings){
        Arrays.sort(strings, String::compareToIgnoreCase);
        return strings;
    }

}

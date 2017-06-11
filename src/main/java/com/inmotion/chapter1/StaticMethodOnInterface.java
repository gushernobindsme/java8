package com.inmotion.chapter1;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

/**
 * インタフェースでのstaticメソッドの実装サンプル。
 */
public class StaticMethodOnInterface {

    interface Path{
        public static java.nio.file.Path get(String first, String... more){
            return FileSystems.getDefault().getPath(first, more);
        }
    }

    public String[] after(String[] strings){
        Arrays.sort(strings, Comparator.comparing(String::length));
        return strings;
    }

}

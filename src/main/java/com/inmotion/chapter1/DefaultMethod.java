package com.inmotion.chapter1;

/**
 * デフォルトメソッドの実装サンプル。
 */
public class DefaultMethod {
    interface Person {
        long getId();
        default String getName(){
            return "John Q. Public";
        }
    }

    class Student implements Person{
        @Override
        public long getId() {
            return 0;
        }
    }
}

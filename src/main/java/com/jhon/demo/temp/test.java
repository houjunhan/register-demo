package com.jhon.demo.temp;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
       /* LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        list.push("dd");
        String pop = list.pop();
        String poll = list.poll();

        Integer result = "临时字符串".hashCode();
        System.out.println(result);*/


        Integer testInteger = 1;
        integerAddOne(testInteger);
        System.out.println(testInteger);
    }

    public static void integerAddOne(Integer input) {
        input++;
    }
}

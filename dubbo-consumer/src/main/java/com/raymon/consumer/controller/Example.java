package com.raymon.consumer.controller;

public class Example {
    String str = new String("you");
    char[] ch = {'a', 'b', 'c'};

    public void change(String str, char ch[]){
        str = "my";
        ch[0] = 'g';
    }

    public static void main(String[] args){
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + "and");
        System.out.println(ex.ch);
    }
}

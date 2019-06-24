package com.raymon.api.patternsDemo;

/**
 * Author: raymon
 * Date: 2019/6/22
 * Description:单例模式
 */
public class Singleton {

    public static void main(String[] args) {
        SingletonUser sigletonUser = SingletonUser.getUser();

        for(int i = 0; i < 1000; i++){
            SingletonUser u = SingletonUser.getUser();
            if(sigletonUser != u){
                System.out.println("SingletonUser被实例化");
            }
        }
        System.out.println("it is over");
    }
}

/**
 * 饿汉式单例模式
 * 每次调用getuser都会实例化一次singletonuser
 */
class SingletonUser{
    //私有化构造方法
    private SingletonUser(){}

    private static SingletonUser instance = new SingletonUser();

    //每次调用getuser都会实例化一次singletonuser
    public static SingletonUser getUser(){
        return instance;
    }
}

/**
 * 懒汉式单例模式
 * 每次调用getuser2，只有instance为空时才会实例化singletonuser2
 */
class SingletonUser2{
    private SingletonUser2(){}

    private static SingletonUser2 instance;

    public static SingletonUser2 getUser2(){
        if(instance == null){
            instance = new SingletonUser2();
        }

        return instance;
    }
}
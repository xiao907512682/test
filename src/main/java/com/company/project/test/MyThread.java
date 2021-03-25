package com.company.project.test;

import ch.qos.logback.core.util.TimeUtil;
import sun.applet.Main;

/**
 * @author xyq
 * @create 2021-03-23 20:55
 */
public class MyThread {

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("这是单独的线程");
            }
        }
    }


    public static void main(String[] args){
        //调起线程的两种方式
        //new T1().run();//这种方法相当于调用方法，走完此线程再走下面
        new T1().start();//两个线程同时走
        for (int i = 0;i<10;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是main");
        }
    }
}

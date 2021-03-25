package com.company.project.test;

/**
 * 另起线程的三种方式
 * @author xyq
 * @create 2021-03-23 21:07
 */
public class MyThread02 {
    static class Thread01 extends Thread{
        @Override
        public void run() {
            System.out.println("这是第一个线程111111");
        }
    }
    static class Thread02 implements Runnable{
        @Override
        public void run() {
            System.out.println("这是第二个线程22222222");
        }
    }
    public static void main(String[] args){
        new Thread01().start();//调起第一个线程
        new Thread(new Thread02()).start();//调起第二个线程
        new Thread(()->{
            System.out.println("这是第三个线程333333333333");
        }).start();
    }
}

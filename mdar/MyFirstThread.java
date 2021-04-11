package com.mdar;

public class MyFirstThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello Thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // ada 3 Thread. helloThread1, helloThread2 dan main (auto-create)

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());

        MyFirstThread helloThread1 = new MyFirstThread();
        MyFirstThread helloThread2 = new MyFirstThread();
        helloThread1.start();
        helloThread2.start();


    }

}

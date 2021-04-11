package com.mdar;
import java.util.Scanner;

public class MyRunnable implements Runnable{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
            int n1 = sc.nextInt();
        System.out.print("Enter 2nd number: ");
            int n2 = sc.nextInt();

        MyRunnable OddNum = new MyRunnable(1);
        MyRunnable EvenNum = new MyRunnable(0);

        Thread a = new Thread(OddNum, "");
        Thread b = new Thread(EvenNum, "");

        a.start();
        b.start();
    }

    static int n1 = 1;
    static int n2 = 6;
    int r;
    static Object lock = new Object();

    MyRunnable(int r){
        this.r = r;
    }

    @Override
    public void run() {

        while (n1 < n2){
            synchronized (lock){
                while(n1 % 2 != r){
                    try{
                        lock.wait(); }
                    catch (InterruptedException e){
                        e.printStackTrace(); }
                }
                System.out.println(Thread.currentThread().getName() + " " + n1);
                n1++;
                lock.notifyAll();
            }
        }

    }

}

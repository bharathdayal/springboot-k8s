package com.example.demo.threads;

public class ExtendsThread extends Thread{

    @Override
    public void run(){

        for(int i=0;i<=5;i++) {
            System.out.print(Thread.currentThread().getName()+"Count===>"+i);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

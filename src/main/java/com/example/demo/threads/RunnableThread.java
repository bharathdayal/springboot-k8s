package com.example.demo.threads;

public class RunnableThread implements Runnable{

    @Override
    public void run() {

        for(int i=0;i<=5;i++) {
            System.out.println(Thread.currentThread().getName()+"Runnable count===>"+i);
            try{
                Thread.sleep(0);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.demo;

public class MyRunnable implements Runnable{

    static final Object obj1 = new Object();

    Boolean flag = false;

    private int sharedValue=0;

    public void run() {
        for(int i=1;i<=5;i++) {
            System.out.println(Thread.currentThread().getName()+" -ID-"+Thread.currentThread().getId() + " "+i);
        }
    }

    /*public void run() {
        for(int i=1;i<=5;i++) {
            System.out.println(Thread.currentThread().getName()+"Runnable Thread Count "+i +"Shared value "+(++sharedValue));
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void run() {
        for(int i=1;i <=5;i++) {
            synchronized (obj1) {
              while(flag) {
                  try {
                      //Thread.sleep(1000);
                      obj1.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            }
            System.out.println(Thread.currentThread().getName() + "Count " + i);
            flag=true;
            obj1.notify();
        }

    } */


}

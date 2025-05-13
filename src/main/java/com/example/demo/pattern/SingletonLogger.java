package com.example.demo.pattern;

public class SingletonLogger {

    private static volatile SingletonLogger instance = null;

    private SingletonLogger() {

    }

    public static SingletonLogger getInstance() {
         if(instance ==null) {
             synchronized (SingletonLogger.class) {
                 if(instance ==null) {
                     instance=new SingletonLogger();
                 }
             }

         }
         return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public void log2(String message) {
        System.out.println("[LOG2] " + message);
    }
}

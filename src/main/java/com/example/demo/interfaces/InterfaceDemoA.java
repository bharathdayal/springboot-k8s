package com.example.demo.interfaces;

public interface InterfaceDemoA {

    //Abstract method
    // No implementation - cannot have body
    void myAbstractA();
    void myAbstractString(String str);
    void myAbstractParam(String str);

    //Default method
    // With implementation - should have body
    default void myDefaultA() {
        System.out.println("Default method from Interface A - without Overriding in Implementation class");
    }

    //Default method
    // With implementation - should have body
    // Same method name and signature
    default void myDefaultString(String str) {
        System.out.println("Default method from Interface A same signature===>"+str);
    }

    //Static method
    static void myStaticA() {
        System.out.println("Static method from Interface A");
    }

    //Static method
    static  void myStaticString(String str) {
        System.out.println("Static method from Interface A same signature===>"+str);
    }


}

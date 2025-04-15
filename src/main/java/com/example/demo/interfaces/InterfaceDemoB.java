package com.example.demo.interfaces;

public interface InterfaceDemoB {

    //Abstract method
    // No implementation - cannot have body
    void myAbstractB();
    void myAbstractString(String str);
    void myAbstractParam(Integer nums);

    //Default method
    // With implementation - should have body
    default void myDefaultB() {
        System.out.println("Default method from Interface B - without Overriding in Implementation class");
    }

    //Default method
    // With implementation - should have body
    // Same method name and signature
    default void myDefaultString(String str) {
        System.out.println("Default method from Interface B same signature===>"+str);
    }

    //Static method
    static void myStaticB() {
        System.out.println("Static method from Interface B");
    }

    //Static method
    static  void myStaticString(String str) {
        System.out.println("Static method from Interface B same signature===>"+str);
    }

}

package com.example.demo;

import com.example.demo.interfaces.InterfaceDemoA;
import com.example.demo.interfaces.InterfaceDemoB;

public class InterfaceDemo implements InterfaceDemoA, InterfaceDemoB {

    // Clas which implements Interface must either be declared abstract or implement abstract method from InterfaceA
    public void myAbstractA(){
        System.out.println("Abstact method from Interface A");
    }

    // Clas which implements Interface must either be declared abstract or implement abstract method from InterfaceA
    public void myAbstractB(){
        System.out.println("Abstact method from Interface B");
    }

    // Clas which implements Interface must either be declared abstract or implement abstract method from InterfaceA
    // Abstract method with same Signature(parameter)
    public void myAbstractString(String str){
        System.out.println("Abstract method with same Signature(parameter)==>"+str);
    }

    // Clas which implements Interface must either be declared abstract or implement abstract method from InterfaceA
    // Abstract method with same method name with different parameter
    public void myAbstractParam(String str){
        System.out.println("Abstract method with same method name with different parameter(String)==>"+str);
    }

    // Clas which implements Interface must either be declared abstract or implement abstract method from InterfaceA
    // Abstract method with same method name with different parameter
    public void myAbstractParam(Integer n){
        System.out.println("Abstract method with same method name with different parameter(Integer)==>"+n);
    }


    // Default method can be used as it is from interface or override in implementation class
    // Here Overriding in implementation class
    public void myDefaultA(){
        System.out.println("Default method from Interface A override in implementation class");
    }

    // Default method can be used as it is from interface or override in implementation class
    // Here Overriding in implementation class
    public void myDefaultB(){
        System.out.println("Default method from Interface B override in implementation class");
    }

    // Avoid conflicts Diamond problem - Error class inherits unrelated defaults for myDefaultString(String)
    // Since 2 Interfaces has same method + signature
    // Resolve conflicts by Override the method and choose which interfaces using super (multiple interfaces) or Override the method
    public void myDefaultString(String str) {
        //Have own logic here
        System.out.println("Default method Resolving conflicts of Multiple interface===>"+str);
        //Call Interface A
        InterfaceDemoA.super.myDefaultString(str);
        //Call Interface B
        InterfaceDemoB.super.myDefaultString(str);
    }


}

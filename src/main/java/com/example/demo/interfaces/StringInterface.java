package com.example.demo.interfaces;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface StringInterface {

    //Count the number of characters in given string

    default void countString(String input)  {

        HashMap<Character,Integer> hashmap = new HashMap<>();

        for(char ch:input.toCharArray()) {
            hashmap.put(ch,hashmap.getOrDefault(ch,0)+1);
        }
        //Append in new String
        StringBuilder stringBuilder = new StringBuilder();
        for(char ch:hashmap.keySet()) {
            stringBuilder.append(ch).append(hashmap.get(ch));
        }
        System.out.println(stringBuilder);

    }

    // Reverse String using String builder
    default void reverseString(String input) {

        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    // Reverse String using for loop
    default void reverseStringloop(String input) {

        String reverse ="";

        for(int i=input.length()-1;i>=0;i--) {
            reverse+= input.charAt(i);
        }
        System.out.println(reverse);
    }

    //Non-Repeated char in String
    static int nonRepeatedString(String input) {

        HashMap<Character,Integer> hashMap = new HashMap<>();

        for(char ch:input.toCharArray()) {
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }

        for(int i=0;i< input.length();i++) {
            if(hashMap.get(input.charAt(i))==1) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    //Repeated String
    static Serializable repeatedString(String input) {
        Set<Character> hashset=new HashSet<>();

        for(char ch:input.toCharArray()) {
            if(hashset.contains(ch)) {
                System.out.println(ch);
                return ch;
            }
            hashset.add(ch);
        }

       return "";
    }

    default void replaceString(String input, Map<String,String> replace) {

        for(Map.Entry<String,String> entry:replace.entrySet()) {
            input=input.replace(entry.getKey(),entry.getValue());
        }
        System.out.println(input);


    }
}

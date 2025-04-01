package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamDemo {



     static void streamArray() {
         System.out.println("Creating stream from Array");
         String[] arr = {"Stream 1","Stream 2","Stream 3"};

         Arrays.stream(arr).forEach(System.out::println);

         //Stream<String> stream = Arrays.stream(arr);
        // stream.forEach(System.out::println);

    }

    static void StreamFromCollections() {
         System.out.println("Creating stream from Collection");
         Set<String> setStream = new HashSet<>();
         setStream.add("ML");
         setStream.add("AI");
         setStream.add("PYTHON");
         setStream.add("JAVA");

        setStream.stream().filter(a->a.contains("JAVA")).forEach(System.out::println);

    }
}

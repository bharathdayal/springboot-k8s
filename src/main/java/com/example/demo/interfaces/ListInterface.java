package com.example.demo.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListInterface {

    public List<String> insertArrayList() {

        List<String> arraylist = new ArrayList<>();
        arraylist.add("User1");
        arraylist.add("User2");
        arraylist.add("User3");
        arraylist.add("User2");

        long startTime = System.nanoTime();
        arraylist.add(2, "User-3");
        long endTime = System.nanoTime();
        System.out.println("ArrayList insertion time: " + (endTime - startTime));

        return  arraylist;

    }

    public List<String> insertLinkedList() {
        List<String> linkedlist = new LinkedList<>();
        linkedlist.add("User1");
        linkedlist.add("User2");
        linkedlist.add("User3");
        linkedlist.add("User2");

        long startTime = System.nanoTime();
        linkedlist.add(2, "User-3");
        long endTime = System.nanoTime();
        System.out.println("LinkedList insertion time: " + (endTime - startTime));

        return  linkedlist;

    }

    public List<String> lambda() {
        List<String> list = Arrays.asList("test1","test2","test3","test4");
        list.forEach(name->System.out.println(name));
        return list;
    }

    public List<String> stream() {
        List<String> list =Arrays.asList("test1","test2","test3","test4");
        list.stream().filter(list1->list1.contains("test2")).collect(Collectors.toList());
        return list;
    }
}

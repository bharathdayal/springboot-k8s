package com.example.demo.interfaces;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInterface {

    public Map<Integer,String> insertHashMap() {

        Map<Integer,String> hashmap = new HashMap<>();
        hashmap.put(5,"User5");
        hashmap.put(2,"User2");
        hashmap.put(1,"User1");
        hashmap.put(3,"User3");
        hashmap.put(3,"User4");
        return hashmap;
    }

    public Map<Integer,String>   removeHashMap() {
        Map<Integer,String> hashmap = new HashMap<>();
        hashmap.put(1,"User1");
        hashmap.put(2,"User2");
        hashmap.put(3,"User3");
        String remove = String.valueOf(hashmap.remove(2));
        return hashmap;

    }

    public Map<Integer,String> insertLinkedHashMap() {
        Map<Integer,String> linkedhashmap = new LinkedHashMap<>();
        linkedhashmap.put(2,"User2");
        linkedhashmap.put(1,"User1");
        linkedhashmap.put(4,"User4");
        linkedhashmap.put(3,"User3");
        linkedhashmap.put(5,"User3");
        return linkedhashmap;
    }

    public Map<Integer,String> insertTreeMap() {
        Map<Integer,String> treemap = new TreeMap<>();
        treemap.put(2,"User2");
        treemap.put(1,"User1");
        treemap.put(4,"User4");
        treemap.put(3,"User3");
        treemap.put(5,"User3");

        return treemap;

    }
}

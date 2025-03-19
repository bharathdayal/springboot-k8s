package com.example.demo.interfaces;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

    public Set<String> insertHashSet() {

        Set<String> hashset = new HashSet<>();
        hashset.add("User1");
        hashset.add("User2");
        hashset.add("User3");
        hashset.add("User2");
        hashset.add(null);
        return hashset;
    }

    public Set<String> insertLinkedHashSet() {

        Set<String> linkedHashSethashset = new LinkedHashSet<>();
        linkedHashSethashset.add("User1");
        linkedHashSethashset.add("User2");
        linkedHashSethashset.add("User3");
        linkedHashSethashset.add("User2");
        linkedHashSethashset.add(null);
        return linkedHashSethashset;
    }

    public Set<String> insertTreeSet() {

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("User1");
        treeSet.add("User2");
        treeSet.add("User4");
        treeSet.add("User3");
        treeSet.add("User2");
        treeSet.add("");
        return treeSet;
    }

}

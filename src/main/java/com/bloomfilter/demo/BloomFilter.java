package com.bloomfilter.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BloomFilter {

    private int CAPACITY;
    private final Set<String> bloomSet;
    private boolean[] checkFlag;

    public BloomFilter(int capacity){
        bloomSet = new HashSet<>(capacity);
        checkFlag = new boolean[capacity];
        CAPACITY = capacity;
    }

    private boolean add(String elem){
        if(bloomSet.size() == CAPACITY) return false;
        bloomSet.add(elem);

        UUID uuid = UUID.randomUUID();
        int count = 0,pos = 1;
        for(char ch: uuid.toString().toCharArray()){
            if(ch == '-') continue;
            int val = ch - '0';

            count += (val * (pos++));
        }

        checkFlag[count % CAPACITY] = true;
        return true;
    }

    private boolean isMember(String elem){
        return true;
    }

}

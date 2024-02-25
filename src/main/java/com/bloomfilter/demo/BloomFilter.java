package com.bloomfilter.demo;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class BloomFilter {

    private final int CAPACITY;

    private final int MOD = 1000007;

    private int COUNT = 0; //number of places set to true in bloom filter list
    private boolean[] bloomFilterList;

    public BloomFilter(int capacity){
        bloomFilterList = new boolean[capacity];
        CAPACITY = capacity;
    }

    public boolean add(String elem){
        if(COUNT == CAPACITY) return false;

        int hashValue1 = getHashValue1(elem);
        int hashValue2 = getHashValue2(elem);

        setValueInBloomFilter(hashValue1);
        setValueInBloomFilter(hashValue2);
        return true;
    }

    private void setValueInBloomFilter(int hashValue){
        if(!bloomFilterList[hashValue % CAPACITY]){
            bloomFilterList[hashValue % CAPACITY]= true;
            COUNT++;
        }
    }

    private int getHashValue1(String elem) {
        int pos=0,hashValue=0;
        for(char ch:elem.toCharArray()){
            int val = ch-'0';
            hashValue += val*(pos+1);
            pos++;
        }
        return hashValue;
    }

    private int getHashValue2(String elem) {
        int pos=0,hashValue=0;
        for(char ch:elem.toCharArray()){
            int val = ch-'0';
            hashValue =  (((hashValue + val)%MOD)*(pos+1))%MOD;
            pos++;
        }
        return hashValue;
    }

    public boolean isAMember(String elem){
        int hashValue1 = getHashValue1(elem);
        int hashValue2 = getHashValue2(elem);
        return bloomFilterList[hashValue1 % CAPACITY] && bloomFilterList[hashValue2 % CAPACITY];
    }

    public String displayBloomFilter(){
        StringBuilder bloomFilterOutput = new StringBuilder();

        for(boolean flg:bloomFilterList){
            if(flg)
                bloomFilterOutput.append("1 ");
            else
                bloomFilterOutput.append("0 ");
        }
        return bloomFilterOutput.toString();
    }

}

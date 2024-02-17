package com.basic.learning.programs;

import java.util.HashMap;

public class DuplicateInArray {
    public static void main(String[] args) {
        //Slower way
        int arr[]= {2,1,2,4,1,2,9,6,9};
        int freq[]=new int[arr.length];
        int visited=-1;
        for(int i=0;i<arr.length;i++) {
            if (freq[i]!=visited){
                int count=1;
                for(int j=i+1;j< arr.length;j++) {
                    if (arr[i] == arr[j]) {
                        freq[j] = visited;
                        count++;
                    }
                }
                freq[i]=count;
            }
        }
        for(int i=0;i< freq.length;i++){
            if(freq[i]!=visited){
                System.out.println("Dup count for: "+arr[i]+" = "+freq[i]);
            }
        }


        //Faster Way
//        int arr[]= {2,1,2,4,1,2,9,6,9};
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i:arr){
//            if(map.containsKey(i)){
//               map.put(i,map.get(i)+1);
//            } else {
//                map.put(i,1);
//            }
//        }
//        for(int i:map.keySet()){
//            System.out.println(i+" "+map.get(i));
//        }



    }
}

package com.basic.learning.programs;

import jakarta.persistence.SecondaryTable;

import java.util.*;

public class CommonProg {
    public static void main(String[] args) {

        //Program---Find all the substring with a word---
        //How to find longest palindrome in a string.

/*
        //print the elements of an array present on even position
        int[] arr={1,2,3,4,5,6,7,8};
        for(int i=1;i<arr.length;i++){
                if(i % 2 == 1){
                System.out.println(arr[i]);
            }
        }

        //left rotate the elements of an array
        int[] arr={1,2,3,4,5,6,7,8};
        int n=5;
        int len=arr.length;
        for(int i=0;i<n;i++){
            int j,temp;
            temp=arr[0];
            for(j=0;j<len-1;j++){
                arr[j]=arr[j+1];
            }
                arr[j]=temp;
            }
        for(int i:arr){
            System.out.print(i);
        }
        //Right rotate the elements of an array
        int[] arr={1,2,3,4,5};
        int n=2;
        int len=arr.length;
        for(int i=0;i<n;i++){
            int j,temp;
            temp=arr[len-1];
            for(j=len-1;j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }
        for(int i:arr){
            System.out.print(i);
        }

        //find the frequency of each element in the array
        int[] arr={1,2,3,4,2,5,3};
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            } else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        System.out.println(map);

        //print all the vowels from a string
        String name="Ranjana Gupta";String finalName="";
        Character[] nameChar={'a','e','i','o','u'};
        char[] ch=name.toCharArray();
        Set<Character> set= new HashSet<>(Arrays.asList(nameChar));
        for(char c:ch){
            if(set.contains(c)){
                finalName=finalName+c;
            }
        }
        System.out.println(finalName);

        //Sort array
        int arr[]={2,5,8,0,1,4};
        int temp;
        for(int i=0;i<arr.length-1;i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    i=-1;
                }
        }
        for(int i:arr)
        System.out.print(i+" ");

       //Max/Min and 2nd max no in an array program
        int arr[]=new int[5];
        Scanner obj= new Scanner(System.in);

        System.out.println("Enter 5 nos \n");
        for(int i=0;i<5;i++) {
            arr[i] = obj.nextInt();
        }
        int max1=arr[0];
        int max2nd=arr[0];
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max1){
                max2nd=max1;
                max1=arr[i];
            } else if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println(max1+" "+max2nd+" "+min);

        //Count the occurences in array
        int arr[]={2,4,5,2,3,4};
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else{
                map.put(i,1);
            }
        }
        System.out.println(map);

        //String Reverse
        String word = "ROME";String copy="";
        int len=word.length();
        for(int i=len-1;i>=0;i--){
            copy=copy+word.charAt(i);
        }
        System.out.println(copy);

        //Program----------Shift Array from any index--------------
        int arr[]={1,2,3,4,5};
        int newArr[]= new int[arr.length];
        int n=2;
        for(int i=0;i< newArr.length;i++){
            newArr[i]=i+4> arr.length-1?arr[i+4-arr.length]:arr[i+4]; //if(i+4> arr.length-1){arr[i+4-arr.length]}{else{arr[i+4]}
        }
        for(int j:newArr){
            System.out.print(j+" ");
        }

        //Find each Character count in a string
        String word="Ranjana";
        HashMap<Character,Integer> map = new HashMap();
        for(int i =0;i<word.length();i++){
            if(map.containsKey(word.charAt(i))){
                int count= map.get(word.charAt(i));
                map.put(word.charAt(i),++count);
            } else {
                map.put(word.charAt(i),1);
            }
        }
        System.out.println(map);


        //Program---Armstrong No-----------
        int originalNum=153;
        int no=153;
        double cal=0;
        int count=String.valueOf(no).length();
        while(no!=0){
            cal  += Math.pow(no%10,count);
            no=no/10;
        }
        System.out.println((int)cal);
        if((int)cal==originalNum){
            System.out.println(" no is armstrong");
        } else {
            System.out.println(" no is not armstrong");
        }


        //Program------count distinct vowels from string-------
        String str="Hello I am Rohan";
        char ch[]= str.toCharArray();
        HashSet<Character> set=new HashSet<>();
        for(Character c:ch){
            if(c == 'a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='I'){
                set.add(c);
            }
        }
        System.out.println(set);
        System.out.println(set.size());



          //Program----count the char excluding special chars from string---------
        String example = "hI there *isIt(@ Mar$ch]";
        String filter="";
        for(int i=0;i<example.length();i++){
                if((example.charAt(i)>64 && example.charAt(i)<=90) || (example.charAt(i)>96 && example.charAt(i)<=122)){
                filter=filter+example.charAt(i);
            }
        }
        System.out.println(filter);

        //Program-------Remove vowels from string
        String str="Hello I am Rohan";
          a)Easy way
        String filter="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!= 'a'&&
                    str.charAt(i)!= 'e'&&
                    str.charAt(i)!= 'i'&&
                    str.charAt(i)!= 'o'&&
                    str.charAt(i)!= 'u') {
                filter=filter+str.charAt(i);
            }
        }
        System.out.println(filter);
        //b)Using Set
        char strToChar[] = str.toCharArray();
        Character[] ch={'a','e','i','o','u','A','I'};
        Set<Character> set = new HashSet(Arrays.asList(ch));
        String filteredStr="";
        for(char c:strToChar){
            if(!set.contains(c)){
                System.out.println(c+" ");
                filteredStr=filteredStr+c;
            }
        }
        System.out.println(filteredStr);




        //Program---------Split all the words and store in array----------
        String sentence = "My name/is 12Ranjana12/gupta";
        sentence=sentence.replaceAll("/"," ");
        System.out.println(sentence);
        sentence=sentence.replaceAll("12","");
        System.out.println(sentence);
        String[] arr=sentence.split("\\s",5);
        for(String str:arr){
            System.out.println(str);
        }


        //Program--------cartesian product of 2 arrays----
        int arr1[]={1,1};
        int arr2[]={2,3,4};
        int[] result=new int[6];
        //1) print the value after multiplication

        for(int i=0;i<arr1.length;i++){
            for(int j=0;j< arr2.length;j++){
                result[i* arr2.length+j]= arr1[i]*arr2[j];
            }
        }
        for(int i:result){
        System.out.print(i);}
        //2)print only the combinations
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j< arr2.length;j++){
                System.out.println("{"+arr1[i]+"*"+arr2[j]+"}");
            }
        }

*/

    }
}

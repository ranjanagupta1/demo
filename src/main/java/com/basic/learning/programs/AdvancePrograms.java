package com.basic.learning.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class AdvancePrograms {
    public static String calculate(String one,String two){

        int n=Math.min(one.length(),two.length());
        for(int i=0;i<n;i++){
            if(one.charAt(i)!=two.charAt(i)){
                return one.substring(0,i);
            }
        }
        return one.substring(0,n);
    }
    public static void main(String[] args) throws IOException {





//        Properties obj= new Properties();
//        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+
//                File.separator+"resources"+File.separator+"PropertyFiles"+File.separator+"config.properties";
//        obj.load(new FileInputStream(new File(path)));
//        System.out.println(obj.getProperty("customerUrl"));

//----------------------------------------------------check if all the braces are closed-----------------------------------------

        String braces1="(12{abs[+45%3sb((-90+34df}+800-23])80d)";
        String braces2="]";//"[{(55+12)}]11{55}55";//"[{()}]]";
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Set<Character> set=new HashSet<>();
        set.addAll(map.keySet());
        set.addAll(map.values());
        Stack<Character> stk=new Stack<>();
        for(Character e:braces2.toCharArray()){
            //check whether its a brace or not
            if(set.contains(e)){
                //if its open brace, add a respective closed brace to the stack
                if(map.containsKey(e)){
                    stk.add(map.get(e));
                } else {
                    //else, if it is closed brace, check whether u have the similar brace in the top of stack
                    if(!stk.isEmpty() && stk.peek()==e){
                       stk.pop();
                    }
                    else {
                        //if it is similar, pop the top element, otherwise return invalid brace
                        System.out.println("invalid brace");
                        stk.clear();
                        return;
                    }
                }
            }
        }
        //if all the elements in stack gets poped then the braces are closed
        if(stk.empty()){
            System.out.println("valid brace");
        } else {
            System.out.println("invalid brace");
        }




//----------------------------------------------------find the longest repeating sequence in a string-----------------------------------------
/*
        String original="adbcfdbcyoupqklyoupqlwst";
        String result="";
        int len=original.length();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                String response = calculate(original.substring(i,len),original.substring(j,len));
                if(response.length()>result.length()){
                    result=response;
                }
            }
        }
        System.out.println(result);

//-------------------------------------------------------------------find the longest same repeating character---------------------------------------------------
        String str="abdcffmnnnotr";
        String result="";
        int n=str.length();
        String response="";

        for(int i=0;i<n;i++) {
            result = "";

            while (i<n-1 && str.charAt(i) == str.charAt(i + 1)) {
                result = result.concat(String.valueOf(str.charAt(i)));
                i++;
            }
            result = result.concat(String.valueOf(str.charAt(i)));
            if(result.length()>response.length()){
                response=result;
            }
        }
        System.out.println(response);
*/




    }
}

package com.basic.learning.programs;

import java.util.Scanner;

public class IncrementalPattern {

    public static void main(String[] args) {
        /*
        * print the following
        *
        *       .
        *       . .
        *       . . .
        *       . . . .
        *       . . . . .
        *       . . . . . .
        *
        *       No of lines should be taken as input from the user
        * */

        Scanner input= new Scanner(System.in);
        System.out.println("Please give no of lines to print star");
        int count=input.nextInt();

        for(int x=0;x<count;x++){
            for(int y=0;y<x+1;y++){
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}

package com.basic.learning.programs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OddEvenNumber {
    public static void main(String[] args) {
        //take input from user for a number and display whether it's even or odd
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the no : ");
        int num=0;
        try{
            num = input.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Number is not valid");
            System.exit(0);
        }

        OddEvenNumber obj = new OddEvenNumber();
        System.out.println(obj.isEven(num) ? "Number is even" : "Number is odd");
    }

    private boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}

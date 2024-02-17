package com.basic.learning.programs;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class MaxContigeousSum {
    public static void main(String[] args) {
        /*
        *
        * find the maximum sum in an array in O(N) complexity i.e can traverse the array only once
        * take input from user with unlimited number of list numbers
        * and find the max sum of contigeous sub array in a single iteration of the array
        * KADANE's Theorem- does this prog in O(n) i.e single traversal only where the max sum will be 0 in case only -ves are there.
        * It creates contigeous subarrays where if current element is bigger than the previous sum then it starts new sub array and if the current subarray sum is greater than the overall subarray sum then max val gets assigned to overall sum.
        * */

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the total count of no");
        int noInArray = input.nextInt();
        System.out.println("Enter the numbers");
        int arr[]= new int[noInArray];
        for(int x=0;x<noInArray;x++){
            arr[x]=input.nextInt();
            System.out.print(" ");
        }
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        System.out.println("Maximum sum is " + maxSum(arr));
    }
    private static int maxSum(int[] arr1){
        int currentSum=0;  //as per algo
        int maxSum=0;
        for(int x=0;x<arr1.length;x++){
               currentSum = max(currentSum + arr1[x] , arr1[x]); //as per algo,line 35 & 36
                maxSum = max(currentSum , maxSum);
            }
        return maxSum;
    }

}

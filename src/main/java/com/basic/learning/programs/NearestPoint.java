package com.basic.learning.programs;

import java.util.Scanner;

public class NearestPoint {
    /*
    *
    * given an array of points with Array[n][2]
    * Every index contains 2 numbers which represent a point with x and y
    * find the nearest point from (0,0)
    * */

    public static void main(String[] args) {
        int [][] arr = new int[10][2];

        Scanner s = new Scanner(System.in);
        for(int i=0 ; i < arr.length; i++){
            System.out.println();
            arr[i][0] = s.nextInt();
            System.out.print("  ");
            arr[i][1] = s.nextInt();
        }

        //find nearest point from (0,0)



    }


}

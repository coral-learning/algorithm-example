package com.coral.learning.alg.udemo.leetcode.utils;

public class PrintTool {

    public static void printArray(int[] array){
        if (array == null || array.length < 1){
            System.out.println("[]");
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length -1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }


}

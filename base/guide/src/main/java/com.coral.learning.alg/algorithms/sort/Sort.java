package com.coral.learning.alg.algorithms.sort;

public interface Sort<T> {

    default  boolean isLog(){
        return true;
    }
    void sort(T[] numbers);

    /**
     * 打印数组
     *
     * @param a
     */
    default void print(T[] a) {
        for (T i : a) {
            System.out.println(i + " ");
        }
    }

    /**
     * 打印数组
     *
     * @param a
     */
    default void printLast(T[] a, int num) {
        for (int i = a.length - 1;i >= a.length - num;i--) {
            System.out.println(a[i] + " ");
        }
    }


    /**
     * 交换 a b 索引值
     *
     * @param numbers
     * @param a
     * @param b
     */
    default void swap(T[] numbers, int a, int b) {

        if (numbers[a].equals(numbers[b])) {
            return;
        }
        T tmp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = tmp;
    }
}

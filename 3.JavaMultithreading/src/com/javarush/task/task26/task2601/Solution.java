package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        /*Integer[] arr = {2,3,5,7};
        double med = findMediane(arr);
        System.out.println(med);
        Integer[] arr2=sort(arr);*/
        /*for (Integer integer : arr2) {
            System.out.println(integer);
        }*/

    }
    public static double findMediane(Integer[] array){
        double mediane;
        Arrays.sort(array);
        if(array.length%2==1){
            mediane=array[array.length/2];
        }else{
            mediane=(double)(array[array.length/2]+array[array.length/2-1])/2;
        }
        return mediane;
    }


    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double mediane = findMediane(array);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return(int)(Math.abs(o1-mediane)-Math.abs(o2-mediane));
            }
        };
        Arrays.sort(array,comparator);
        return array;
    }
}

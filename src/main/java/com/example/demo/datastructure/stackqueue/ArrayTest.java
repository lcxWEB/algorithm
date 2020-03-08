package com.example.demo.datastructure.stackqueue;

/**
 * Created by lcx on 2018/10/7.
 */
public class ArrayTest {

    public static void main(String[] args){
        Integer[] scores = new Integer[]{100, 98, 89, 1, 70};
//        for (int score:scores) {
//            System.out.println(score);
//        }

        Array array = new Array(scores);
        Array<Integer> array1 = new Array<>();
        for (int i = 0; i < 4; i++){
            array1.addLast(i);
        }
        System.out.println(array1.getSize());
        System.out.println(array1.toString());
        array1.remove(2);
        System.out.println(array1.toString());

        array.remove(2);
        System.out.println(array);

        array.removeElement(100);
        System.out.println(array);


    }

}

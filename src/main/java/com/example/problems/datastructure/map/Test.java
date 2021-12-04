package com.example.problems.datastructure.map;

import java.util.ArrayList;

/**
 * @Author: lcx
 * @Date: 2019/1/28 13:30
 * @Description:
 */

public class Test {

    private static double testMap(Map<String, Integer> map, String fileName) {
        long startTime = System.nanoTime();

        System.out.println(fileName);

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile(fileName, words1)) {
            System.out.println("Total words: " + words1.size());
            for (String word : words1) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());

            System.out.println(map.get("pride"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String fileName = "D:\\springbootproject\\src\\main\\java\\com\\star\\datastructure\\map\\pride-and-prejudice.txt";

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();

        double time1 = testMap(linkedListMap, fileName);

        System.out.println("linkedListMap : " + time1 + " s");

        BSTMap<String, Integer> bstMap = new BSTMap<>();

        double time2 = testMap(bstMap, fileName);

        System.out.println("bstMap : " + time2 + " s");
    }
}

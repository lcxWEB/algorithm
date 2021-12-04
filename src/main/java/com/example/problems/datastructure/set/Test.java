package com.example.problems.datastructure.set;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @Author: lcx
 * @Date: 2019/1/24 10:41
 * @Description:
 */

public class Test {


    private static double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();

        System.out.println(fileName);

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile(fileName, words1)) {
            System.out.println("Total words: " + words1.size());
            for (String word : words1)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {

        String fileName = "D:\\springbootproject\\src\\main\\java\\com\\star\\datastructure\\set\\pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();

        double time1 = testSet(bstSet, fileName);

        System.out.println("BST Set : " + time1 + " s");

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();

        double time2 = testSet(linkedListSet, fileName);

        System.out.println("LinkedListSet : " + time2 + " s");


        // System.out.println("Pride and Prejudice");
        // ArrayList<String> words1 = new ArrayList<>();
        // if(FileOperation.readFile("D:\\springbootproject\\src\\main\\java\\com\\star\\datastructure\\set\\pride-and-prejudice.txt", words1)) {
        //     System.out.println("Total words: " + words1.size());
        //
        //     // BSTSet<String> set1 = new BSTSet<>();
        //     LinkedListSet<String> set1 = new LinkedListSet<>();
        //     for (String word : words1)
        //         set1.add(word);
        //     System.out.println("Total different words: " + set1.getSize());
        // }
        //
        // System.out.println();
        //
        //
        // System.out.println("A Tale of Two Cities");
        //
        // ArrayList<String> words2 = new ArrayList<>();
        // if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
        //     System.out.println("Total words: " + words2.size());
        //
        //     BSTSet<String> set2 = new BSTSet<>();
        //     for(String word: words2)
        //         set2.add(word);
        //     System.out.println("Total different words: " + set2.getSize());
        // }

        System.out.println(UUID.randomUUID().toString().replace("-","").toUpperCase());
    }

}

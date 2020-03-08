package com.example.demo.assistant;

import java.util.Random;

/**
 * Created by lichunxia on 2020-02-06 20:00
 */
public class RandomUtil {

    public static int[] randomArray(int size, int uplimit) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(uplimit);
        }
        return array;
    }
}

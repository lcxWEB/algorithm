package com.example.problems.nowcoder.offer;

import java.util.Arrays;

/**
 * Created by lichunxia on 2020-02-02 18:13
 */
public class IsContinuous {

    public static void main(String[] args) {
        boolean continuous = new IsContinuous().isContinuous(new int[]{1, 2, 3});
        System.out.println(continuous);
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);

        int numberOfZero = 0;
        int numberOfGap = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numberOfZero++;
            }
        }

        for (int i = numberOfZero; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            numberOfGap = numberOfGap + numbers[i + 1] - numbers[i] - 1;
        }

        return numberOfGap > numberOfZero ? false : true;

    }

    public boolean isContinuous1(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        int[] arr = new int[14];
        int max = -1;
        int min = 14;

        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (arr[numbers[i]] > 1) {
                return false;
            }

            if (numbers[i] < min) {
                min = numbers[i];
            } else if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        if (max - min < 5) {
            return true;
        }

        return false;

    }
}

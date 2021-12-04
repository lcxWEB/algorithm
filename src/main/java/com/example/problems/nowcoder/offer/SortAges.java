package com.example.problems.nowcoder.offer;

import com.example.problems.assistant.RandomUtil;

import java.util.Arrays;

/**
 * Created by lichunxia on 2020-02-06 19:58
 */
public class SortAges {

    public static void main(String[] args) {
        int[] ages = RandomUtil.randomArray(10, 100);
        System.out.println(Arrays.toString(ages));
        new SortAges().sortAges(ages);
        System.out.println(Arrays.toString(ages));
    }

    /**
     * O(n), O(1)
     *
     * @param ages
     */
    private void sortAges(int[] ages) {
        if (ages == null || ages.length == 0) {
            return;
        }
        int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];
        for (int i = 0; i < ages.length; i++) {
            timesOfAge[ages[i]]++;
        }

        int index = 0;
        for (int i = 0; i <= oldestAge; i++) {
            // 某个年龄出现了几次，就在数组ages里设置几次该年龄，这就相当于给ages数组排序了
            // 用长度为100的整型数组作为辅助空间换来了O(n)的时间效率
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }
}

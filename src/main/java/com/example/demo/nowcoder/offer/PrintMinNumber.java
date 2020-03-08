package com.example.demo.nowcoder.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lichunxia on 2020-01-28 11:16
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        String s = new PrintMinNumber().PrintMinNumber(new int[]{3, 321, 34});
        System.out.println(s);
    }

    /**
     * 2.12
     * 关键是找出一个排序方法
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber212(int[] numbers) {
        String result = "";
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            nums.add(numbers[i]);
        }
        // 关键点
        Collections.sort(nums, (o1, o2) -> (o1 + "" + o2).compareTo(o2 + "" + o1));
        for (int i = 0; i < nums.size(); i++) {
            result = result + nums.get(i);
        }
        return result;
    }


    public String PrintMinNumber(int[] numbers) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, (o1, o2) -> {
            String str1 = o1 + "" + o2;
            String str2 = o2 + "" + o1;
            return str1.compareTo(str2);
        });

        String result = "";
        for (Integer num : list) {
            result = result + num;
        }
        return result;
    }
}

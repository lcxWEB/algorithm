package com.example.problems.datastructure.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: lcx
 * @Date: 2019/1/5 17:00
 * @Description:
 */

public class Main {

    private static Integer android = 1;

    private static String source = "1";

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i-1) > nums.get(i))
                throw new IllegalArgumentException("Error");
        }

        System.out.println("removeMin test completed");

        System.out.println('a' - 0);

        System.out.println('b');


        // int[] nums = {5, 3, 6, 8, 4, 2};
        //
        // for (int num : nums) {
        //     bst.add(num);
        // }
        //
        // bst.preOrder();
        // System.out.println();
        // System.out.println(bst);
        //
        // bst.preOrderNR();
        // System.out.println();
        //
        // bst.levelOrder();
        // System.out.println();
        //
        // bst.inOrder();
        // System.out.println("-------");
        // bst.postOrder();
        //
        // System.out.println(android.toString().equals(source));
        //
        // Map<String, String> info = new HashMap<>();
        // info.put("11ha", "00000");
        // info.put("yb", "00000");
        // info.put("cc", "00000");
        // System.out.println(info);
        // System.out.println(info.entrySet());
        // List<Map.Entry<String, String>> infoIds = new ArrayList<>(info.entrySet());
        // String ret = "";
        // for (Map.Entry<String, String> entry : infoIds) {
        //     // System.out.println( "key = " + entry.getKey() + "===" + "value = " + entry.getValue());
        //     ret += entry.getKey();
        //     ret += "=";
        //     ret += entry.getValue();
        //     ret += "&";
        // }
        // System.out.println(ret);
        //
        // Collections.sort(infoIds, (arg0, arg1) -> {
        //     return (arg0.getKey()).compareTo(arg1.getKey());
        // });
        // ret = "";
        // for (Map.Entry<String, String> entry : infoIds) {
        //     // System.out.println( "key = " + entry.getKey() + "===" + "value = " + entry.getValue());
        //     ret += entry.getKey();
        //     ret += "=";
        //     ret += entry.getValue();
        //     ret += "&";
        // }
        // System.out.println(ret);
    }
}

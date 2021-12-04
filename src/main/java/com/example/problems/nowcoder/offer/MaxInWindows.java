package com.example.problems.nowcoder.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by lichunxia on 2020-02-01 17:49
 */
public class MaxInWindows {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> arrayList = new MaxInWindows().maxInWindows(array, 1);
        System.out.println(arrayList);
    }

    /**
     * 2.13
     * 双端队列
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindowsDeque(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1 || size > num.length) {
            return result;
        }
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            //从后面依次弹出队列中比当前num值小的元素，同时也能保证队列首元素为当前窗口最大值下标
            while (!que.isEmpty() && num[que.peekLast()] <= num[i]) {
                que.pollLast();
            }
            //当当前窗口移出队首元素所在的位置，即队首元素坐标对应的num不在窗口中，需要弹出
            if (!que.isEmpty() && (i - que.peekFirst() + 1) > size) {
                que.pollFirst();
            }
            //把每次滑动的num下标加入队列
            que.addLast(i);
            //当滑动窗口首地址i大于等于size时才开始写入窗口最大值
            if (i >= size - 1) {
                result.add(num[que.peekFirst()]);
            }
        }
        return result;
    }

    /**
     * 2.13
     * O(n * size)
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows213(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
            return result;
        }
        int winBegin = 0;
        int winEnd = size - 1;
        while (winEnd < num.length) {
            int maxIdx = winBegin;
            for (int i = winBegin + 1; i <= winEnd; i++) {
                if (num[i] > num[maxIdx]) {
                    maxIdx = i;
                }
            }
            result.add(num[maxIdx]);
            winBegin++;
            winEnd++;
        }
        return result;
    }


    /**
     * O(n)
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1 || size > num.length) {
            return result;
        }
        LinkedList<Integer> maxIndexDequeue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (maxIndexDequeue.isEmpty()) {
                maxIndexDequeue.addLast(i);
            } else {
                // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
                if (maxIndexDequeue.peekFirst() <= i - size) {
                    maxIndexDequeue.pollFirst();
                }
                // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
                while (!maxIndexDequeue.isEmpty() && num[i] > num[maxIndexDequeue.peekLast()]) {
                    maxIndexDequeue.pollLast();
                }
                // 加入新数
                maxIndexDequeue.addLast(i);
            }
            // 队列头部就是该窗口内第一大的
            if (i + 1 >= size) {
                result.add(num[maxIndexDequeue.peekFirst()]);
            }
        }
        return result;
    }


}

package com.example.demo.nowcoder.offer;


import java.util.LinkedList;

/**
 * Created by lichunxia on 2020-02-02 18:34
 */
public class LastRemainingSolution {

    public static void main(String[] args) {
        int remain = new LastRemainingSolution().LastRemaining2(6, 7);
        System.out.println(remain);

        System.out.println((-3) % 4);
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }


    public int LastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int[] arr = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {
            i++;
            if (i >= n) i = 0;
            if (arr[i] == -1) continue;
            step++;
            if (step == m) {
                arr[i] = -1;
                count--;
                step = 0;
            }
        }
        return i;
    }

    public int LastRemaining1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public int LastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }
        return (LastRemaining2(n - 1, m) + m) % n;
    }


}

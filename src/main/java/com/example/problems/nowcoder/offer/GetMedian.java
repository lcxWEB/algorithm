package com.example.problems.nowcoder.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lichunxia on 2020-02-01 16:31
 */
public class GetMedian {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int count = 0;

    public void Insert(Integer num) {
        count++;
        if (count % 2 == 0) {
            // 总数为偶数个时加入小顶堆
            // 将新数字与大顶堆的最大数字比较，如果小，则将大顶堆的最大数字放入小顶堆，再将新数字放入大顶堆；
            // 如果大，则直接放入小顶堆

            // 简洁写法
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);

            // if (maxHeap.size() > 0) {
            //     int peek = maxHeap.peek();
            //     if (num < peek) {
            //         minHeap.add(peek);
            //         maxHeap.poll();
            //         maxHeap.add(num);
            //     } else {
            //         minHeap.add(num);
            //     }
            // } else {
            //     minHeap.add(num);
            // }
        } else {
            // 总数为奇数个时加入大顶堆。保证大顶堆的所有数字小于小顶堆的所有数字
            // 将新数字与小顶堆的最小数字比较，如果小，则直接放入大顶堆；
            // 如果大，则把小顶堆的最小数字放入大顶堆，再将新数字放入小顶堆

            // 简洁写法
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);

            // if (minHeap.size() > 0) {
            //     int peek = minHeap.peek();
            //     if (num > peek) {
            //         maxHeap.add(peek);
            //         minHeap.poll();
            //         minHeap.add(num);
            //     } else {
            //         maxHeap.add(num);
            //     }
            // } else {
            //     maxHeap.add(num);
            // }
        }


    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(maxHeap.peek());
        }

    }


}

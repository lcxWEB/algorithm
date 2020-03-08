package com.example.demo.nowcoder.offer;

public class RectCover {

    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        System.out.println(rectCover.rectCover(0));
        System.out.println(rectCover.rectCover(1));
        System.out.println(rectCover.rectCover(2));
        System.out.println(rectCover.rectCover(5));

        System.out.println("aa".equals(null));
    }

    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }
}

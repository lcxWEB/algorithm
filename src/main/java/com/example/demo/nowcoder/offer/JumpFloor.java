package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-05 15:32
 */
public class JumpFloor {

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        int i = jumpFloor.JumpFloor1(5);
        System.out.println(i);
    }

    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int jumpMinusOne = 2;
        int jumpMiunsTwo = 1;
        int jump = 0;
        for (int i = 3; i <= target; i++) {
            jump = jumpMinusOne + jumpMiunsTwo;
            jumpMiunsTwo = jumpMinusOne;
            jumpMinusOne = jump;
        }
        return jump;
    }


    public int JumpFloor1(int target) {
        if (target <= 2) {
            return target;
        }
        return JumpFloor1(target - 1) + JumpFloor1(target - 2);
    }


    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }

    public int JumpFloorII1(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target - 1);
    }
}

package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-02 13:42
 */
public class FirstAppearingOnce {

    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.Insert('g');
        firstAppearingOnce.Insert('o');
        firstAppearingOnce.Insert('o');
        firstAppearingOnce.Insert('g');
        firstAppearingOnce.Insert('&');
        char c = firstAppearingOnce.FirstAppearingOnce();
        System.out.println(c);
    }

    private int[] positions = new int[256];
    private int index = 0;

    public FirstAppearingOnce() {
        for (int i = 0; i < 256; i++) {
            positions[i] = -1;
        }
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (positions[ch] == -1) {
            // 表示找到了一个
            positions[ch] = index;
        } else if (positions[ch] >= 0) {
            // 表示重复了
            positions[ch] = -2;
        }
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char result = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            while (positions[i] >=0 && min > positions[i]) {
                min = positions[i];
                result = (char) i;
            }
        }
        return result;
    }

}

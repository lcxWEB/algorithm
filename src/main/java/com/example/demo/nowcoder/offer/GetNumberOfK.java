package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-01-29 22:01
 */
public class GetNumberOfK {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 3, 3, 4, 5};
        int numberOfK = new GetNumberOfK().GetNumberOfK(array, 3);
        System.out.println(numberOfK);
        numberOfK = new GetNumberOfK().getNumberOfK3(array, 6);
        System.out.println(numberOfK);
    }

    public int GetNumbeOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int begin = binarySearch(array, k - 0.5);
        int end = binarySearch(array, k + 0.5);
        return end - begin;
    }

    private int binarySearch(int[] array, double k) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (array[mid] > k) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    /**
     * 2.29
     * 二分查找法，找到第一个K所在位置
     *
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    private int getLeftK(int[] array, int left, int right, int k) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                right = mid;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // k比所有数都大
        if (left == array.length) return -1;
        // 类似之前算法的处理方式
        return array[left] == k ? left : -1;
    }

    /**
     * 2.29
     * 二分查找法，找到最后一个K所在位置
     *
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    private int getRightK(int[] array, int left, int right, int k) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                left = mid + 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return array[left - 1] == k ? (left - 1) : -1;
    }

    /**
     * 2.13
     * O(logn)
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstIndex = getFirstIndexK(array, 0, array.length - 1, k);
        // int firstIndex = getLeftK(array, 0, array.length, k);
        int lastIndex = getLastIndexK(array, 0, array.length - 1, k);
        // int lastIndex = getRightK(array, 0, array.length, k);
        if (firstIndex == -1 && lastIndex == -1) {
            return 0;
        }
        // 不会出现这种情况，如果只有一个，那么firstIndex = lastIndex，且不等于-1
        // if (firstIndex == -1 || lastIndex == -1) {
        //     return 1;
        // }
        return lastIndex - firstIndex + 1;
    }

    /**
     * 二分查找法，找到第一个K所在位置
     *
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    private int getFirstIndexK(int[] array, int left, int right, int k) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                // if (mid > 0 && array[mid - 1] == k) {
                //     right = mid - 1;
                // } else {
                //     return mid;
                // }
                right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // return -1;
        if (left >= array.length || array[left] != k) {
            return -1;
        }
        return left;
    }

    /**
     * 二分查找法，找到最后一个K所在位置
     *
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    private int getLastIndexK(int[] array, int left, int right, int k) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                // if (mid < right && array[mid + 1] == k) {
                //     left = mid + 1;
                // } else {
                //     return mid;
                // }
                left = mid + 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // return -1;
        if (right < 0 || array[right] != k) {
            return -1;
        }
        return right;

    }

    public int GetNumberOfK1(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            } else {
                if (count > 0) {
                    break;
                }
            }
        }
        return count;
    }

    public int GetNumberOfK2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int length = array.length;
        int mid = length / 2;

        while (mid >= 0)
            if (array[mid] > k) {
                mid = mid / 2;
            } else if (array[mid] < k) {
                mid = length / 2 + mid / 2;
            } else {
                count++;

            }

        return count;
    }

    public int getNumberOfK3(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, 0, array.length - 1, k);
        int lastK = getLastK(array, 0, array.length - 1, k);
        if (firstK == -1 && lastK == -1) {
            return 0;
        }
        return lastK - firstK + 1;
    }

    public int getFirstK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = array[mid];

        if (midData == k) {
            if (mid > 0 && array[mid - 1] == k) {
                end = mid - 1;
            } else {
                return mid;
            }
        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(array, start, end, k);
    }

    public int getLastK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midData = array[mid];

        if (midData == k) {
            if (mid < array.length - 1 && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }

        } else if (midData > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getLastK(array, start, end, k);
    }

}

package com.wj.array;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] nums = {1,3,4,6,7,9,10};
        int target = 6;
        int index1 = search1(nums, target);
        System.out.println(index1);

        int index2 = search2(nums, target);
        System.out.println(index2);

    }

    /**
     * 定义target在[left,right]中
     * @param nums
     * @param target
     */
    private static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int middle = left + ((right - left)/2);
            if (nums[middle] > target){
                right = middle - 1;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 定义target在[left,right}中
     * @param nums
     * @param target
     */
    private static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right){
            int middle = left + ((right - left)/2);
            if (nums[middle] > target){
                right = middle;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}

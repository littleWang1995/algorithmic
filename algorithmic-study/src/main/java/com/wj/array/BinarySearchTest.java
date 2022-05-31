package com.wj.array;

/**
 * 二分查找
 *
 * 给定目标数据和目标值,返回目标值在数组中的索引位置
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = {1,5,10,12,23,25,99};
        int target = 25;
        int i = binarySearchMethod1(arr, target);
        System.out.println(i);

        int i2 = binarySearchMethod2(arr, target);
        System.out.println(i2);
    }

    /**
     * 定义目标值在左闭右闭区间
     * @param arr
     * @param target
     */
    private static int binarySearchMethod1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
//            int mid = (left + right) / 2; 这种写法有可能会导致left+right大于int溢出
//            int mid = left + ((right - left) / 2);
            int mid = left + ((right - left) >> 1);//右移一位，相当于除以2
            if (target < arr[mid]){
                right = mid - 1;
            }else if (target == arr[mid]){
                return mid;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 定义目标值在左闭右开区间
     * @param arr
     * @param target
     */
    private static int binarySearchMethod2(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right){
            //            int mid = (left + right) / 2; 这种写法有可能会导致left+right大于int溢出
//            int mid = left + ((right - left) / 2);
            int mid = left + ((right - left) >> 1);//右移一位，相当于除以2
            if (target < arr[mid]){
                right = mid;
            }else if (target == arr[mid]){
                return mid;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    
}

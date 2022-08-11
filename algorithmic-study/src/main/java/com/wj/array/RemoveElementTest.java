package com.wj.array;

/**
 * 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class RemoveElementTest {

    public static void main(String[] args) {
        int[] nums = {1,5,6,2};
        int val = 2;
        int length = removeElement1(nums,val);
        System.out.println(length);

        int length2 = removeElement2(nums,val);
        System.out.println(length2);
    }

    /**
     * 双指针法
     * 快指针：快指针用于寻找新数组的元素，即不包含目标值
     * 慢指针：指向新数组的最后一个元素
     * @param nums
     * @param val
     * @return
     */
    private static int removeElement2(int[] nums, int val) {
        int fastIndex = 0;
        int slowIndex = 0;
        for (fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val){
                //将不是目标值的元素放到新数组中
                nums[slowIndex] = nums[fastIndex];
                //指向新数组的下标位置
                slowIndex++;

            }
        }
        return slowIndex;
    }

    /**
     * 方法1，两层for循环
     * 第一次循环遍历所有元素
     * 第二次循环移动目标元素的后续元素
     * @param nums
     * @param val
     * @return
     */
    private static int removeElement1(int[] nums, int val) {
        //初始长度
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val){
                //将i后面的元素都向前移动一位
                for (int j = i+1; j < length; j++) {
                    nums[j-1] = nums[j];
                }
//                length = length -1;
                length--;
                //因为i后面的元素都往前移动了一位，所以i要减1位
                i--;
            }
        }
        return length;
    }

}

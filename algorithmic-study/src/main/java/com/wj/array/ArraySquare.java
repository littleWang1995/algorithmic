package com.wj.array;

import java.util.Arrays;

/**
 * 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 *
 */
public class ArraySquare {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] result = getArraySquare(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    /**
     * 因为数据是按照从小到大的顺序排列，经过平方之后，最大值要么在最左侧，要么在最右侧
     * 使用双指针法，可以在遍历一遍的情况下完成数组的排序
     * @param nums
     * @return
     */
    private static int[] getArraySquare(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;

        for ( int i = 0,j = nums.length - 1; i<=j;) {// i<=j 是因为最终指针要处理到最后两个元素
            //如果最左边的平方值大于最右边的平方值，则吧最大的值放在result数组的末尾
            if (nums[i] * nums[i] > nums[j] * nums[j]){
                result[k] = nums[i] * nums[i];
                i++;//头值针往后移动一位
            }else {
                result[k] = nums[j] * nums[j];
                j--;
            }
            k--;//指针往前移动一位
        }
        return result;
    }
}

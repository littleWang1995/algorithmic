package com.wj.array;

/*
长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

示例：

输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class SlideWindow {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = slideWindow(nums,7);
        System.out.println(result);
    }

    private static int slideWindow(int[] nums, int s) {
        //采用一层for循环，索引用来表示滑动窗口的尾部，定义头部尾部两个指针
        int i = 0;//滑动窗口的起始位置
        int subLength = 0;//滑动窗口的长度
        int result = Integer.MAX_VALUE;//最终的子数组长度
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];//移动结束位置逐个累加
            //当和大于等于目标值时，说明找到了目标数据，
            // 此时就需要移动起始位置，逐渐缩小范围，找到最小的子数组
            while (sum >= s){
                subLength = j - i + 1;
                result = result < subLength ? result : subLength;//取较小值
                sum -= nums[i++];//移动起始位置，逐渐缩小范围，找到最小的子数组
            }
        }
        return result;
    }
}

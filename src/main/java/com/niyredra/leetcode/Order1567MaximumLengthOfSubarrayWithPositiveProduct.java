/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 11/7/22, 12:43 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

import com.niyredra.common.utils.SampleUtils;

/**
 *
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order1567MaximumLengthOfSubarrayWithPositiveProduct {

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution2 {
        public static void main(String[] args) {
            int[] sortedLargeIntArraySample = SampleUtils.getLargeIntArraySample(5);
            new Solution2()
                    .algorithm();
        }

        public void algorithm() {

        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 以0为分割
     * 计算负数数量
     * 如果数量为奇数，通过左右位移找到负数，计算最短位数，用长度 - 移动位数的到结果
     * 如果为偶数，直接返回长度
     */
    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .getMaxLen(new int[]{1, -2, -3, 4});
        }
        public int getMaxLen(int[] nums) {
            int c = 0, n = 0, max = 0;
            for(int left = 0, i = 0;i < nums.length; ++i) {
                if (nums[i] > 0) c++;
                else if(nums[i] < 0) n++;
                else {
                    // System.out.println(Arrays.toString(nums) + " : " + left + " : " + (i - 1) + " : " + c + " : " + n);
                    max = Math.max(getLen(nums, left, i - 1, c, n), max);
                    if (max > nums.length / 2) return max;
                    left = i + 1;
                    c = n = 0;
                }
                if (nums.length - 1 == i) {
                    // System.out.println("- - - - -");
                    // System.out.println(Arrays.toString(nums) + " : " + left + " : " + i + " : " + c + " : " + n);
                    return Math.max(getLen(nums, left, i, c, n), max);
                }
            }
            return max;
        }


        public int getLen(int[] nums, int left, int right, int c, int nc) {
            int step = 0;
            c = nc + c;
            if (nc % 2 == 1)
                while (left <= right) {
                    step++;
                    if (nums[left++] < 0 || nums[right--] < 0) return c - step;
                }
            return c;
        }
    }
}

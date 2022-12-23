/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 12/23/22, 8:49 AM
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
import com.niyredra.common.utils.time_utils.TimeUtils;

import java.util.*;

public class Order0053MaxSubArray {

    private final static int[] sample = SampleUtils.getLargeIntArraySample();

    /**
     *
     * 这段来源leetcode的题解 <a href="https://leetcode.cn/problems/maximum-subarray/solutions/9058/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/">...</a>
     * 分治方案 数据量过大会导致不稳定（sample单元的范围）
     * 9.880123Ms
     */
    static class Solution2 {
        public static int maxSubArray(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            return maxSubArraySum(nums, 0, len - 1);
        }

        private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
            // 一定会包含 nums[mid] 这个元素
            int sum = 0;
            int leftSum = Integer.MIN_VALUE;
            // 左半边包含 nums[mid] 元素，最多可以到什么地方
            // 走到最边界，看看最值是什么
            // 计算以 mid 结尾的最大的子数组的和
            for (int i = mid; i >= left; i--) {
                sum += nums[i];
                if (sum > leftSum) {
                    leftSum = sum;
                }
            }
            sum = 0;
            int rightSum = Integer.MIN_VALUE;
            // 右半边不包含 nums[mid] 元素，最多可以到什么地方
            // 计算以 mid+1 开始的最大的子数组的和
            for (int i = mid + 1; i <= right; i++) {
                sum += nums[i];
                if (sum > rightSum) {
                    rightSum = sum;
                }
            }
            return leftSum + rightSum;
        }

        private static int maxSubArraySum(int[] nums, int left, int right) {
            if (left == right) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            return max3(maxSubArraySum(nums, left, mid),
                    maxSubArraySum(nums, mid + 1, right),
                    maxCrossingSum(nums, left, mid, right));
        }

        private static int max3(int num1, int num2, int num3) {
            return Math.max(num1, Math.max(num2, num3));
        }

        public static void main(String[] args) {

            for (int i = 0; i < 10000; i++) {
                int[] s = SampleUtils.getLargeIntArraySample();
                if (Solution1.maxSubArray(s) != Solution2.maxSubArray(s)) {
                    System.out.println(s);
                    System.out.println(Solution1.maxSubArray(s));
                    System.out.println(Solution2.maxSubArray(s));
                    break;
                };

            }

            TimeUtils.printTime("Solution2", () -> {
                System.out.println(Solution2.maxSubArray(sample));
            });

        }
    }


    /**
     * 常规方案
     * 23.805678Ms -> 2147468424
     */
    static class Solution1 {
        public static int maxSubArray(int[] nums) {
            int cur = 0,  // 当前链
                    max = nums[0];

            for (int num :
                    nums) {
                // 如果 值 > 0 则整体为增长状态，不需要断开链表
                cur += num;
                if (cur < num) cur = num;
                if (cur > max) max = cur;
            }
            return max;
        }

        public static void main(String[] args) {
            TimeUtils.printTime("Solution1", () -> System.out.println(Solution1.maxSubArray(sample)));
        }
    }
}

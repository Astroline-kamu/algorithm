/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 1/17/23, 11:48 AM
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

import java.util.Arrays;

public class Order0088MergeSortedArrays {


    // 空间优先解法
    static class Solution2 {

        /**
         *
         * 非常拉胯的一种方法 呸～
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        private static void merge(int[] nums1, int m, int[] nums2, int n) {

            // 合并数组
            int i = 0;
            int newVal;
            newVal = nums1.length - nums2.length;
            for (int n2 : nums2) nums1[newVal + i++] = n2;
            nums2 = null;

            i = -1;
            while (++i < nums1.length - 1) {
//
                if (newVal == nums1.length)
                    break;
                System.out.println(Arrays.toString(nums1) + ": " +
                        i + "(" + nums1[i] + ") " +
                        (newVal) + "(" + nums1[newVal] + ") " );

                // 4 5 6 + 1 2 7
                // 1 4 5 6 2 7
                // 1 2 4 5 6 7
                if (nums1[i] >= nums1[newVal]) {
                    int tp = newVal++;
                    while (tp > i) {
                        nums1[tp - 1] ^= nums1[tp];
                        nums1[tp] ^= nums1[tp - 1];
                        nums1[tp - 1] ^= nums1[tp--];
                    }

                }

            }

        }

        public static void main(String[] args) {
            int[] nums1 = SampleUtils.getSortedLargeIntArraySample(400, new int[]{(int) (0 - Math.pow(10, 9)), (int) Math.pow(10, 9)});
            int[] nums2 = SampleUtils.getSortedLargeIntArraySample(200, new int[]{(int) (0 - Math.pow(10, 9)), (int) Math.pow(10, 9)});

            int[] num1 = new int[]{1,2,3,0,0,0};
            TimeUtils.printTime("Merge Two Sorted Arrays Solution2", () -> {
                Order0088MergeSortedArrays.Solution2.merge(num1, 3, new int[]{2,5,6}, 3);
                System.out.println("输出结果：" + Arrays.toString(num1));
            });
        }
    }

    // 时间优先解法
    static class Solution1 {
        private static void merge(int[] nums1, int m, int[] nums2, int n) {

            int i, i1, i2, len = m + n;
            int[] arr = nums1.clone();
            i = i1 = i2 = 0;

            while (len > i) {
                if (i1 == m) {
                    while (i2 < n) nums1[i++] = nums2[i2++];
                    break;
                } else if (i2 == n) {
                    while (i1 < m) nums1[i++] = arr[i1++];
                    break;
                }

                if (arr[i1] < nums2[i2]) nums1[i++] = arr[i1++];
                else nums1[i++] = nums2[i2++];
            }

        }

        public static void main(String[] args) {
            int[] nums1 = SampleUtils.getSortedLargeIntArraySample(400, new int[]{(int) (0 - Math.pow(10, 9)), (int) Math.pow(10, 9)});
            int[] nums2 = SampleUtils.getSortedLargeIntArraySample(200, new int[]{(int) (0 - Math.pow(10, 9)), (int) Math.pow(10, 9)});

            int[] num1 = new int[]{1,2,3,0,0,0};
            TimeUtils.printTime("Merge Two Sorted Arrays Solution1", () -> {
                Order0088MergeSortedArrays.Solution1.merge(num1, 3, new int[]{2, 5, 6}, 3);
                System.out.println("输出结果：" + Arrays.toString(num1));
            });
        }
    }

}

/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 12/12/22, 6:10 PM
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

public class Order0004FindMedianSortedArrays {

    // 时间优先解法
    static class Solution1 {

        // num1[1, 4, 5, 7]
        // num2[0, 1, 8, 9]

        // n20 n11 n21 n14 n15 n17 n28 n29
        // (4 + 5) / 2 4.5
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int i, i1, i2, len = nums1.length + nums2.length;
            int[] arr = new int[len];
            i = i1 = i2 = 0;

            while (len - 1 >= i) {

                if (i1 == nums1.length) {
                    while (i2 < nums2.length) arr[i++] = nums2[i2++];
                    break;
                }else if (i2 == nums2.length) {
                    while (i1 < nums1.length) arr[i++] = nums1[i1++];
                    break;
                }

                if (nums1[i1] < nums2[i2]) arr[i++] = nums1[i1++];
                else arr[i++] = nums2[i2++];

            }
            return len % 2 == 0
                    ? (arr[len / 2 - 1] + arr[len / 2]) * .5
                    : arr[(len - 1) / 2];
        }

        public static void main(String[] args) {
            int[] nums1 = SampleUtils.getSortedLargeIntArraySample(1000);
            int[] nums2 = SampleUtils.getSortedLargeIntArraySample(1000);

            TimeUtils.printTime("Find Median Sorted Arrays Solution1", () -> {
                System.out.println("输入参数：\n" +
                        "nums1 = " + Arrays.toString(nums1) + "\n" +
                        "nums2 = " + Arrays.toString(nums2) + "\n" +
                        "输出结果：" + Order0004FindMedianSortedArrays.Solution1.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})
                );
            });
        }
    }

}

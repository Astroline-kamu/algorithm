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

import com.niyredra.common.utils.time_utils.TimeUtils;

import java.util.*;

public class Order0004FindMedianSortedArrays {


    /**
     * 时间 Timeout
     * in sample case ... 去重循环了 135890361 次
     * same at sample case ... 用时 62963 Ms
     */
    static class Solution1 {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return 0d;
        }

        public static void main(String[] args) {
            int[] nums1 = new int[0];
            int[] nums2 = new int[0];
            TimeUtils.printTime("Find Median Sorted Arrays Solution1", () -> {
                System.out.println("输入参数：\n" +
                        "nums1 = " + Arrays.toString(nums1) + "\n" +
                        "nums2 = " + Arrays.toString(nums2) + "\n" +
                        "输出结果：" + Order0004FindMedianSortedArrays.Solution1.findMedianSortedArrays(nums1, nums2)
                );
            });
        }
    }

}

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

/**
 * 1052. 爱生气的书店老板
 * <p>
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * <p>
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order1052GrumpyBookstoreOwner {


    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * todo 我觉得这个解法还有优化的空间
     * <p>
     * 1和2的思路很简单，就是给 grumpy 加权，然后用默认结果 + grumpy 得到最终结果
     */
    static class Solution2 {
        public static void main(String[] args) {
            new Solution2()
                    .maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);

        }

        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

            int total = 0, left = 0, max = 0, partMax = 0;
            for (int i = 0; i < grumpy.length; i++) {
                total += customers[i] * (1 - grumpy[i]);
                if (grumpy[i] == 1) grumpy[i] = customers[i] * grumpy[i];
            }

            // 数组中连续长度为k的最大值
            for (int i = 0; i < grumpy.length; i++) {
                partMax += grumpy[i];
                if (i - left >= minutes) partMax -= grumpy[left++];
                if (partMax > max) max = partMax;
            }

            return total + max;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
        }

        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int max = 0;
            int total = 0;
            for (int i = 0; i < grumpy.length; i++) {
                int lossless = 0;
                if (i < grumpy.length - minutes + 1)
                    for (int j = 0; j < minutes; j++)
                        if (grumpy[i + j] == 1) lossless += customers[i + j];

                if (lossless > max) max = lossless;
                total += customers[i] * (1 - grumpy[i]);
            }
            return total + max;
        }
    }
}

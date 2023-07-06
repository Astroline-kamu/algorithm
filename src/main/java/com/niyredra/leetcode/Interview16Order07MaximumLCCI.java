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
 *
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Interview16Order07MaximumLCCI {


    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution2 {
        public static void main(String[] args) {
            new Solution2()
                    .maximum(1, 2);
        }

        public int maximum(int a, int b) {
            int[] res = new int[]{a, b};
            return res[(a / 2 - b / 2) >>> 31];
        }

    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .maximum(1, 2);
        }

        public int maximum(int a, int b) {
            int isNegative = (a / 2 - b / 2) >>> 31;
            return ((1 - isNegative) * a) + (isNegative * b);
        }

    }
}

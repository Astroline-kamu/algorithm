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
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0461HammingDistance {

    static class Solution1 {
        public static void main(String[] args) {
            System.out.println(
                    new Solution1()
                            .hammingDistance(1, 9)
            );
        }

        public int hammingDistance(int x, int y) {
            int count = 0;
            x = x ^ y;
            for (y = 0; y < 32; y++) {
                if (x >> y == 0) break;
                if ((x & 1 << y) != 0) count++;
            }
            return count;
        }
    }
}

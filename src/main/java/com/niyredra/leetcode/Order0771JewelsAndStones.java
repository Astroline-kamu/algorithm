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

import java.util.HashSet;
import java.util.Set;

/**
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0771JewelsAndStones {

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution3 {
        public static void main(String[] args) {
            int[] sortedLargeIntArraySample = SampleUtils.getLargeIntArraySample(5);
            new Solution3()
                    .numJewelsInStones("aA", "aAAbbbb");
        }


        public int numJewelsInStones(String jewels, String stones) {
            int i = 0;
            int num = 0;
            Set<Character> characters = new HashSet<>(jewels.length());
            while (i < jewels.length()) characters.add(jewels.charAt(i++));
            i = 0;
            while (i < stones.length()) if (characters.contains(stones.charAt(i++))) num++;
            return num;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution2 {
        public static void main(String[] args) {
            new Solution2()
                    .numJewelsInStones("aA", "aAAbbbb");
        }

        public int numJewelsInStones(String jewels, String stones) {

            int num = 0;
            for (char stone :
                    stones.toCharArray())
                for (char jewel :
                        jewels.toCharArray()) {
                    if (stone == jewel) {
                        num++;
                        break;
                    }
                }
            return num;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .numJewelsInStones("aA", "aAAbbbb");
        }

        public int numJewelsInStones(String jewels, String stones) {

            int num = 0;

            for (int i = 0; i < stones.length(); i++) {
                for (int j = 0; j < jewels.length(); j++) {
                    if (jewels.charAt(j) == stones.charAt(i)) {
                        num++;
                        break;
                    }
                }
            }
            return num;
        }
    }
}

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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0383RansomNote {

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 这个解法同两数之和的解法一样
     */
    static class Solution3 {
        public static void main(String[] args) {
            int[] sortedLargeIntArraySample = SampleUtils.getLargeIntArraySample(5);
            new Solution3()
                    .canConstruct("aa", "aabba");
        }

        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) return false;
            int[] arr = new int[26];
            for (char ch :
                    ransomNote.toCharArray()) {
                int i = magazine.indexOf(ch, arr[ch - 'a']);
                if (i < 0) return false;
                arr[ch - 'a'] = i + 1;
            }
            return true;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 时间  456 ms
     * 内存 42.9 MB
     */
    static class Solution2 {
        public static void main(String[] args) {
            System.out.println(new Solution2()
                    .canConstruct("aa", "aab")
            );
        }

        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) return false;
            Map<Character, Integer> map = new HashMap<>();
            int i;
            for (i = 0; i < magazine.length(); i++)
                map.compute(magazine.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            for (i = 0; i < ransomNote.length(); i++)
                if (map.compute(ransomNote.charAt(i), (k, v) -> v == null ? -1 : v - 1) < 0)
                    return false;
            return true;
        }

    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1 {
        public static void main(String[] args) {
            System.out.println(
                    new Solution1()
                            .canConstruct("aa", "aab")
            );

        }

        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) return false;
            int i;
            int[] arr = new int[26];
            for (i = 0; i < magazine.length(); i++) arr[magazine.charAt(i) - 'a']++;
            for (i = 0; i < ransomNote.length(); i++)
                if (arr[ransomNote.charAt(i) - 'a']-- == 0) return false;
            return true;
        }


    }


}

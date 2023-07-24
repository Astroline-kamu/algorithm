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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * <p>
 * 简单来说就是小学语文说的ABB，AABB的单词。
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0205IsomorphicStrings {

    // -------------------------------------------------------------------------------------------------------------- //

    @SuppressWarnings("性能最差")
    static class Solution2 {
        public static void main(String[] args) {
            boolean isomorphic = new Solution2()
                    .isIsomorphic("title", "paper");

            System.out.println(isomorphic);
            System.out.println('z' - 'G');
            System.out.println('z' + 'G');
        }

        public boolean isIsomorphic(String s, String t) {
            Set<Character> sSet = new HashSet<>();
            Set<Character> tSet = new HashSet<>();
            Set<String> total = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                sSet.add(s.charAt(i));
                tSet.add(t.charAt(i));
                total.add(s.charAt(i) + String.valueOf(t.charAt(i)));
            }
            return total.size() <= sSet.size() && total.size() <= tSet.size();
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     *
     * 还可以再优化一次
     */
    static class Solution1_2 {
        public static void main(String[] args) {
            new Solution1_2()
                    .isIsomorphic("foo", "bar");
        }

        public boolean isIsomorphic(String s, String t) {
            int[] map = new int[255];
            for (int i = 0; i < s.length(); i++) {
                char sCh = s.charAt(i),
                        tCh = t.charAt(i);
                if (map[sCh] == 0 && map[tCh + 127] == 0) {
                    map[sCh] = tCh;
                    map[tCh + 127] = sCh;
                } else if (map[sCh] != tCh || map[tCh + 127] != sCh) return false;
            }
            return true;
        }
    }

    static class Solution1 {
        public static void main(String[] args) {

            int[][] map = new int[26][2];
            System.out.println(Arrays.deepToString(map));
            System.out.println(Arrays.toString(map[0]));
            System.out.println(map[0] == null);
            System.out.println(Arrays.equals(map[0], new int[]{0, 0}));
            new Solution1()
                    .isIsomorphic("foo", "bar");
        }

        public boolean isIsomorphic(String s, String t) {
            int[] map = new int[255];
            for (int i = 0; i < s.length(); i++) {
                if (map[s.charAt(i)] == 0 && map[t.charAt(i) + 127] == 0) {
                    map[s.charAt(i)] = t.charAt(i);
                    map[t.charAt(i) + 127] = s.charAt(i);
                } else if (map[s.charAt(i)] != t.charAt(i) || map[t.charAt(i) + 127] != s.charAt(i)) return false;
            }
            return true;
        }
    }
}

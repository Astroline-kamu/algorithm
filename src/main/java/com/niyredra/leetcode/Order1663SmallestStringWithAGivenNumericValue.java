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
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 * <p>
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 * <p>
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 * <p>
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 * <p>
 * x 是 y 的一个前缀；
 * 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order1663SmallestStringWithAGivenNumericValue {

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 时间 2 ms
     * 内存 41.7 MB
     */
    static class Solution3 {
        public static void main(String[] args) {
            new Solution3()
                    .getSmallestString(4, 8);
        }

        public String getSmallestString(int n, int k) {
//            char[] chars = new char[n];
//            for (int i = 0; i < n; i++) {
//                if ((n - i) * 25 - k > 25) chars[i] = 97;
//                else if ((n - i) * 25 - k > 0) chars[i] = (char) (k + 123 - (n - i) * 25);
//                else chars[i] = 122;
//            }
//            return String.valueOf(chars);
            return null;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution2 {
        public static void main(String[] args) {
            new Solution2()
                    .getSmallestString(5, 7);
        }

        public String getSmallestString(int n, int k) {
            char[] chars = new char[n];
            int size = (n + 1) * 26;
            for (int i = 0; i < n; i++) {
                size -= 25;
                if (size - k > 25) chars[i] = 97;
                else if (size - k > 0) chars[i] = (char) (k + 123 - size);
                else chars[i] = 122;

            }
            return String.valueOf(chars);
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .getSmallestString(5, 73);
        }

        public String getSmallestString(int n, int k) {
            StringBuilder sb = new StringBuilder();
            int size = (n + 1) * 26;
            for (int i = 0; i < n; i++) {
                size -= 25;
                if (size - k > 25) sb.append((char) 97);
                else if (size - k > 0) sb.append((char) (k + 27 + 96 - size));
                else sb.append((char) (26 + 96));

            }
            return sb.toString();
        }
    }
}

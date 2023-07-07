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

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1880. 检查某单词是否等于两单词之和
 * <p>
 * 字母的 字母值 取决于字母在字母表中的位置，从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。
 * <p>
 * 对某个由小写字母组成的字符串 s 而言，其 数值 就等于将 s 中每个字母的 字母值 按顺序 连接 并 转换 成对应整数。
 * <p>
 * 例如，s = "acb" ，依次连接每个字母的字母值可以得到 "021" ，转换为整数得到 21 。
 * 给你三个字符串 firstWord、secondWord 和 targetWord ，每个字符串都由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。
 * <p>
 * 如果 firstWord 和 secondWord 的 数值之和 等于 targetWord 的数值，返回 true ；否则，返回 false 。
 *
 * 解1和解2是量化思路
 *
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order1880CheckIfWordEqualsSummationOfTwoWords {

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution2 {
        public static void main(String[] args) {
//            new Solution2().isSumEqual("acb", "cba", "cdb");
            new Solution2().isSumEqual("j", "j", "bi");
//            new Solution2().isSumEqual("aaa", "a", "aab");
        }

        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            return sumString(firstWord) + sumString(secondWord) == sumString(targetWord);
        }

        private int sumString(String word){
            StringBuilder sb = new StringBuilder();
            word.chars().map(c -> c - 97).forEach(sb::append);
            return Integer.parseInt(sb.toString());
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    /**
     *
     * 前几名的思路和我的思路一样，但是我用了一些高级特性所以...
     */static class Solution1 {
        public static void main(String[] args) {
//            new Solution1().isSumEqual("acb", "cba", "cdb");
            new Solution1().isSumEqual("j", "j", "bi");
            new Solution1().isSumEqual("aaa", "a", "aab");
        }

        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            return sumString(firstWord) + sumString(secondWord) == sumString(targetWord);
        }

        private int sumString(String word){
            AtomicInteger i = new AtomicInteger((int) Math.pow(10, word.length() - 1));
            return word.chars().map(c -> (c - 97) * i.getAndUpdate(v -> (int) (v * .1))).sum();
        }
    }
}

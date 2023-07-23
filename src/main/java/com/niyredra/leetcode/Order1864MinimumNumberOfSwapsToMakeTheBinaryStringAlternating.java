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

/**
 * 解释1:
 * <ul>
 *     <li>如果你想要把这个信息用起来的话，你需要提前先遍历一遍，拿到所有的数据。</li>
 *     <li>如果 1 和 0 的数量相差两个或两个以上的话，直接返回 -1 </li>
 *     <li>如果 1 比 0 的数量多一个，则需要以 1 开头</li>
 *     <li>如果 1 比 0 的数量少一个，则需要 0 开头</li>
 *     <li>如果 1 和 0 的数量刚好对等，可以不在意开头</li>
 * </ul>
 *
 * <p>
 * 解释2:
 * <table width='100%'>
 *     <tr><td>步数（0为原始数据）</td><td>之前的思路</td><td>改良思路</td></tr>
 *     <tr><td>0</td><td>00110011</td></tr>
 *     <tr><td>1</td><td>01100011</td><td>01100011</td></tr>
 *     <tr><td>2</td><td>01001011</td><td>01010011</td></tr>
 *     <tr><td>3</td><td>01011010</td><td>01010101</td></tr>
 *     <tr><td>4</td><td>01010011</td></tr>
 *     <tr><td>5</td><td>01010101</td></tr>
 * </table>
 * 这个案例解释了之前思路的问题所在 当两个不交替的字符串相邻的话，则可以直接把前面内容直接后移一位：0011 -> 0101（特殊条件：王车易位）
 *
 * <p>
 * 解释3:
 * pre -> 非交替字符串的前一位：           11中的第一个1（为了对其所以我就不写是cur的前一位了）
 * cur -> 非交替字符串的第二位：           11中的后一个1
 * begin switchBegin -> 交换点的起始位   11100 大多数情况下都是第一个0（特殊条件见上述解释2）
 * switch switchPoint -> 交换点        11100 大多数情况都是后一个0
 * isZero -> s[p]                     当前未交替的内容是1还是0
 *
 * <p>
 * jump -> 下一个11的位置，解决之后cur设置到jump点 （未实现）
 * jump点优化至少需要通过下面的两个条件来确保准确（未验证）
 * 如果 pre - 1 == pre 的情况下，把cur假设为0
 * 如果 pre - 1 != pre 的情况下，pre + 1 假设为0
 *
 * <p>
 * 判断1:
 * if pre == cur -> 非交替（记录是1还是0的非交替）
 *     cur找0的非交替
 *         if cur的0交替相邻于cur -> cb交换
 *     if s > len -> 最后一位可以无条件交换（cb交换）
 *
 * <p>
 * 演算过程1（10同数1开头）:
 *     10111010011010010010111001011010001001
 *       pc   bs
 *     10101010111010010010111001011010001001
 *             pc   bs
 *     10101010101010110010111001011010001001
 *                   pcbs
 *     10101010101010101010111001011010001001
 *                         pc bs
 *     10101010101010101010101011011010001001
 *                             pc     bs
 *     10101010101010101010101010011010101001
 *                              pcbs
 *     10101010101010101010101010101010101001
 *                                        pcbs
 *     10101010101010101010101010101010101010
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order1864MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 时间 2 ms
     * 内存 41.7 MB
     */
    static class Solution3 {
        public static void main(String[] args) {
            int[] sortedLargeIntArraySample = SampleUtils.getLargeIntArraySample(5);
            new Solution3()
                    .algorithm();
        }

        public void algorithm() {

        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 时间  456 ms
     * 内存 42.9 MB
     */
    static class Solution2 {
        public static void main(String[] args) {
            int[] sortedLargeIntArraySample = SampleUtils.getLargeIntArraySample(5);
            new Solution2()
                    .algorithm();
        }

        public void algorithm() {

        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1 {

        public static void main(String[] args) {
            new Solution1()
                    .minSwaps("111000");
        }

        public int minSwaps(String s) {

            char[] charArray = s.toCharArray();
            boolean zeroBegin;
            short count = 0;
            short cur = 0;
            short sp = 0;


            for (short i = 0; i < charArray.length; i++) {
                if (charArray[i] == 0) cur++;  // 0
                else sp++;
            }


            // 如果 cur > 1 return -1
//             如果 如果等于1 sample[0] > sample[1]

//            -1 0 1
            if (Math.abs(cur - sp) > 1) return -1;

            // 如果数量相同，则默认跳过第一位
            if (cur == sp) {
                zeroBegin = charArray[0] == '0';
                cur = 1;
            } else {

            }
            zeroBegin = cur > sp;
            cur = sp = 0;

            if (zeroBegin) cur++;
            else sp++;

            while(cur < charArray.length) {

            }


            char pre = (char) -1;


            //

            for (char ch : s.toCharArray()) {
                if (pre == ch)
                    pre = ch;
            }

            return -1;
        }
    }
}

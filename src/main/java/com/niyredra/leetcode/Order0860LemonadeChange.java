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

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * <p>
 * 2.
 * Math.log(500000) / Math.log(2) == 18.931568569324174 （log2的结果）
 * 所以可以以2的19次方作为一个进制位做判断...其实没啥必要，但是写1 << 19这样的代码真的很酷诶
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0860LemonadeChange {

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 当然，不出所料的性能最差
     */
    static class Solution3 {
        public static void main(String[] args) {
            new Solution3()
                    .lemonadeChange(new int[]{5, 5, 10, 10, 20});
        }

        public boolean lemonadeChange(int[] bills) {
            final int[] change = {0};
            return Arrays.stream(bills).filter(val -> {
                if (val < 10) change[0] += 5;
                else if (val < 20) {
                    if ((change[0] & 524287) < 5) return true;
                    change[0] += 524283;
                } else {
                    if (change[0] >> 19 > 0 && (change[0] & 524287) >= 5) change[0] -= 524293;
                    else if ((change[0] & 524287) >= 15) change[0] -= 15;
                    else return true;
                }
                return false;
            }).findAny().isEmpty();
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution2 {
        public static void main(String[] args) {
            new Solution2()
                    .lemonadeChange(new int[]{5, 5, 5, 10, 20});
        }

        public boolean lemonadeChange(int[] bills) {
            int change = 0;
            for (int bill : bills) {
                if (bill < 10) change += 5;
                else if (bill < 20) {
                    if ((change & 524287) < 5) return false;
                    change += 524283;
                } else {
                    if (change >> 19 > 0 && (change & 524287) >= 5) change -= 524293;
                    else if ((change & 524287) >= 15) change -= 15;
                    else return false;
                }
            }
            return true;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .lemonadeChange(new int[]{5, 5, 5, 10, 20});
        }

        public boolean lemonadeChange(int[] bills) {
            int change = 0;
            for (int bill :
                    bills) {
                // & (1 << 19) - 1
                // >> 19
                if (bill < 10) change += 5;
                else if (bill < 20) {
                    if ((change & (1 << 19) - 1) < 5) return false;
                    change += (1 << 19) - 5;  // 524287
                } else {
                    if (change >> 19 > 0 && (change & (1 << 19) - 1) >= 5) change -= (1 << 19) + 5;
                    else if ((change & (1 << 19) - 1) >= 15) change -= 15;
                    else return false;
                }
            }
            return true;
        }
    }
}

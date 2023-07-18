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

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 *
 * 自除数 是指可以被它包含的每一位数整除的数。
 * <p>
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * 作者注：
 * 如果你看不懂题目的话，符合条件的元素就是128的第1位(1)、第二位(2)、第三位(8)都可以被128本身整除
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0728SelfDividingNumbers {

    // -------------------------------------------------------------------------------------------------------------- //


    static class Solution3 {
        public static void main(String[] args) {
            List<Integer> integers = new Solution3()
                    .selfDividingNumbers(1, 22);
            System.out.println(integers);
        }

        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> list = new ArrayList<>();
            left--;
            while (++left <= right) {

                if (left % 10 == 0
                        || left % (left % 10) != 0) continue;

                if (left / 10 != 0) {
                    if (left % 100 / 10 == 0
                            || left % (left % 100 / 10) != 0) continue;

                    if (left / 100 != 0) {
                        if (left % 1000 / 100 == 0
                                || left % (left % 1000 / 100) != 0) continue;

                        if ((left / 1000) != 0) {
                            if (left % 10000 / 1000 == 0
                                    || left % (left % 10000 / 1000) != 0) continue;
                        }
                    }

                }
                list.add(left);
            }
            return list;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 时间  456 ms
     * 内存 42.9 MB
     */
    static class Solution2 {
        public static void main(String[] args) {
            List<Integer> integers = new Solution2()
                    .selfDividingNumbers(1, 22);
            System.out.println(integers);
        }

        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> list = new ArrayList<>();
            num:
            while (left <= right) {
                for (int i = 0; i <= 4; i++) {
                    if ((int) (left / Math.pow(10, i)) == 0) break;
                    int res = (int) ((left % Math.pow(10, i + 1) / Math.pow(10, i)));
                    if (res == 0 || left % res != 0) {
                        left++;
                        continue num;
                    }
                }
                list.add(left);
                left++;
            }
            return list;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1 {
        public static void main(String[] args) {
            List<Integer> integers = new Solution1()
                    .selfDividingNumbers(1, 22);
            System.out.println(integers);
        }

        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> list = new ArrayList<>();
            while (left <= right) {
                int finalLeft = left;
                OptionalInt first = String.valueOf(left).chars()
                        .filter(val -> ((val - 48) == 0 || finalLeft % (val - 48) != 0))
                        .findAny();
                if (first.isEmpty()) list.add(left);
                left++;
            }
            return list;
        }
    }
}

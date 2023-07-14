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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 1到n内的所有k位数的组合
 * todo 仅写了递归的思路，还有其它思路的优化空间。
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0077Combinations {

    // -------------------------------------------------------------------------------------------------------------- //


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
    static class Solution2 {
        public static void main(String[] args) {
            new Solution2()
                    .combine(4, 2);
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            toCombine(new ArrayList<>(), result, n, k, 1, 0);
            return result;
        }

        private void toCombine(List<Integer> cur, List<List<Integer>> list, int n, int k, int val, int epoch) {

            if (epoch++ > k) return;
            cur.add(val);
            if (k == cur.size()) list.add(cur);

            for (int i = val + 1; i <= n; i++) {
                if (n - val >= k - cur.size()) toCombine(new ArrayList<>() {{
                    addAll(cur);
                }}, list, n, k, i, epoch);
                if (n - val >= k) toCombine(new ArrayList<>(), list, n, k, i, epoch);
            }
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .combine(4, 2);

        }

        public List<List<Integer>> combine(int n, int k) {
            // 1到n内的所有k位数的组合
            Set<List<Integer>> result = new HashSet<>();
            toCombine(new ArrayList<>(), result, n, k, 1);

            System.out.println(result);
            return result.stream().toList();

        }

        private void toCombine(List<Integer> cur, Set<List<Integer>> list, int n, int k, int val) {

            cur.add(val);
            if (k == cur.size()) list.add(cur);

            for (int i = val + 1; i <= n; i++) {

                if (n - val >= k - cur.size()) {
                    toCombine(new ArrayList<>() {{
                        addAll(cur);
                    }}, list, n, k, i);
                }


                if (n - val >= k) {
                    toCombine(new ArrayList<>(), list, n, k, i);
                }

            }
        }
    }
}

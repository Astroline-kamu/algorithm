/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 5/7/23, 11:00 AM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

import java.util.*;

// todo 写完它！
public class Order1703MinimumAdjacentSwapsForKConsecutiveOnes {

    static class Solution1 {
        static int minMoves(int[] nums, int k) {
            Set<Integer> ks = new HashSet<>();
            List<Cluster> cluster = new ArrayList<>();

            int count = 0, ones = 0, index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    if (count++ == 0) index = i;
                }
                if ((nums[i] != 1 || i + 1 == nums.length) && count != 0) {
                    System.out.println(count);
                    if (count == k) return 0;
                    cluster.add(new Cluster(index, count));
                    ones += count;
                    count = 0;
                }
            }

            if (k > ones) throw new RuntimeException("not enough 0");

            System.out.println(cluster);
            while (!cluster.isEmpty()) {
                ks.add(getStep(cluster, k));
                cluster.remove(0);
            }

            return ks.stream().filter(step -> step > 0).min(Integer::compareTo).orElse(0);
        }

        private static int getStep(List<Cluster> clusterList, int k) {
            int len = 0;
            for (int i = 0; i < clusterList.size(); i++) {
                len += clusterList.get(i).len;
                if (len >= k) {
                    clusterList = clusterList.subList(0, i + 1);
                    if (len > k)
                        clusterList.set(clusterList.size() - 1, new Cluster(clusterList.get(clusterList.size() - 1).index, k - len));
                    break;
                }
            }
            System.out.println(len + " " + k);
            if (len < k) return 0;

            int l = 0, r = 0, zeros = 0;
            len = 0;
            System.out.println("split -> " + clusterList);
            for (int i = 1; i < clusterList.size(); i++) {
                System.out.println(i + " " + (clusterList.size() - i));
                l += clusterList.get(i - 1).len;
                r += clusterList.get(clusterList.size() - i).len;
                if (i >= clusterList.size() - i) {
                    System.out.println(clusterList.get(i));
                    System.out.println(clusterList.get(i - 1));
                    if (i == clusterList.size() - i)
                        len += (clusterList.get(i).index - (clusterList.get(i - 1).index + clusterList.get(i - 1).len)) * Math.min(l, r);
                    break;
                }

//                if (i > 0) zeros = clusterList.get(i - 1).index + clusterList.get(i - 1).len;


                System.out.println(l + " - " + r);
                len += (clusterList.get(i).index - (clusterList.get(i - 1).index + clusterList.get(i - 1).len)) * l;
                zeros += clusterList.get(i).index - (clusterList.get(i - 1).index + clusterList.get(i - 1).len);
//                if (zeros >= clusterList.get(clusterList.size() - 1).index + clusterList.get(clusterList.size() - 1).len - k) continue;
                System.out.println(len);
                len += (clusterList.get(clusterList.size() - i).index -
                        (clusterList.get(clusterList.size() - i - 1).index + clusterList.get(clusterList.size() - i - 1).len)) * r;
                System.out.println(len);
            }
            System.out.println("r -> " + r);
            System.out.println("l -> " + l);
            System.out.println("len -> " + len);
            return len;
        }

        private record Cluster(int index, int len) {

        }

        public static void main(String[] args) {
            int res;
            res = minMoves(new int[]{1, 0, 0, 0, 0, 0, 1, 1}, 3);  // 5
            assert res == 5: "Wrong Result: " + res;
            res = minMoves(new int[]{1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1}, 6);  // 13
            assert res == 13: "Wrong Result: " + res;
            res = minMoves(new int[]{1, 0, 0, 1, 0, 1}, 2);  // 1
            assert res == 1: "Wrong Result: " + res;
            res = minMoves(new int[]{1, 1}, 1);  // 0
            assert res == 0: "Wrong Result: " + res;
            res = minMoves(new int[]{0, 1, 1, 0, 0, 1, 0, 0, 0}, 3);  // 2
            assert res == 2: "Wrong Result: " + res;
            res = minMoves(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0}, 7);  // 4
            assert res == 4: "Wrong Result: " + res;

            System.out.println(res);
        }
    }
}

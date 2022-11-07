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

import java.util.*;

/**
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0001TwoSum {

    /**
     * 时间 2 ms
     * 内存 41.7 MB
     */
    static class Solution3 {
        public static void main(String[] args) {
            System.out.println(
                    Arrays.toString(
                            new Solution3()
                                    .twoSum(new int[]{2, 7, 11, 15},
                                            9)
                    )
            );
        }
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    /**
     * 时间 120 ms
     * 内存 42.9 MB
     */
    static class Solution2_4 {
        public static void main(String[] args) {
            System.out.println(
                    Arrays.toString(
                            new Solution2_4()
                                    .twoSum(new int[]{2, 7, 11, 15},
                                            9)
                    )
            );
        }
        public int[] twoSum(int[] nums, int target) {

            int[][] n2 = new int[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                n2[i] = new int[]{nums[i], i};
            }

            quicksort(n2, 0, nums.length - 1);

            for (int i = 0; i < n2.length; i++) {
                for (int j = i + 1; j < n2.length; j++) {
                    int res = n2[i][0] + n2[j][0];
                    if (res > target) break;
                    if (res == target)
                        return new int[]{n2[i][1], n2[j][1]};
                }

            }
            return null;
        }

        public static void quicksort(int[][] arr, int left, int right) {
            if (right >= left) {
                int[] basic = arr[left];
                int i = left;
                int j = right;
                while (i < j) {
                    while (i < j && arr[j][0] > basic[0]) {
                        j--;
                    }
                    if (i < j) {
                        arr[i] = arr[j];
                        i++;
                    }
                    while (i < j && arr[i][0] < basic[0]) {
                        i++;
                    }
                    if (i < j) {
                        arr[j] = arr[i];
                        j--;
                    }
                }
                arr[i] = basic;
                quicksort(arr, left, i - 1);
                quicksort(arr, i + 1, right);
            }
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    /**
     * 时间 411 ms
     * 内存 41.8 MB
     */
    static class Solution2_3 {
        public static void main(String[] args) {
            System.out.println(
                    Arrays.toString(
                            new Solution2_3()
                                    .twoSum(new int[]{2, 7, 11, 15},
                                            9)
                    )
            );
        }

        public int[] twoSum(int[] nums, int target) {

            final int[] idx = {0};

            // 预处理数据 仅对正数有效
            List<Integer[]> list =
                    Arrays.stream(nums)
                            // 构建二维数组 记录原始角标
                            .mapToObj(num -> new Integer[]{num, idx[0]++})
                            .sorted(Comparator.comparing(num -> num[0]))
                            .toList();

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int res = list.get(i)[0] + list.get(j)[0];
                    if (res > target) break;
                    if (res == target)
                        return new int[]{list.get(i)[1], list.get(j)[1]};
                }

            }
            return null;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    /**
     * 时间 705 ms
     * 内存 42.7 MB
     */
    static class Solution2_2 {
        public static void main(String[] args) {
            System.out.println(
                    Arrays.toString(
                            new Solution2_2()
                                    .twoSum(new int[]{2, 7, 11, 15},
                                            9)
                    )
            );
        }

        public int[] twoSum(int[] nums, int target) {

            final int[] idx = {0};

            // 预处理数据 仅对正数有效
            List<Integer[]> list =
                    Arrays.stream(nums)
                            // 构建二维数组 记录原始角标
                            .mapToObj(num -> new Integer[]{num, idx[0]++})
                            .sorted(Comparator.comparing(num -> num[0]))
                            .toList();

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size() && (list.get(i)[0] + list.get(j)[0]) <= target; j++) {
                    if (list.get(i)[0] + list.get(j)[0] == target)
                        return new int[]{list.get(i)[1], list.get(j)[1]};
                }

            }
            return null;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    /**
     * 时间  456 ms
     * 内存 42.9 MB
     */
    static class Solution2_1 {
        public static void main(String[] args) {
            System.out.println(
                    Arrays.toString(
                            new Solution2_1()
                                    .twoSum(new int[]{2, 7, 11, 15},
                                            9)
                    )
            );
        }

        public int[] twoSum(int[] nums, int target) {

            final int[] idx = {0};

            // 预处理数据 仅对正数有效
            List<Integer[]> list =
                    Arrays.stream(nums)
                            // 构建二维数组 记录原始角标
                            .mapToObj(num -> new Integer[]{num, idx[0]++})
                            .sorted(Comparator.comparing(num -> num[0]))
                            .toList();

            final Integer[] min = {list.get(0)[0]};

            list = list.stream()
                    .filter(num -> num[0] <= target + Math.abs(min[0]))
                    .toList();

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i)[0] + list.get(j)[0] == target)
                        return new int[]{list.get(i)[1], list.get(j)[1]};
                }

            }
            return null;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    /**
     * 时间 55 ms
     * 内存 41.1 MB
     */
    static class Solution1 {
        public static void main(String[] args) {
            System.out.println(
                    Arrays.toString(
                            new Solution1()
                                    .twoSum(new int[]{2, 7, 11, 15},
                                            9)
                    )
            );
        }

        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) return new int[]{i, j};
                }
            }
            return null;
        }
    }
}

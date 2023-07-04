/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 7/4/23, 7:46 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

public class Order0075SortColors {


    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution4 {
        public static void main(String[] args) {
            int[] colors =
                    new int[]{0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 1, 1, 2, 2, 1, 2, 0, 2, 0, 0, 1, 0, 2, 2, 1, 0, 2, 0, 1, 0, 1, 2, 0, 2};
            new Order0075SortColors.Solution4()
                    .sortColors(colors);
        }

        public void sortColors(int[] nums) {

            int h = 0, i = 0, t = nums.length - 1;
            while (i <= t) {
                if(nums[i] == 0) {
                    nums[i++] = nums[h];
                    nums[h++] = 0;
                }else if(nums[i] == 1) i++;
                else {
                    nums[i] = nums[t];
                    nums[t--] = 2;
                }
            }

        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution3 {
        public static void main(String[] args) {
            int[] colors =
                    new int[]{0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 1, 1, 2, 2, 1, 2, 0, 2, 0, 0, 1, 0, 2, 2, 1, 0, 2, 0, 1, 0, 1, 2, 0, 2};
            new Order0075SortColors.Solution3()
                    .sortColors(colors);
        }

        public void sortColors(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        public static void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                quickSort(array, low, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, high);
            }
        }

        public static int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }

            swap(array, i + 1, high);
            return i + 1;
        }

        public static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution2 {
        public static void main(String[] args) {
            int[] colors =
                    new int[]{0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 1, 1, 2, 2, 1, 2, 0, 2, 0, 0, 1, 0, 2, 2, 1, 0, 2, 0, 1, 0, 1, 2, 0, 2};
            new Order0075SortColors.Solution2()
                    .sortColors(colors);
        }

        public void sortColors(int[] nums) {
            // 某人要我写个冒泡
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        nums[i] ^= nums[j];
                        nums[j] ^= nums[i];
                        nums[i] ^= nums[j];
                    }
                }
            }
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1_2 {
        public static void main(String[] args) throws Exception {
            int[] colors =
                    new int[]{0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 1, 1, 2, 2, 1, 2, 0, 2, 0, 0, 1, 0, 2, 2, 1, 0, 2, 0, 1, 0, 1, 2, 0, 2};
            new Order0075SortColors.Solution1_2()
                    .sortColors(colors);
        }

        public void sortColors(int[] nums) {

            int rp, bp;
            rp = 0;
            bp = nums.length - 1;

            for (int num : nums) {
                switch (num) {
                    case 0 -> rp++;
                    case 2 -> bp--;
                    default -> {
                    }
                    // throw new Exception("Unexpected color!");
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i < rp)
                    nums[i] = 0;
                else if (i <= bp)
                    nums[i] = 1;
                else
                    nums[i] = 2;
            }

        }
    }
    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1_1 {
        public static void main(String[] args) throws Exception {
            int[] colors =
                    new int[]{0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 1, 1, 2, 2, 1, 2, 0, 2, 0, 0, 1, 0, 2, 2, 1, 0, 2, 0, 1, 0, 1, 2, 0, 2};
            new Order0075SortColors.Solution1_1()
                    .sortColors(colors);
        }

        public void sortColors(int[] nums) {
            int[] status = new int[3];
            for (int num : nums) {
                switch (num) {
                    case 0 -> status[0]++;
                    case 1 -> status[1]++;
                    case 2 -> status[2]++;
                    default -> {
                    }
//                         throw new Exception("Unexpected color!");
                }
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < status.length; j++) {
                    int len = status[j];
                    if (len == 0) continue;
                    nums[i] = j;
                    status[j]--;
                    break;
                }
            }

        }
    }
}

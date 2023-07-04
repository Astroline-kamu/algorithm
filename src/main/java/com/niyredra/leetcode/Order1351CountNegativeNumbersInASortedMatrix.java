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
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order1351CountNegativeNumbersInASortedMatrix {


    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution2 {
        public static void main(String[] args) {
            int[][] matrixSample = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
            System.out.println(
                    new Solution1()
                            .countNegatives(matrixSample)
            );
        }

        public int countNegatives(int[][] grid) {
            // 因为非递增是对角的，所以可以记录colStart
            int count = 0;
            int colStart = 0;
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = colStart; j < grid[0].length; j++) {
                    if (grid[i][j] < 0) {
                        count += grid[0].length - j;
                        colStart = j;
                        break;
                    }
                }
            }
            return count;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1 {
        public static void main(String[] args) {
            int[][] matrixSample = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
            System.out.println(
                    new Solution1()
                            .countNegatives(matrixSample)
            );
        }

        public int countNegatives(int[][] grid) {
            int count = 0;
            // 如果想要优化一点点内存的话，可以改成用int i来循环
            for (int[] ints : grid) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (ints[j] < 0) {
                        count += ints.length - j;
                        break;
                    }
                }
            }
            return count;
        }
    }
}

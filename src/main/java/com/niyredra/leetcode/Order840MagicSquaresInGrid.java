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
public class Order840MagicSquaresInGrid {


    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution2 {
        public static void main(String[] args) {
//            int[][] grid = new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
            int[][] grid = new int[][]{{4, 7, 8}, {9, 5, 1}, {2, 3, 6}};
            System.out.println(
                    new Solution2()
                            .numMagicSquaresInside(grid)
            );
        }

        public int numMagicSquaresInside(int[][] grid) {
            int count = 0;
            if (grid.length < 3 || grid[0].length < 3) return 0;
            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[i].length - 1; j++) {
                    if (getAroundNumber(grid, i, j)) count++;
                }
            }
            return count;
        }

        /**
         * 获取到周围一圈的内容
         *
         * @param grid grid[][]
         * @param ri   row index
         * @param ci   col index
         */
        public boolean getAroundNumber(int[][] grid, int ri, int ci) {
            if (
                    grid[ri - 1][ci - 1] * grid[ri - 1][ci] * grid[ri - 1][ci + 1] *
                            grid[ri][ci - 1] * grid[ri][ci] * grid[ri][ci + 1] *
                            grid[ri + 1][ci - 1] * grid[ri + 1][ci] * grid[ri + 1][ci + 1] != 362880
            ) return false;
            return grid[ri - 1][ci - 1] + grid[ri - 1][ci] + grid[ri - 1][ci + 1] +
                    grid[ri - 1][ci - 1] + grid[ri][ci - 1] + grid[ri + 1][ci - 1] +
                    grid[ri - 1][ci - 1] + grid[ri][ci] + grid[ri + 1][ci + 1] == 45;

        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1 {
        public static void main(String[] args) {
//            int[][] grid = new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
            int[][] grid = new int[][]{{4, 7, 8}, {9, 5, 1}, {2, 3, 6}};
            System.out.println(
                    new Solution1()
                            .numMagicSquaresInside(grid)
            );
        }

        public int numMagicSquaresInside(int[][] grid) {
            int count = 0;
            if (grid.length < 3 || grid[0].length < 3) return 0;
            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[i].length - 1; j++) {

                    int[] matrix = getAroundNumber(grid, i, j);

                    if (matrix.length == 0) continue;

                    // 计算 横排 竖排 todo 尝试优化到getAroundNumber方法中的去重部分
                    if (
                            (matrix[0] + matrix[1] + matrix[2]) +
                                    (matrix[0] + matrix[3] + matrix[6]) +
                                    (matrix[0] + matrix[4] + matrix[8]) == 45
                    ) count++;
                }
            }
            return count;
        }

        /**
         * 获取到周围一圈的内容
         *
         * @param grid grid[][]
         * @param ri   row index
         * @param ci   col index
         */
        public int[] getAroundNumber(int[][] grid, int ri, int ci) {

            int count = 1;
            int index = 0;
            int[] res = new int[9];

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    count *= grid[ri + i][ci + j];
                    res[index++] = grid[ri + i][ci + j];
                }

            }

            if (count == 362880) return res;
            return new int[0];

        }
    }

}

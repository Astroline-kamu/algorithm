/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 12/27/22, 8:59 AM
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
import com.niyredra.common.utils.time_utils.TimeUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 原地算法中其实不太需要去返回内容的，因为你是通过二维数组的指针去修改内容的——但是这里为了计算不同思路的执行效率，所以才增加了一个返回值和克隆值。
 */
public class Order73SetZeroes {

    private final static int[][] sample = SampleUtils.getSetZeroesSample();

    static class Solution2 {

        /**
         * 原型prototype
         *
         * @param matrix 数据源
         * @return matrix
         */
        public static int[][] setZeroes(int[][] matrix) {

            Set<Integer> row = new HashSet<>();

            // 横向置零
            int col = 0;
            for (int[] ints : matrix) {
                int i = 0;
                boolean haveZero = false;
                for (int val :
                        ints) {
                    if (val == 0) {
                        haveZero = true;
                        row.add(i);
                    }
                    i++;
                }
                if (haveZero) matrix[col] = new int[matrix[col].length];
                col++;
            }

            // 纵向置零
            col = 0;
            for (int[] ints : matrix) {
                for (Integer i :
                        row) {
                    matrix[col][i] = 0;
                }
                col++;
            }

            return matrix;
        }


        public static void main(String[] args) {

            String answer = Arrays.deepToString(Solution2.setZeroes(sample.clone()));
            TimeUtils.printTime("Solution2", () -> Solution2.setZeroes(sample.clone()), 1);

        }
    }

    static class Solution1 {

        public static int[][] setZeroes2(int[][] matrix) {

            boolean[] row = new boolean[matrix[0].length];
            boolean[] col = new boolean[matrix.length];

            // 横向置零
            int ci = 0;
            for (int[] ints : matrix) {
                int ri = 0;
                boolean haveZero = false;
                for (int val :
                        ints) {
                    if (val == 0) {
                        haveZero = true;
                        row[ri] = true;
                    }
                    ri++;
                }
                if (haveZero) {
                    col[ci] = true;
                    matrix[ci] = new int[matrix[ci].length];
                }
                ci++;
            }

            // 纵向置零
            ci = 0;
            for (int[] ints : matrix) {
                if (!col[ci])
                    for (int ri = 0; ri < row.length; ri++) {
                        if (row[ri])
                            matrix[ci][ri] = 0;
                    }
                ci++;
            }

            return matrix;
        }

        /**
         * 原型prototype
         *
         * @param matrix 数据源
         * @return matrix
         */
        public static int[][] setZeroes(int[][] matrix) {

            Set<Integer> row = new HashSet<>();

            // 横向置零
            int col = 0;
            for (int[] ints : matrix) {
                int i = 0;
                boolean haveZero = false;
                for (int val :
                        ints) {
                    if (val == 0) {
                        haveZero = true;
                        row.add(i);
                    }
                    i++;
                }
                if (haveZero) matrix[col] = new int[matrix[col].length];
                col++;
            }

            // 纵向置零
            col = 0;
            for (int[] ints : matrix) {
                for (Integer i :
                        row) {
                    matrix[col][i] = 0;
                }
                col++;
            }

            return matrix;
        }


        public static void main(String[] args) {

            String answer = Arrays.deepToString(Solution1.setZeroes(sample.clone()));

            TimeUtils.printTime("Solution1", () -> Solution1.setZeroes(sample.clone()), 1);

            assert answer.equals(
                    Arrays.deepToString(Solution1.setZeroes2(sample.clone()))
            );
            TimeUtils.printTime("Solution1_2", () -> Solution1.setZeroes2(sample.clone()), 1);
        }
    }


}

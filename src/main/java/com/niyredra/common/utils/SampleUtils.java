/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 12/23/22, 8:51 AM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.common.utils;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * todo 未来引用redis进行缓存，使其可以短期静态化数据行进性能比对
 */
public class SampleUtils {

    static final int[] defaultIntMatrixValRange = new int[]{(int) (0 - Math.pow(2, 31)), (int) (Math.pow(2, 31) - 1)};

    public static int[] getLargeIntArraySample() {
        int len = (int) Math.pow(10, 5);  // 100000
        return getLargeIntArraySample(len);
    }

    public static int[] getLargeIntArraySample(int len) {
        int[] range = {(int) (0 - Math.pow(10, 6)), (int) Math.pow(10, 6)};
        return getLargeIntArraySample(len, range);
    }

    public static int[] getLargeIntArraySample(int len, int[] range) {
        WeakReference<int[]> reference = new WeakReference<>(
                Arrays.stream(new int[len])
                        .map(bound -> randomInt(range)).toArray()
        );
        return reference.get();
    }

    public static int[] getSortedLargeIntArraySample() {
        return Arrays.stream(getLargeIntArraySample()).sorted().toArray();
    }

    public static int[] getSortedLargeIntArraySample(int len) {
        return Arrays.stream(getLargeIntArraySample(len)).sorted().toArray();
    }

    public static int[] getSortedLargeIntArraySample(int len, int[] range) {
        return Arrays.stream(getLargeIntArraySample(len, range)).sorted().toArray();
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static int[][] getIntMatrixSample() {
        return getIntMatrixSample(200, defaultIntMatrixValRange);
    }

    public static int[][] getIntMatrixSample(int len) {
        return getIntMatrixSample(len, defaultIntMatrixValRange);
    }

    public static int[][] getIntMatrixSample(int len, int[] valRange) {
        return getIntMatrixSample(len, len, valRange);
    }


    public static int[][] getIntMatrixSample(int col, int row, int[] valRange) {
        return getIntMatrixSample(new int[]{col}, new int[]{row}, valRange);
    }

    public static int[][] getIntMatrixSample(int[] colRange, int[] rowRange, int[] valRange) {
        if (valRange.length != 2) throw new RuntimeException("无效的数据取值范围！");

        int colLen = randomInt(colRange),
                rowLen = randomInt(rowRange);

        return Arrays.stream(new int[colLen][rowLen])
                .map(col -> Arrays.stream(col)
                        .map(bound -> randomInt(valRange))
                        .toArray()
                ).toArray(int[][]::new);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static int[][] getSetZeroesSample() {

        int[][] result = getIntMatrixSample();

        // x, y
        int
                x = result.length,  // 列数
                y = result[0].length;  // 行数

        // 给多少个0（包含重复）
        for (int i = 0; i < (x * y) / 100; i++) {
            result[new Random().nextInt(x)][new Random().nextInt(y)] = 0;
        }

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static int[] rangeGenerate(int min, int max) {
        return new int[]{min, max};
    }

    private static int randomInt(int[] range) {
        assert range.length <= 2 && range.length > 0;
        if (range.length == 1) range = new int[]{range[0], range[0]};

        long max, min;
        max = min = range[0];

        if (range[0] < range[1]) max = range[1];
        else min = range[1];

        return (int) (new Random().nextLong(max - min + 1) + min);
    }
}

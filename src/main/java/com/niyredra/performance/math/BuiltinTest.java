/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 7/16/23, 9:45 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.performance.math;

import com.niyredra.common.utils.SampleUtils;
import com.niyredra.common.utils.time_utils.TimeUtils;

import java.util.Arrays;
import java.util.List;

public class BuiltinTest {

    public static void main(String[] args) {
        List<int[]> minMaxSample = Arrays.asList(SampleUtils.getIntMatrixSample(50000, 2, new int[]{-25000, 25000}));


        List<Integer> absSamplePositive = Arrays.stream(SampleUtils.getLargeIntArraySample(50000, new int[]{0, 50000}))
                .boxed().toList();
        List<Integer> absSampleAvg = Arrays.stream(SampleUtils.getLargeIntArraySample(50000, new int[]{-25000, 25000}))
                .boxed().toList();
        List<Integer> absSampleNegative = Arrays.stream(SampleUtils.getLargeIntArraySample(50000, new int[]{-50000, 0}))
                .boxed().toList();


        BuiltinTest bt = new BuiltinTest();
// 注：为了避免缓存导致结果的不准确性，所以将此前的测试内容注释 ——不过也同时存在本身就有缓存意义（因为使用的样本数据必须是完全一致的，所以此处就干脆使用平均结果来计算了）
        // 最大最小值的测试并不全面，所以仅供参考（不包含一面定然比另一面大的例子）
        TimeUtils.printTime("最大值测试", () -> minMaxSample.forEach(bt::maxTest), 5);
        TimeUtils.printTime("最小值测试", () -> minMaxSample.forEach(bt::minTest), 5);
        System.out.println("------------------------------------- 这里是分割线 -------------------------------------");

        TimeUtils.printTime("绝对值测试（全正参数）", () -> absSamplePositive.forEach(bt::absTest), 5);
        TimeUtils.printTime("绝对值测试（随机参数）", () -> absSampleAvg.forEach(bt::absTest), 5);
        TimeUtils.printTime("绝对值测试（全负参数）", () -> absSampleNegative.forEach(bt::absTest), 5);


        // 数据量为5w，大小浮动在5w以内：平均执行速度都在8Ms左右｜第二次测试7.5Ms 12Ms
        // 数据量为5w，大小浮动在500w以内，大小在3.5Ms左右，绝对值在5.1Ms左右
        // ...很显然java对大数计算是有优化的，我很抱歉，在这里得出和原本目标无关的结论


        // 以上为基本测试 现在带入到我当前的代码中进行测试：
        System.out.println("------------------------------------- 这里是分割线 -------------------------------------");
        TimeUtils.printTime("参照组测试（空内容）", () -> minMaxSample.forEach(bt::referenceTest), 5);
        TimeUtils.printTime("绝对值实现的业务测试", () -> minMaxSample.forEach(bt::absCombineTest), 5);
        TimeUtils.printTime("最大最小实现的业务测试1（两次计算）", () -> minMaxSample.forEach(bt::sizeCombineTest1), 5);
        TimeUtils.printTime("最大最小实现的业务测试2（换位）", () -> minMaxSample.forEach(bt::sizeCombineTest2), 5);


    }


    private void maxTest(int[] sample) {
        Math.max(sample[0], sample[1]);
    }

    private void minTest(int[] sample) {
        Math.min(sample[0], sample[1]);
    }

    // 应当分为三种 -> 全正 全负 平均
    private void absTest(int x) {
        Math.abs(x);
    }

    // 4.4Ms
    private boolean sizeCombineTest1(int[] sample) {
        return Math.max(sample[0], sample[1]) - Math.min(sample[0], sample[1]) > 1;
    }

    /**
     * 3.1Ms
     * 没有用，只是单纯顺便测试下性能
     *
     * @param sample int[2]
     * @return boolean
     */
    private boolean sizeCombineTest2(int[] sample) {
        if (Math.max(sample[0], sample[1]) == sample[1]) {
            sample[1] ^= sample[0];
            sample[0] ^= sample[1];
            sample[1] ^= sample[0];
        }

        return sample[0] - sample[1] > 1;
    }

    // 3.4Ms
    private boolean absCombineTest(int[] sample) {

        return Math.abs(sample[0] - sample[1]) > 1;
    }

    // 5.3Ms
    private boolean referenceTest(int[] sample) {
        return true;
    }

}

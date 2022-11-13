/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 11/3/22, 3:06 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.common.utils.time_utils;

import com.niyredra.common.utils.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 *
 * 一个有趣的现象：
 * <a href="https://www.cnblogs.com/niejunlei/p/14435438.html">JVM预热</a> - 所以此处有两种分析 首次执行以及缓存后平均执行
 * <p>
 *
 * 我可以说，其实，我可以用Profiler做这个么...
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class TimeUtils {

    /**
     *
     * 简单的时间测试用例
     * @param title 当次测试用例的标记
     * @param callback 具体测试执行内容
     */
    public static void getTime(String title, TimeUtilsCallback callback){
        System.out.println("::: " + title + " :::");
        long begin = new Date().getTime();
        callback.run();
        System.out.println("::: 用时: " + (new Date().getTime() - begin) + "Ms :::");
        System.out.println(
                "-----------------------------------------------------------------------------------"
        );
    }

    /**
     *
     * 一般而言，多次执行的测试只要计算缓存之后的平均时间就好，初次缓存的时间其实是干扰平均结果的，
     * 似乎不太需要靠后面的循环来消费首次循坏带来的压力，这样真的不公平。
     *
     * @param title 当次测试用例的标记
     * @param callback 具体测试内容
     * @param epoch 测试次数
     */
    public static void getTime(String title, TimeUtilsCallback callback, int epoch){
        getTime("初次执行 - " + title, callback);

        System.out.println("::: " + title + " :::");
        long begin = new Date().getTime();
        for (int i = 0; i < epoch; i++) callback.run();
        long end = new Date().getTime() - begin;
        System.out.println(
                StringUtils.toString(
                        "::: 循环 -" + epoch + "- 次 ", "总用时: " + end + "Ms｜", "平均用时: ",
                        BigDecimal.valueOf(end)
                                .divide(BigDecimal.valueOf(epoch),8, RoundingMode.HALF_DOWN)
                                .stripTrailingZeros().toPlainString(),
                        "Ms :::\n",
                        "===================================================================================\n"

                )
        );
    }
}

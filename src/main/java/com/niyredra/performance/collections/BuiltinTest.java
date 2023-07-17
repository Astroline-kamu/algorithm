/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 7/17/23, 10:11 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.performance.collections;

import com.niyredra.common.utils.SampleUtils;
import com.niyredra.common.utils.time_utils.TimeUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * HashSet和HashMap的性能测试
 *
 * Hash的contains的标中率似乎和性能有关 √
 * 所以在理想环境下（内容可被完全或大部分标中的时候，HashSet或者HashMap作为使用标准是可行的，否则性能不如两次遍历）
 */
public class BuiltinTest {

    //
    public static void main(String[] args) {

        int[] jewels = SampleUtils.getLargeIntArraySample(5000, new int[]{0, 52});
        int[] stones = SampleUtils.getLargeIntArraySample(11000000, new int[]{0, 52});

        Set<Integer> set = new HashSet<>(jewels.length);
        Map<Integer, Integer> map = new HashMap<>(jewels.length);

        for (int jewel :
                jewels) {
            set.add(jewel);
            map.put(jewel, 0);
        }

        final int[] num = {0};
        TimeUtils.printTime("空测试", () -> {
            num[0] = 0;
            for (int stone : stones) num[0]++;
        }, 5);
        System.out.println("空测试 Result: " + num[0]);

        TimeUtils.printTime("HashMap", () -> {
            num[0] = 0;
            for (int stone :
                    stones) {
                if (map.containsKey(stone)) num[0]++;
            }
        }, 5);

        System.out.println("HashMap Result: " + num[0]);

        TimeUtils.printTime("HashSet", () -> {
            num[0] = 0;
            for (int stone :
                    stones) {
                if (map.containsKey(stone)) num[0]++;
            }
        }, 5);
        System.out.println("HashSet Result: " + num[0]);

        TimeUtils.printTime("两次循环", () -> {
            num[0] = 0;
            for (int i = 0; i < stones.length; i++) {
                for (int j = 0; j < jewels.length; j++) {
                    if (stones[i] == jewels[j]) {
                        num[0]++;
                        break;
                    }
                }
            }
        }, 5);
        System.out.println("两次循环 Result: " + num[0]);

    }

}

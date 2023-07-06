/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 7/6/23, 11:49 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order0865SmallestSubtreeWithAllTheDeepestNodesTest {

    @Test
    public void lambdaTest() {
        HashMap<Integer, Integer> map = new HashMap<>(){{
            put(1, 5);
            put(2, 8);
            put(3, 9);
        }};

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        list.stream()
                .map(map::get)
                .forEach(System.out::println);  // 5, 8, 9
    }


}
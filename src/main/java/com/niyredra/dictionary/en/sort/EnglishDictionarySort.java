/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 4/22/23, 1:33 AM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.dictionary.en.sort;

import java.util.Comparator;
import java.util.List;

public class EnglishDictionarySort {

    public static void main(String[] args) {
        // 方式1
        System.out.println("================= 方式1 原生排序 =================");
        Example.getExample().stream().sorted((o1, o2) -> (int) (o1.getP() - o2.getP())).forEach(System.out::println);

        System.out.println("================= 方式2 使用Comparator排序 =================");

        Example.getExample().stream().sorted(Comparator.comparing(Word::getP)).forEach(System.out::println);

        System.out.println("================= 方式3 倒序排序 =================");

        Example.getExample().stream().sorted(Comparator.comparing(Word::getP).reversed()).forEach(System.out::println);

        System.out.println("================= 方法4 Collection对象排序 =================");
        // 方式2
        List<Word> example = Example.getExample();
        example.sort(Comparator.comparingDouble(Word::getP));
        example.forEach(System.out::println);

    }
}

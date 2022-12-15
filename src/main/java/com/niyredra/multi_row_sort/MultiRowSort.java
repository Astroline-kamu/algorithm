/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 12/15/22, 11:10 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.multi_row_sort;

import com.niyredra.common.utils.time_utils.TimeUtils;

import java.util.*;

/**
 *
 * 在做一个数据结构的时候突然想到的方式，对多行数据进行分类或者排序的算法
 */
public class MultiRowSort {

    private static final int rowLen = 12;
    private static final int colLen = 500000;

    public static void main(String[] args) {

        int[] sortRow = new int[]{3, 5, 11};
        List<List<Integer>> sample = getSample();


        TimeUtils.printTime("默认方式进行多级排序", () -> defaultSort(sample, sortRow));

        TimeUtils.printTime("爪法进行多级排序", () -> multiRowSort(sample, sortRow));

        System.out.println(defaultSort(sample, sortRow).equals(multiRowSort(sample, sortRow)));

    }


    public static List<List<Integer>> multiRowSort(List<List<Integer>> sample, int[] row){

        HashMap<Integer, HashMap<Object, Integer>> dic = new HashMap<>() {{
            for (Integer i :
                    row) {
                put(i, new HashMap<>());
            }
        }};

        // 多级分类计数器 - 用来标记每列中内容现了多少次
        int[] count = new int[rowLen];

        for (List<Integer> s : sample) {
            int res = 0;
            int ci = row.length;
            for (Integer col :
                    row) {
                Object val = s.get(col);
                if (!dic.get(col).containsKey(val)) dic.get(col).put(val, ++count[col]);
                res += dic.get(col).get(val) * Math.pow(s.size(), --ci);
            }
            s.add(res);
        }

        sample.sort(Comparator.comparing(r -> r.get(rowLen)));

        return sample;
    }

    public static List<List<Integer>> defaultSort(List<List<Integer>> sample, int[] row){

        for (int ri : row) {
            sample.sort(Comparator.comparing(r -> r.get(ri)));
        }

        return sample;
    }

    private static List<List<Integer>> getSample(){

        List<List<Integer>> sample = new ArrayList<>();

        for (int ci = 0; ci < colLen; ci++) {
            sample.add(new ArrayList<>());
            for (int ri = 0; ri < rowLen; ri++) {
                sample.get(ci).add(new Random().nextInt());
            }
        }

        return sample;
    }
}

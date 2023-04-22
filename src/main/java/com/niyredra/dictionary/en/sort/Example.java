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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 样本生成 - 一般来说存储在数据库里的内容
 * 这只是其中一个想法，通过计算出一个位置来标记单词的排序形式，另外的想法，比如进行一个角标判断，按位数进行比较大小进行n次排序等等。
 */
public class Example {

    private static final List<String> wordList = new ArrayList<>(
            List.of("Eve", "Astroline", "Niyredra", "YouKnowWho", "Jim", "Dictionary", "GhostTown", "ATM", "Zolize",
                    "aaa", "aab", "aba", "baa",
                    "aa", "ab", "ba"
            )
    );
    private static final int alphabetLength = 26;
    private static final int wordLengthCount = 50;  // 50个单词以内都可以考虑用这种方式排序
    private static final double[] fillWeightModMap = generateModFillMap();

    private static final int letterCharKey = 96;

    static List<Word> getExample() {
        System.out.println(Arrays.toString(fillWeightModMap));
        List<Word> result = new ArrayList<>();
        for (String word :
                wordList) {
            result.add(new Word(word, mod(word.toLowerCase().toCharArray())));
        }
        return result;
    }

    static Double mod(char[] word) {
        double mod = 0D;
        // todo 用word.length替代
        int wordLength = wordLengthCount;
        // todo 如果这样写的话需要把所有子元素都填充进去占位，这样的话就需要再来一张表拿数据了，就显得很不合规
        // 开个玩笑，++i性能要比i++高，虽然多半已经修复了，所以说开个玩笑
        // todo 写个测试来验证两个角标是同步的(检查末尾是不是0，或者生成一个同长的单词) 你可以理解一下，从50开始，到最后一定是1，从49开始，到最后是0
        for (int i = 0; i < word.length; ++i) {
            mod += Math.pow(word[i] - letterCharKey + Math.pow(alphabetLength, (wordLengthCount - i)), 2);
            --wordLength;
        }
        // atm为50, 49, 48;补全47和往后
        System.out.println(" - - - - - - - - - - - - - - - - -");
        System.out.println(Arrays.toString(word) + " " + Math.sqrt(mod) + " -> " + Math.sqrt(getAlphabetModMap(wordLengthCount - wordLength)));
        System.out.println(mod > getAlphabetModMap(wordLengthCount - wordLength));
        return Math.pow(mod + getAlphabetModMap(wordLengthCount - wordLength), .5);
    }

    static Double getAlphabetModMap(int startedIndex) {
        if (startedIndex > fillWeightModMap.length) return 0D;
        return fillWeightModMap[startedIndex];
    }

    // 降序排序
    private static double[] generateModFillMap() {
        double curVal = 0D;
        double[] modFillMap = new double[wordLengthCount];
        for (int i = 1; i <= modFillMap.length; ++i) {
//            curVal += ;
            modFillMap[modFillMap.length - i] = Math.pow(alphabetLength + Math.pow(alphabetLength, i), 2);
        }
        return modFillMap;
    }

    // 虽然可以求出等差数列，但是取不出模= =
    public static int arithmeticSum(int firstTerm, int commonDifference, int n) {
        return (n * (2 * firstTerm - (n - 1) * commonDifference)) / 2;
    }


}

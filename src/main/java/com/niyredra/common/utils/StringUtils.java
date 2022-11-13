/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 11/13/22, 11:03 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.common.utils;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class StringUtils {

    public static String packagePath(String ...path){
        // 这里顺便提一下，flatMap返回的是对原数据结构的拆分结果，比如说，返回结果原本是一个String[]，在flatMap里就会把里面的元素拆开，和外部元素合并，成为一个新的更大的String[]
        return Arrays.stream(path).map(s -> s + File.separator).collect(Collectors.joining());
    }

    public static String toString(String ...strings){
        return String.join("", strings);
    }
}

/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 1/17/23, 2:20 PM
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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Order0088MergeSortedArraysTest {

    @Test
    public void swapTest(){

        int[] nums1 = new int[]{1, 5};

        swap(nums1, 0, 1);
        swap(nums1, 1, 0);
        swap(nums1, 0, 1);

        System.out.println(Arrays.toString(nums1));

    }

    // 新声明两个变量 仅测试时使用
    private void swap(int[] nums, int i1, int i2){
        nums[i1] ^= nums[i2]; // 0001 ^ 0010 = 0011
        nums[i2] ^= nums[i1]; // 0010 ^ 0011 = 0001
        nums[i1] ^= nums[i2]; // 0011 ^ 0001 = 0010
    }



}
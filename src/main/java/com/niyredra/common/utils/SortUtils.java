/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 11/14/22, 8:47 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.common.utils;

/**
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class SortUtils {

    /**
     * 快速排序可能会造成栈溢出的问题
     * 1. 数组长度过大
     * 2. 数组本身是有序的
     *
     * @param arr   比对数组
     * @param left  左偏移角标
     * @param right 右偏移角标
     */
    public static void quicksort(int[] arr, int left, int right) {
        if (right >= left) {
            int basic = arr[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && arr[j] > basic) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < basic) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = basic;
            quicksort(arr, left, i - 1);
            quicksort(arr, i + 1, right);
        }
    }

    /**
     * 一个简单的冒泡排序
     *
     * @param arr 被排序对象
     */
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }


    /**
     * 希尔排序 以下集中排序代码来自 -> <a href="https://blog.csdn.net/qq_59974657/article/details/123829224">这篇文章</a>
     *
     * @param arr 被排序的数组
     */
    public static void shell(int[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }


    /**
     * 插入排序
     *
     * @param arr 排序内容
     */
    public static void insertion(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找元素 arr[i] 合适的插入位置
            for (int j = i; j > 0; j--)
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
        }
    }

    public static void selection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}

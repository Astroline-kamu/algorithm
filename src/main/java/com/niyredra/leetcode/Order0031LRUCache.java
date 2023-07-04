/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 5/6/23, 4:10 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Order0031LRUCache {

    static class Solution1{

        static class LRUCache {

            private HashMap<Integer, Integer> cache;
            private int c[][];

            public LRUCache(int capacity) {
                c = new int[capacity][2];
            }

            public int get(int key) {
                return 0;
            }

            public void put(int key, int value) {
                // get x
                // put y
            }
        }

        public static void main(String[] args) {
            LRUCache lRUCache = new LRUCache(2);
            lRUCache.put(1, 1); // 缓存是 {1=1}
            lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
            lRUCache.get(1);    // 返回 1
            lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
            lRUCache.get(2);    // 返回 -1 (未找到)
            lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
            lRUCache.get(1);    // 返回 -1 (未找到)
            lRUCache.get(3);    // 返回 3
            lRUCache.get(4);    // 返回 4
        }

    }
}

/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 11/7/22, 12:43 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

import com.niyredra.common.utils.construct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * --------------------------------------------
 * <p>
 * 因为有环，所以快指针是可以追上慢指针的；
 * 单数链表和双数链表结果 ->
 * <p>
 * 1 2 3 4 -> 12 24 32 44
 * <p>
 * 1 2 3 -> 12 21 33
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0141LinkedListCycle {

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 在看到了反转列表的解法的时候想到了这个方法
     * 但是这种方式并不行，除非我能找到头在哪
     */
    @SuppressWarnings("废弃代码")
    static class Solution3 {
        public static void main(String[] args) {
            new Solution3()
                    .hasCycle(new ListNode(115));
        }

        public boolean hasCycle(ListNode head) {
//            ListNode next = head;
//            while (true){
//                if (head == next) return true;
//                else if (next == null) return false;
//                next = next.next;
//            }

            int val = head.val;
            while (true) {
                head = head.next;
                if (head == null) return false;
                else if (val == head.val) return true;
            }
        }

    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution2 {
        public static void main(String[] args) {
            new Solution2()
                    .hasCycle(new ListNode(123));
        }

        public boolean hasCycle(ListNode head) {

            ListNode fn, sn;
            fn = sn = head;
            while (sn != null && (fn != null && fn.next != null)) {
                sn = sn.next;
                fn = fn.next.next;
                if (fn == sn) return true;
            }
            return false;
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //

    static class Solution1 {
        public static void main(String[] args) {
            new Solution1()
                    .hasCycle(new ListNode(12));
        }

        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                set.add(head);
                if (set.contains(head.next)) return true;
                head = head.next;
            }
            return false;
        }
    }
}

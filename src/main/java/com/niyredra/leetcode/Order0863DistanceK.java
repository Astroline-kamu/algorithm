/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 4/13/23, 12:18 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

import com.niyredra.common.utils.SampleUtils;
import com.niyredra.common.utils.TreeNode;
import com.niyredra.common.utils.TreeNodePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order0863DistanceK {
    static class Solution {
        private static HashMap<Integer, TreeNode> parentNode;
        private static List<Integer> result;

        public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            parentNode = new HashMap<>();
            result = new ArrayList<>();
            parentNode.put(root.val, null);
            searchNode(root, target);
            step(target, k, true);
            return result;
        }

        private static void searchNode(TreeNode node, TreeNode target) {
            if (target == node) return;
            if (node != null) {
                if (node.left != null) parentNode.put(node.left.val, node);
                searchNode(node.left, target);
                if (node.right != null) parentNode.put(node.right.val, node);
                searchNode(node.right, target);
            }
        }

        private static void step(TreeNode node, int k, boolean isParentNode) {
            System.out.println(node.val);
            if (k == 0) {
                result.add(node.val);
            } else if (k < 0) {
                return;
            }
            if (node.left != null)
                step(node.left, k - 1, false);
            if (node.right != null)
                step(node.right, k - 1, false);
            if (isParentNode) step(parentNode.get(node.val), node, k - 1, true);

        }

        /**
         * @param node 自身
         * @param next 上一个节点（在树中的位置是下面）
         * @param k    步进
         */
        private static void step(TreeNode node, TreeNode next, int k, boolean isParentNode) {
            if (k == 0)
                if (node != null) result.add(node.val);

            if (k < 0) return;
            if (node == null) {
                // 这个会走parent之前重复走过的路
                if (next.left == next) step(next.right, next, k, false);
                else if (next.right == next) step(next.left, next, k, false);
            } else {
                if (node.left != null && node.left != next)
                    step(node.left, k - 1, false);
                if (node.right != null && node.right != next)
                    step(node.right, k - 1, false);
                if (isParentNode) step(parentNode.get(node.val), node, k - 1, true);
            }

        }

        public static void main(String[] args) {

            TreeNode treeNodeSample = SampleUtils.getTreeNodeSample(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
            List<Integer> integers = distanceK(treeNodeSample, treeNodeSample.left.right, 2);

//            TreeNode treeNodeSample = SampleUtils.getTreeNodeSample(new Integer[]{0, 1, null, 3, 2});
//            List<Integer> integers = distanceK(treeNodeSample, treeNodeSample.left.right, 1);
            System.out.println(integers);
            TreeNodePrinter.print(treeNodeSample);

//            new Order0863DistanceK.Solution().distanceK()
        }
    }


}


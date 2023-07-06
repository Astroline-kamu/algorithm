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

import com.niyredra.common.utils.SampleUtils;

import java.util.*;

/**
 *
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 * 返回包含原始树中所有 最深节点 的 最小子树 。
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class Order0865SmallestSubtreeWithAllTheDeepestNodes {

    // -------------------------------------------------------------------------------------------------------------- //

    /**
     * 时间 2 ms
     * 内存 41.7 MB
     */
    static class Solution3 {
        public static void main(String[] args) {
            int[] sortedLargeIntArraySample = SampleUtils.getLargeIntArraySample(5);
            new Solution3()
                    .algorithm();
        }

        public void algorithm() {

        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1_2 {
        public static void main(String[] args) {
            // todo 树状结构的样本我在SampleUtils中有写的，但是现在不是很想去补充...
            new Solution1_2()
                    .subtreeWithAllDeepest(
                            new TreeNode()
                    );
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root.left == null && root.right == null) return root;
            return breadthSearch(new HashSet<>(){{
                add(root);
            }});
        }

        private TreeNode breadthSearch(Set<TreeNode> nodeSet) {

            HashMap<TreeNode, TreeNode> parentTree = new HashMap<>();

            while (true) {
                Set<TreeNode> freshSet = new HashSet<>();
                for (TreeNode node
                        : nodeSet)
                    addContext(parentTree, freshSet, node);
                if (freshSet.size() == 0) return getDeepestSubTree(parentTree, nodeSet);
                nodeSet = freshSet;
            }
        }

        private void addContext(
                HashMap<TreeNode, TreeNode> parentMap,
                Set<TreeNode> nodeSet,
                TreeNode node
        ) {
            if (node.left != null) {
                parentMap.put(node.left, node);
                nodeSet.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                nodeSet.add(node.right);
            }
        }

        private TreeNode getDeepestSubTree(
                HashMap<TreeNode, TreeNode> parentMap,
                Set<TreeNode> nodeSet
        ) {

            while (nodeSet.size() > 1) {
                HashSet<TreeNode> set = new HashSet<>();
                nodeSet.stream().map(parentMap::get).forEach(set::add);
                nodeSet = set;
            }

            return nodeSet.toArray(TreeNode[]::new)[0];
        }
    }

    // -------------------------------------------------------------------------------------------------------------- //
    static class Solution1 {
        public static void main(String[] args) {
            // todo 树状结构的样本我在SampleUtils中有写的，但是现在不是很想去补充...
            new Solution1()
                    .subtreeWithAllDeepest(
                            new TreeNode()
                    );
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root.left == null && root.right == null) return root;
            return breadthSearch(new ArrayList<>() {{
                add(root);
            }});
        }

        private TreeNode breadthSearch(List<TreeNode> nodeList) {

            HashMap<TreeNode, TreeNode> parentTree = new HashMap<>();

            while (true) {
                List<TreeNode> freshList = new ArrayList<>();
                for (TreeNode node
                        : nodeList)
                    addContext(parentTree, freshList, node);

                if (freshList.size() == 0)
                    return getDeepestSubTree(parentTree, nodeList);

                nodeList = freshList;
            }
        }

        private void addContext(
                HashMap<TreeNode, TreeNode> parentMap,
                List<TreeNode> nodeList,
                TreeNode node
        ) {
            if (node.left != null) {
                parentMap.put(node.left, node);
                nodeList.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                nodeList.add(node.right);
            }
        }

        private TreeNode getDeepestSubTree(
                HashMap<TreeNode, TreeNode> parentMap,
                List<TreeNode> nodeList
        ) {

            HashSet<TreeNode> nodeSet = new HashSet<>(nodeList);
            while (nodeSet.size() > 1) {
                HashSet<TreeNode> set = new HashSet<>();
                nodeSet.stream().map(parentMap::get).forEach(set::add);
                nodeSet = set;
            }

            return nodeSet.toArray(TreeNode[]::new)[0];
        }
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
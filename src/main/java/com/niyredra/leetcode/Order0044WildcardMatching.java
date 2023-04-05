/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 1/18/23, 2:19 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.leetcode;

import com.niyredra.common.utils.time_utils.TimeUtils;

public class Order0044WildcardMatching {


    static class Solution1 {
// aabaacabaaaa
// a*b*ca*
        // a b c?a a

        // split by *

// a*b aab
// b*ca baaca
// ca*a caba aaa

        // 基于动规实现 准备换思路吧
        public static boolean isMatch(String s, String p) {

            // static pattern index
            // string index
            int spi = 0, si = 0;  // 基数
            boolean isStar = false;

            for (int pci = 0; pci < p.length(); pci++) {

                char ps = p.charAt(pci);
                if ('*' == ps) {
                    isStar = true;
                    spi = pci + 1;
                    if (pci == p.length() - 1) return true;
                } else {
                    if (si == s.length()) return false;
                    System.out.println(ps + "(" + pci + ")" + "   " + s.charAt(si) + "(" + si + ")" + "\t" + spi);
                    if (isStar) {
                        // 收尾仪式 从后向前判断到spi的位置
                        if (pci == p.length() - 1) {
                            if (s.length() - pci + spi < p.length() - spi) return false;
                            System.out.println("=== " + s.substring(s.length() - (p.length() - spi)) + " " + p.substring(spi) + " ===");
                            return isMatch(s.substring(s.length() - (p.length() - spi)), p.substring(spi));
                        }
                        if (!(ps == s.charAt(si)
                                || '?' == ps)
                        ) {
                            si = si - pci + spi;
                            pci = spi - 1;
                        }
                    } else if (!(ps == s.charAt(si)
                            || '?' == ps)
                    ) return false;

                    si++;
                }

            }
            return si == s.length();
        }

    }

    /**
     * @param s  source 源内容
     * @param t  target 目标内容 *与*之间的内容 or *到结尾的内容
     * @param si source index 保持叠加 直到结束位置
     * @param ti target index 如果连续匹配到则继续，否则清零
     * @return si 最终si的地址
     */
    private static int match(String s, String t, int si, int ti) {
        while (ti < t.length()) {
            String ts = t.substring(ti, 1);
            if (ts.equals(s.substring(si, 1))
                    || "?".equals(ts)
            ) {
                ti++;
                si++;
            } else {
                ti = 0;
            }
        }

        return si;
    }

    public static void main(String[] args) {
        TimeUtils.printTime("Wildcard Matching Solution1", () -> {
//                System.out.println("输出结果：" + Order0044WildcardMatching.Solution1.isMatch("aabaacabaaaa", "a**************************************b**c*ab"));
            System.out.println("输出结果：" + Order0044WildcardMatching.Solution1.isMatch("aabaacabaaaa", "a**************************************b**c*ab"));
        });
    }
}




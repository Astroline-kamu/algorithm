/*
 * Copyright (c) 2022. Astroline All rights reserved.
 *
 * @date: 11/3/22, 12:29 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.TextSearch.src;

import com.niyredra.common.utils.time_utils.TimeUtils;

import java.util.*;
import java.util.stream.Stream;

/**
 * 定义词典的方法非常适合对静态数据查询使用，动态数据需要有一个补充算法，将不同的部分补充到树中，这样的运行效率还是颇高的
 *
 * @author Niyredra Astroline_kamu@outlook.com
 */
public class PureTextDicSearch {

    static HashMap<Character, List<Integer>> dic = getDic(getSample());

    public static void main(String[] args) {

        String searchKeyEquals = "人设";
        String searchKeyBlur = "知乎人设";

        TimeUtils.printTime("General Contains", () -> System.out.println(getSample().contains(searchKeyEquals)));

        TimeUtils.printTime("Source Search Dic", () -> {
            System.out.println(getDic(getSample()));
        });

        TimeUtils.printTime("Equals Search Result", () -> System.out.println(searchEquals(searchKeyEquals)));

        // 特殊用法 取到所有匹配到的点
//        TimeUtils.printTime("Equals Search Result" ,
//        () -> searchEqualsAndReturn(searchKeyEquals).forEach(System.out::println));

        TimeUtils.printTime("General All Contains", () ->
                System.out.println(
                        Stream.of(searchKeyBlur.toCharArray())
                                .allMatch(word ->
                                        getSample().contains(Arrays.toString(word))
                                )
                )
        );

        TimeUtils.printTime("Blur Search Result", () -> System.out.println(searchBlur(searchKeyBlur)));
    }

    public static boolean searchEquals(String content) {
        for (Integer i :
                dic.get(content.charAt(0))) {
            if (getSample()
                    .startsWith(content, i))
                return true;
        }
        return false;
    }

    public static String searchBlur(String content) {
        if (getDic(content).keySet().stream().allMatch(k -> dic.get(k) != null))
            return getSample();
        return null;
    }

    public static List<String> searchEqualsAndReturn(String content) {

        List<String> result = new ArrayList<>();

        for (Integer i :
                dic.get(content.charAt(0))) {
            if (getSample()
                    .startsWith(content, i)) {
                int begin = i >= 5 ? i - 5 : 0;
                int end = Math.min(i + content.length() + 5,
                        getSample().length());
                result.add(getSample().substring(begin, end));
            }
        }
        return result;
    }

    /**
     * Character    是文本内容点
     * Integer      是内容角标
     *
     * @param sample 被比对的文字
     * @return 词典
     */
    public static HashMap<Character, List<Integer>> getDic(String sample) {
        HashMap<Character, List<Integer>> dic = new LinkedHashMap<>();

        // 我想试试用stream流完成一下，参考 https://baijiahao.baidu.com/s?id=1738098020923007265&wfr=spider&for=pc
        for (int i = 0; i < sample.length(); i++) {
            char ch = sample.charAt(i);
            dic.putIfAbsent(ch, new ArrayList<>());
            dic.get(ch).add(i);
        }
        return dic;
    }

    public static String getSample() {
        return """
               「嗯嘛！」他如此回复，做为这段会话的收尾。
               但是他觉得好像少说了点什么东西，于是又在输入框里补充「说起来，我在考虑去做一个人设，一个知乎里的人设，但是我觉得这个人设我有点做不下去……」，他停了下来，删掉了这段话，这段没有过脑子的话。他不知道为什么自己会这么写，也不知道自己想要表达什么，就只是感觉这个时候需要说这么一个东西，好像在补充说明着什么。
               他打开了知乎，翻出了自己写的那份关于「亚斯兰娜」的人设，回忆着当时写这份人设的动机。那是他用知乎第一次正式的发了一片文章，从那时起，他就决定给自己单独开辟一个新的人设去运营这个账号。他是这么准备的，也是这么做的，只是从那以后再也没有继续发过文章了。那一天如同其它的日子一般，只是突然心血来潮的一次冲动的举措罢了，让自己在很久之后重新去看到这些内容的时候感到陌生和……奇怪。
               
               「小龙龙亚斯兰娜，一条一定要开一家猫舍的龙龙，向着无限萌萌的食物啊不，猫猫去奋斗！」
               
               奇怪，为什么会有这样的人设。他一遍又一遍的读着自己写下的内容，删掉、重做，大脑已经停止了思考，他放弃了推敲，放弃了思考，他不想再去思考为什么要说这些话抑或是想表达的点在哪里，又或者去想着如何去接这段话往后面怎么去走，只是写下来，将所有想要表达的东西都打出来，然后command a delete掉，再command z回来，他的不停重复着这一步骤，越来越快，手指在键盘上疯狂的敲打着那两组键位，突然，右手中指下滑一段距离，敲了下去。
               
               然后就有了这么一个不知道是什么的奇怪的话，没有任何的逻辑，语言的组织，完全就是一坨被强行压到一起的数据。
               
               「说起来，我有这么设计过一个人设，准确的说是一个龙设。小龙龙亚斯兰娜，一条年幼的雌龙，她与一个人类共居，从某种意义上，她的性格还是受到了那个人类的感染，最终是以一个人的行为，以一条龙的口吻去生活。只是大部分的事情都被那个人类做了，也就是她的『管家』。亚斯兰娜的家族谱系很远，但是她并未能写入自己家族的谱系当中，只是因为她的父母不愿意承认。流放，是他们想到的最好的选择，一个选择他们不会看到她的死亡。」
                """;
    }
}

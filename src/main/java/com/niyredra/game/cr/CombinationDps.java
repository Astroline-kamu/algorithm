/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 7/10/23, 11:20 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.game.cr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationDps {


    private static final List<Node> result = new ArrayList<>();
    private static final int target = 1772;

    public static void main(String[] args) {

        Map<String, Integer> skill = new HashMap<>() {{
            put("火球", 207);
            put("雪球", 58);
            put("万箭", 111);
            put("冰冻", 35);
            put("毒药", 224);
            put("火箭", 371);
            put("大电", 317);
            put("地震", 162);
        }};


        Node root = new Node();
        List<Node> nodeList = new ArrayList<>() {{
            add(root);
        }};
        loadNode(nodeList, skill);
        print(result);
    }

    static void print(List<Node> nodeList) {
        for (Node node :
                nodeList) {
            System.out.println(":::=======================================:::");
            Node n = node;
            StringBuilder name = new StringBuilder();
            StringBuilder dps = new StringBuilder();

            while (n.getParent() != null) {
                dps.append(n.getDps()).append(" + ");
                name.append(n.getName()).append(" + ");
//                System.out.println(n.getTotalDps());
//                System.out.println(n.getName() + " -> " + n.getDps());
                n = n.getParent();
            }
            dps.delete(dps.length() - 2, dps.length()).append("= ").append(target);
            name.delete(name.length() - 2, name.length());

            System.out.println(dps);
            System.out.println(name);
        }
    }

    static void loadNode(List<Node> nodeList, Map<String, Integer> skill) {

        System.out.println(nodeList.size());
        List<Node> next = new ArrayList<>();
        for (Node node :
                nodeList) {
            node.next(node, skill);

            if (node.getTotalDps() == target) {
                result.add(node);
                // todo 在一个无效节点完成之后清掉节点
                if (result.size() > 20) return;
            }
            if (node.getFireBall().getTotalDps() <= target)
                next.add(node.getFireBall());
            if (node.getSnowBall().getTotalDps() <= target)
                next.add(node.getSnowBall());
            if (node.getArrowRain().getTotalDps() <= target)
                next.add(node.getArrowRain());
            if (node.getFreeze().getTotalDps() <= target)
                next.add(node.getFreeze());
            if (node.getPoison().getTotalDps() <= target)
                next.add(node.getPoison());
            if (node.getRocket().getTotalDps() <= target)
                next.add(node.getRocket());
            if (node.getLightning().getTotalDps() <= target)
                next.add(node.getLightning());
            if (node.getQuake().getTotalDps() <= target)
                next.add(node.getQuake());
            System.out.println(next.size());
        }


        if (next.size() > 0) loadNode(next, skill);

    }


}


// todo 可以转变成一个Map
class Node {
    Node() {
        dps = 0;
    }

    Node(int dps) {
    }

    Node(Node pre, String name, int dps) {
        this.totalDps = pre.totalDps + dps;
        this.parent = pre;
        this.name = name;
        this.dps = dps;
    }

    void next(Node pre, Map<String, Integer> skill) {
        skill.forEach((k, v) -> {
            // 如果想把业务写到里面的话，就在后面再补充一个skill，然后switch中就要进行totalDps的判断了
            switch (k) {
                case "火球" -> fireBall = new Node(this, k, v);
                case "雪球" -> snowBall = new Node(this, k, v);
                case "万箭" -> arrowRain = new Node(this, k, v);
                case "冰冻" -> freeze = new Node(this, k, v);
                case "毒药" -> poison = new Node(this, k, v);
                case "火箭" -> rocket = new Node(this, k, v);
                case "大电" -> lightning = new Node(this, k, v);
                case "地震" -> quake = new Node(this, k, v);
                default -> System.out.println("未匹配的结果：" + k + " -> " + v);
            }
        });
    }

    private int dps;
    private int totalDps;
    private String name;
    private Node fireBall;
    private Node snowBall;
    private Node arrowRain;
    private Node freeze;
    private Node poison;
    private Node rocket;
    private Node lightning;
    private Node quake;

    private Node parent;

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public int getTotalDps() {
        return totalDps;
    }

    public void setTotalDps(int totalDps) {
        this.totalDps = totalDps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getFireBall() {
        return fireBall;
    }

    public void setFireBall(Node fireBall) {
        this.fireBall = fireBall;
    }

    public Node getSnowBall() {
        return snowBall;
    }

    public void setSnowBall(Node snowBall) {
        this.snowBall = snowBall;
    }

    public Node getArrowRain() {
        return arrowRain;
    }

    public void setArrowRain(Node arrowRain) {
        this.arrowRain = arrowRain;
    }

    public Node getFreeze() {
        return freeze;
    }

    public void setFreeze(Node freeze) {
        this.freeze = freeze;
    }

    public Node getPoison() {
        return poison;
    }

    public void setPoison(Node poison) {
        this.poison = poison;
    }

    public Node getRocket() {
        return rocket;
    }

    public void setRocket(Node rocket) {
        this.rocket = rocket;
    }

    public Node getLightning() {
        return lightning;
    }

    public void setLightning(Node lightning) {
        this.lightning = lightning;
    }

    public Node getQuake() {
        return quake;
    }

    public void setQuake(Node quake) {
        this.quake = quake;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}

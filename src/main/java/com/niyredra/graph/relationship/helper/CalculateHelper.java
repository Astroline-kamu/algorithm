/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 4/4/23, 8:30 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.graph.relationship.helper;

import com.niyredra.graph.relationship.model.Edge;
import com.niyredra.graph.relationship.model.Node;

import java.util.List;

public class CalculateHelper {

    private final static double kRepel = 200D;
    private final static double kAttract = .1;
    private final static double timeStep = .01;



    public static void calculateForce(List<Node> nodeList, List<Edge> edgeList) {
        // 赤痢 当距离越近，赤痢越大
        for (Node source :
                nodeList) {
            for (Node target :
                    nodeList) {
                if (source == target) continue;

                double dx = target.getX() - source.getX();
                double dy = target.getY() - source.getY();
                double distance = getDistance(dx, dy);
                if (distance > 0) {
                    double repel = kRepel / distance;
                    source.setVx(source.getVx() - repel * dx / distance);
                    source.setVy(source.getVy() - repel * dy / distance);
                }
            }
        }

        // 引力 当距离越远，宏彬越大
        for (Edge edge :
                edgeList) {
            Node source = edge.getSource();
            Node target = edge.getTarget();

            double dx = target.getX() - source.getX();
            double dy = target.getY() - source.getY();
            double distance = getDistance(dx, dy);
            if (distance > 0) {
                double attract = kAttract * distance;
                source.setVx(source.getVx() - attract * dx / distance);
                source.setVy(source.getVy() - attract * dy / distance);

                target.setVx(target.getVx() - attract * dx / distance);
                target.setVy(target.getVy() - attract * dy / distance);
            }
        }
    }

    public static void updatePosition(List<Node> nodeList, List<Edge> edgeList){
            calculateForce(nodeList, edgeList);
            nodeList.forEach(node -> {
                node.setX(node.getX() + node.getVx() * timeStep);
                node.setY(node.getY() + node.getVy() * timeStep);
            });
    }

    private static double getDistance(double x, double y){
        return getMod(x, y);
    }

    private static double getDistance(Node source, Node target){
        return getMod(source.getX() - target.getX(), source.getY() - target.getY());
    }

    private static double getMod(double x, double y) {
        return Math.pow(Math.pow(x, 2) + Math.pow(y, 2), .5);
    }

}

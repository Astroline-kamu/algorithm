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

import com.niyredra.graph.relationship.bo.NodeDistance;
import com.niyredra.graph.relationship.model.Edge;
import com.niyredra.graph.relationship.model.Node;

import java.util.List;

public class CalculateHelper {

    private final static double kRepel = 20D;
    private final static double kAttract = .01;
    private final static double timeStep = .1;

    public static void calculateForce(List<Node> nodeList, List<Edge> edgeList, int width, int height) {
        // 赤痢 当距离越近，赤痢越大
//        System.out.println("::: Separator :::");
        for (Node source :
                nodeList) {

            // 除非我可以优化成一次计算得到所有节点的速度信息，否则不考虑为每个节点添加四个边界节点的方法

            // todo 当在一定位置的时候 每个节点添加四个边界节点，用来进行反馈
            for (Node target :
                    nodeList) {
                if (source == target) continue;

                NodeDistance distance = new NodeDistance();
                setDistanceData(distance, source, target);

//                System.out.println("dx - " + dx + " | dy - " + dy + " | distance - " + distance);
//                System.out.println("vx - " + source.getVx() + " | vy - " + source.getVy());
                if (distance.getDistance() > 0) {
                    setVelocity(source, distance);

                    // 收敛边界 mark 这里可能需要source.x - source.vx来预先计算出距离
                    // todo 添加节点大小信息 根据大小来收敛
                    if (source.getX() > width - 20) {
                        setDistanceData(distance, source, new Node(source.getX() + 20, source.getY()));
                    } else if (source.getX() < 20) {
                        setDistanceData(distance, source, new Node(source.getX() - 20, source.getY()));
                    }
                    setVelocity(source, distance);

                    if (source.getY() > height - 20) {
                        setDistanceData(distance, source, new Node(source.getX(), source.getY() + 20));
                    } else if (source.getY() < 20) {
                        setDistanceData(distance, source, new Node(source.getX(), source.getY() - 20));
                    }
                    setVelocity(source, distance);
                }

            }
        }

        // 引力 当距离越远，宏彬越大
        for (Edge edge :
                edgeList) {
            Node source = edge.getSource();
            Node target = edge.getTarget();

            NodeDistance distance = new NodeDistance();
            setDistanceData(distance, source, target);

            if (distance.getDistance() > 0) {
                double attract = kAttract * distance.getDistance();
                source.setVx(source.getVx() + attract * distance.getDx() / distance.getDistance());
                source.setVy(source.getVy() + attract * distance.getDy() / distance.getDistance());

                target.setVx(target.getVx() - attract * distance.getDx() / distance.getDistance());
                target.setVy(target.getVy() - attract * distance.getDy() / distance.getDistance());
            }
        }
    }

    public static void updatePosition(List<Node> nodeList, List<Edge> edgeList, int width, int height) {
        calculateForce(nodeList, edgeList, width, height);
        nodeList.forEach(node -> {
            node.setX(node.getX() + node.getVx() * timeStep);
            node.setY(node.getY() + node.getVy() * timeStep);


            // 收敛运动速度
            if (node.getVx() > 0) node.setVx(node.getVx() * .9);
            if (node.getVy() > 0) node.setVy(node.getVy() * .9);

            if (node.getVx() < 0) node.setVx(node.getVx() * .9);
            if (node.getVy() < 0) node.setVy(node.getVy() * .9);
        });
    }

    private static void setVelocity(Node node, NodeDistance distance) {
        // kRepel / distance 求距离缩放后的排斥力
        // dx / distance 求出x轴上的速度分量
        double repel = kRepel / distance.getDistance();
        node.setVx(node.getVx() - repel * distance.getDx() / distance.getDistance());
        node.setVy(node.getVy() - repel * distance.getDy() / distance.getDistance());

    }

    /**
     * @param distance 距离
     * @param source   源 赤痢方向
     * @param target   目标节点
     */
    private static void setDistanceData(NodeDistance distance, Node source, Node target) {
        distance.setDx(target.getX() - source.getX());
        distance.setDy(target.getY() - source.getY());
        distance.setDistance(getDistance(distance.getDx(), distance.getDy()));
    }

    private static double getDistance(double x, double y) {
        return getMod(x, y);
    }

    private static double getDistance(Node source, Node target) {
        return getMod(source.getX() - target.getX(), source.getY() - target.getY());
    }

    private static double getMod(double x, double y) {
        return Math.pow(Math.pow(x, 2) + Math.pow(y, 2), .5);
    }

}

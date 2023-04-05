/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 4/4/23, 8:29 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.graph.relationship;

import com.niyredra.graph.relationship.bo.StructReturnValue;
import com.niyredra.graph.relationship.helper.CalculateHelper;
import com.niyredra.graph.relationship.struct.RelationshipStruct;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RelationshipGraph {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Circle Example");

        frame.add(new Animation());

        frame.setSize(1280, 960);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Animation extends JPanel {

    StructReturnValue value = RelationshipStruct.getRelationshipStruct();

    Animation() {
        new Timer(10, e -> {
            CalculateHelper.updatePosition(
                    this.value.getNodeList(),
                    this.value.getEdgeList(),
                    1280, 960
            );
            repaint();
        }).start();
    }

    @SneakyThrows
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int pos = 500;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.setBackground(Color.DARK_GRAY);

        value.getNodeList().forEach(node -> {
//            Node source = edge.getSource();
//            Node target = edge.getTarget();

//            Ellipse2D.Double circle = ;
            g2d.draw(new Ellipse2D.Double(pos + node.getX(), pos + node.getY(), 15, 15));
//            g2d.draw(new Ellipse2D.Double(pos + node.getX(), pos + node.getY(), 15, 15));
        });

    }
}
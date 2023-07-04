/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 5/23/23, 10:16 AM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package src.main.java.org.gaming.air.defends;

import lombok.Data;
import lombok.SneakyThrows;
import src.main.java.org.gaming.air.defends.model.Tower;
import src.main.java.org.gaming.air.defends.model.data.GamingData;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;


public class Sense extends JPanel  {

    private final int width = 1280;
    private final int height = 960;


    @Data
    static class Position{
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        private int x;
        private int y;
    }

    public final List<Position> positionList = new ArrayList<>();



    Sense() {
        new Timer(10, e -> {
            // 进行子弹发射等操作

            repaint();
        }).start();
    }


    // 创建炮台
    // 弹药数量
    // 换弹时间
    // 一轮射速
    // 子弹生成
    // 子弹体积缩小

    // 导弹生成（类型为子弹的一种）
    // 动画





    @SneakyThrows
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        final double padding = 20;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.setBackground(Color.DARK_GRAY);

        java.util.List<Tower> towerList = new GamingData().getTowerList();
        towerList.forEach(tower -> g2d.draw(
                new Rectangle2D.Double(padding + tower.x() ,   tower.y() + height - tower.height(), tower.width(), tower.height())
        ));

        final int[] size = {80};
        positionList.forEach(position ->  g2d.draw(
                new Arc2D.Double(position.getX(), position.getY(), size[0], size[0],
                        0, 360, Arc2D.CHORD
                )
        ));



    }
//    @Override
//    public Dimension getPreferredSize() {
//        // 获取父级组件的宽高
//        Container parent = getParent();
//        int width = parent.getWidth();
//        int height = parent.getHeight();
//        // 返回父级组件的宽高作为自己的首选大小
//        return new Dimension(width, height);
//    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//
////
////        g2d.draw(
////                new Rectangle2D.Double(e.getX() ,   e.getY() , size[0], size[0]
////                ));
////
//
////                new Thread(() -> {
////                    System.out.println("click!");
////                    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
////                            executor.scheduleWithFixedDelay(() -> {
////                                if (size[0]-- > 0) executor.shutdown();
////                            }, 0, 100, TimeUnit.MILLISECONDS);
////
////                }).start();
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
}

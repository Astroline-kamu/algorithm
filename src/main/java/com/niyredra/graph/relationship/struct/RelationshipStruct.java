/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 4/5/23, 12:12 PM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package com.niyredra.graph.relationship.struct;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.niyredra.common.constant.ConstantPath;
import com.niyredra.graph.relationship.bo.StructReturnValue;
import com.niyredra.graph.relationship.model.Edge;
import com.niyredra.graph.relationship.model.Member;
import com.niyredra.graph.relationship.model.Node;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class RelationshipStruct {
    @SneakyThrows
    public static StructReturnValue getRelationshipStruct() {
        List<Member> memberList;
        List<Edge> edgeList = new ArrayList<>();
        Map<String, Node> nodeMap = new HashMap<>();
        try (
                FileInputStream fileInputStream =
                        new FileInputStream(ConstantPath.graphRelationshipPath + "MemberRelationship.json")) {
            memberList = List.of(JSON.parseObject(
                    fileInputStream.readAllBytes(),
                    TypeReference.arrayType(Member.class)
            ));
        }

        double margin = 20;
        AtomicReference<Double> y = new AtomicReference<>((double) 0);

        // todo 写一个去重 为什么不现在写，因为我想看看一个包含重复数据的图是什么样子的qwq
        // 预测结果：MemberRelationship变成了三个群组，每个群组有多个点连线
        memberList.forEach(member -> {

            AtomicReference<Double> x = new AtomicReference<>((double) 0);
            y.set(y.get() + margin);

            Node node = new Node();
            node.setX(x.get());
            node.setY(y.get());

            nodeMap.putIfAbsent(member.getName(), node);
            for (String name : member.getRelationship()) {
                x.set(x.get() + margin);

                Node shipNode = new Node();
                Edge shipEdge = new Edge();

                shipNode.setX(x.get());
                shipNode.setY(y.get());
                shipEdge.setSource(node);
                shipEdge.setTarget(shipNode);

                edgeList.add(shipEdge);
                nodeMap.putIfAbsent(name, shipNode);
            }
        });

        return new StructReturnValue(nodeMap.values().stream().toList(), edgeList);
    }
}
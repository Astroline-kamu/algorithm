package com.niyredra.TextSearch.src;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 5, 6);
        System.out.println("第1个");
        //mapMulti产生额外的一个SpinedBuffer对象
        System.out.println(list.stream()
                .mapMulti((integer, consumer) -> consumer.accept(List.of(integer)))
                        .collect(Collectors.toList()));

    }


}


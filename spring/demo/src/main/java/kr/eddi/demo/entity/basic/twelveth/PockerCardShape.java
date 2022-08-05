package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

@Getter
public enum PockerCardShape {
    SPADE("스페이드", 1),
    DIAMOND("다이아몬드", 2),
    HEART("하트", 3),
    CLOVER("클로버", 4);

    private final String name;
    private final int value;

    private PockerCardShape(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

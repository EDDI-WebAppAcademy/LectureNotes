package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

@Getter
public enum PockerCardCharacter {
    KING("K", 13),
    QUEEN("Q", 12),
    JACK("J", 11),
    TEN("10", 10),
    NINE("9", 9),
    EIGHT("8", 8),
    SEVEN("7", 7),
    SIX("6", 6),
    FIVE("5", 5),
    FOUR("4", 4),
    THREE("3", 3),
    TWO("2", 2),
    ACE("1", 1);

    private final String name;
    private final int value;

    private PockerCardCharacter(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

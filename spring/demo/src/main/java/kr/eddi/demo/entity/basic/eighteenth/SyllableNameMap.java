package kr.eddi.demo.entity.basic.eighteenth;

import lombok.Getter;

@Getter
public enum SyllableNameMap {
    Do("도", 1),
    Re("레", 2),
    Mi("미", 3),
    Fa("파", 4),
    Sol("솔", 5),
    Ra("라", 6),
    Si("시", 7);

    private String name;
    private int value;

    private SyllableNameMap(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

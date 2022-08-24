package kr.eddi.demo.entity.basic.eighteenth;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Fruit {
    private Map<String, Object> fruits;

    public Fruit() {
        fruits = new HashMap<>();

        fruits.put("사과", new Apple());
        fruits.put("포도", new Grape());
        fruits.put("바나나", new Banana());
    }
}

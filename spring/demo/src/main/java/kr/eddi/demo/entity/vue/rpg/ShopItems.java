package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;

@Getter
public class ShopItems {
    private String name;
    private Integer price;
    private String description;
    private Integer atk;
    private String recover;

    public ShopItems (String name, Integer price, String description, Integer atk) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.atk = atk;
    }

    public ShopItems (String name, Integer price, String description, String recover) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.recover = recover;
    }
}

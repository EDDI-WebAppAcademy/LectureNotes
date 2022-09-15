package kr.eddi.demo.entity.vue.rpg;

import lombok.*;

@ToString
@Getter
@Setter
public class CharacterStatus {
    private Integer level;
    private Integer hp;
    private Integer mp;
    private Integer itemAtk;
    private Integer defaultAtk;
    private Integer atk;
    private Integer str;
    private Integer intelligence;
    private Integer dex;
    private Integer vit;
    private Integer def;
    private Integer men;
    private Integer totalLevelBar;
    private Integer currentLevelBar;
    private Integer money;
    private String currentJob;

    private final Integer INIT_LEVEL = 1;
    private final Integer INIT_HP = 50;
    private final Integer INIT_MP = 30;
    private final Integer INIT_ITEM_ATK = 0;
    private final Integer INIT_DEFAULT_ATK = 10;
    private final Integer INIT_ATK = 10;
    private final Integer INIT_STR = 10;
    private final Integer INIT_INT = 10;
    private final Integer INIT_DEX = 10;
    private final Integer INIT_VIT = 10;
    private final Integer INIT_DEF = 10;
    private final Integer INIT_MEN = 10;
    private final Integer INIT_TOTAL_LEVEL_BAR = 10;
    private final Integer INIT_CURRENT_LEVEL_BAR = 0;
    private final Integer INIT_MONEY = 0;
    private final String INIT_CURRENT_JOB = "모험가";

    public CharacterStatus () {
        level = INIT_LEVEL;
        hp = INIT_HP;
        mp = INIT_MP;
        itemAtk = INIT_ITEM_ATK;
        defaultAtk = INIT_DEFAULT_ATK;
        atk = INIT_ATK;
        str = INIT_STR;
        intelligence = INIT_INT;
        dex = INIT_DEX;
        vit = INIT_VIT;
        def = INIT_DEF;
        men = INIT_MEN;
        totalLevelBar = INIT_TOTAL_LEVEL_BAR;
        currentLevelBar = INIT_CURRENT_LEVEL_BAR;
        money = INIT_MONEY;
        currentJob = INIT_CURRENT_JOB;
    }

    public CharacterStatus (CharacterStatus characterStatus) {
        level = characterStatus.level;
        hp = characterStatus.hp;
        mp = characterStatus.mp;
        itemAtk = characterStatus.itemAtk;
        defaultAtk = characterStatus.defaultAtk;
        atk = characterStatus.atk;
        str = characterStatus.str;
        intelligence = characterStatus.intelligence;
        dex = characterStatus.dex;
        vit = characterStatus.vit;
        def = characterStatus.def;
        men = characterStatus.men;
        totalLevelBar = characterStatus.totalLevelBar;
        currentLevelBar = characterStatus.currentLevelBar;
        money = characterStatus.money;
        currentJob = characterStatus.currentJob;
    }
}

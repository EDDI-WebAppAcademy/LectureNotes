package kr.eddi.demo.entity.vue.rpg;

import kr.eddi.demo.controller.vue.rpg.thirtyoneth.RpgCharacterController;
import kr.eddi.demo.controller.vue.rpg.thirtyoneth.RpgExperienceExchangeController;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class ExperienceExchange {
    // "hp", "mp", "atk", "str", "dex", "int", "def"
    private Integer incrementedHp;
    private Integer incrementedMp;
    private Integer incrementedAtk;
    private Integer incrementedStr;
    private Integer incrementedDex;
    private Integer incrementedInt;
    private Integer incrementedDef;

    private final int HP = 0;
    private final int MP = 1;
    private final int ATK = 2;
    private final int STR = 3;
    private final int DEX = 4;
    private final int INT = 5;
    private final int DEF = 6;
    private final int INCREMENT_FACTOR = 5;

    public Boolean exchangeExperience (ArrayList<Integer> selectedLists) {
        System.out.println("여기서 경험치 교환 가능 여부 판정");
        CharacterStatus currentCharacterStatus = new CharacterStatus(RpgCharacterController.characterStatus);

        for (int i = 0; i < selectedLists.size(); i++) {
            switch (selectedLists.get(i)) {
                case HP:
                    RpgCharacterController.characterStatus.setHp(
                            currentCharacterStatus.getHp() + INCREMENT_FACTOR);
                    break;
                    
                case MP:
                    RpgCharacterController.characterStatus.setMp(
                            currentCharacterStatus.getMp() + INCREMENT_FACTOR);
                    break;
                    
                case ATK:
                    RpgCharacterController.characterStatus.setAtk(
                            currentCharacterStatus.getAtk() + INCREMENT_FACTOR);
                    break;
                    
                case STR:
                    RpgCharacterController.characterStatus.setStr(
                            currentCharacterStatus.getStr() + INCREMENT_FACTOR);
                    break;
                    
                case DEX:
                    RpgCharacterController.characterStatus.setDex(
                            currentCharacterStatus.getDex() + INCREMENT_FACTOR);
                    break;
                    
                case INT:
                    RpgCharacterController.characterStatus.setIntelligence(
                            currentCharacterStatus.getIntelligence() + INCREMENT_FACTOR);
                    break;
                    
                case DEF:
                    RpgCharacterController.characterStatus.setDef(
                            currentCharacterStatus.getDef() + INCREMENT_FACTOR);
                    break;
                    
                default:
                    System.out.println("잘못된 요청");
            }
        }

        return true;
    }
}

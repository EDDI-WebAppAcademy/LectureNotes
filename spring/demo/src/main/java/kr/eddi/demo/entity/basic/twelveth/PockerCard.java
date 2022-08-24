package kr.eddi.demo.entity.basic.twelveth;

import lombok.ToString;
import org.apache.tomcat.util.digester.ArrayStack;

import java.util.*;

@ToString
public class PockerCard {
    // 1. 카드 문양(CardShape): 스페이드, 다이아, 하트, 클로버
    // 2. 카드 문자(CardCharacter): K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, ACE
    private Map<Integer, Map<PockerCardShape, PockerCardCharacter>> cards;
    private Map<PockerCardShape, PockerCardCharacter> cardValues;
    private int currentCardIdx;

    public PockerCard() {
        int cnt = 0;
        currentCardIdx = 0;

        cards = new LinkedHashMap<>();

        // 한 개 뽑힌 결과 <- 뽑을 리스트들
        // foreach(한 개 뽑힌 결과: 뽑을 리스트들) 형태로 사용함
        // >>> 이중 해쉬로 변경 필요 <<<
        // key: 0, value: <Shape, Character> <<<---
        // 안 된다고 우왕좌왕하면서 이것 저것 시도해보는 것 보다
        // 안되는 원인을 파악하고 이에 대한 해결 전략을 구성하는것이 중요합니다.

        for (PockerCardShape pockerCardShape: PockerCardShape.values()) {
            for (PockerCardCharacter pockerCardCharacter : PockerCardCharacter.values()) {
                cardValues = new LinkedHashMap<>();
                cardValues.put(pockerCardShape, pockerCardCharacter);

                cards.put(cnt++, cardValues);
            }
        }

        System.out.println("Card: " + cards);
    }

    public void shuffle() {
        List keys = new ArrayList(cards.keySet());
        Collections.shuffle(keys);

        // ... 바보짓 했음 -> LinkedHashMap() 이것을 써야 순서가 보장됨
        Map<Integer, Map<PockerCardShape, PockerCardCharacter>> cardsBackup = new LinkedHashMap<>();

        for (Object object: keys) {
            cardsBackup.put((Integer)object, cards.get(object));
        }

        cards = cardsBackup;
    }

    // 현재 문제: List는 계속 정렬을 수행하고 있음.
    //          LinkedHashMap에 의해 순서가 보장된 정보가 List에 의해 다시 재정렬 되어 문제가 발생함.
    public Map<PockerCardShape, PockerCardCharacter> divideCard() {
        Map<PockerCardShape, PockerCardCharacter> dividedPlayerDeck;

        Map.Entry<Integer, Map<PockerCardShape, PockerCardCharacter>> entry = cards.entrySet().iterator().next();
        dividedPlayerDeck = entry.getValue();

        //System.out.println("dividedPlayerDeck: " + dividedPlayerDeck);

        Integer key = entry.getKey();
        System.out.println("key: " + key);
        cards.remove(key);

        return dividedPlayerDeck;
    }
}

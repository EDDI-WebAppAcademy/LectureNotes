package kr.eddi.demo.entity.basic.twelveth;

import java.util.HashMap;
import java.util.Map;

public class PockerCard {
    // 1. 카드 문양(CardShape): 스페이드, 다이아, 하트, 클로버
    // 2. 카드 문자(CardCharacter): K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, ACE
    private Map<PockerCardShape, PockerCardCharacter> cards;

    public PockerCard() {
        cards = new HashMap<>();

        // 한 개 뽑힌 결과 <- 뽑을 리스트들
        // foreach(한 개 뽑힌 결과: 뽑을 리스트들) 형태로 사용함
        // >>> 이중 해쉬로 변경 필요 <<<
        for (PockerCardShape pockerCardShape: PockerCardShape.values()) {
            for (PockerCardCharacter pockerCardCharacter: PockerCardCharacter.values()) {
                cards.put(pockerCardShape, pockerCardCharacter);
            }
        }
    }
}

package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class PlayerManager {
    private int playerNum;
    private PockerCard pockerCard;
    private List<Player> playerList;
    
    // 어떤 사용자가 어떤 손패를 가지고 있는지 관리가 필요함
    // <사용자, 공개한 리스트>
    // 루프를 반복하게 되면 공개한 리스트에 정보를 추가하도록 구성해야함
    private Map<Player, List<Map<PockerCardShape, PockerCardCharacter>>> playerPubishingDeck;

    public PlayerManager(int playerNum) {
        this.playerNum = playerNum;
        playerList = new ArrayList<>();

        for (int i = 0; i < playerNum; i++) {
            playerList.add(new Player());
        }

        pockerCard = new PockerCard();
        pockerCard.shuffle();

        playerPubishingDeck = new HashMap<>();
    }

    public void playPockerGame(int currentRound) {
        for (int i = 0; i < playerNum; i++) {
            // 4. 참여 순서대로 플레이어들에게 패를 돌린다. -> 카드 생성
            // 8. 추가패를 받는다.
            // 실제로 이 부분은 4번 8번이 함께 동작하므로 일관성을 유지하기 위해 별도의 함수를 배치하는 것이 좋아보임
            acquireNewCards(i, currentRound);

            System.out.println(playerList.get(i));

            // 현재 플레이어가 가지고 있는 손 패를 모두 보여주고 있음.
            // 앞서 만들었던 유틸리티를 활용해 공개할 정보만 관리하도록 함.

            //playerList.get(i).acquireNewCards(pockerCard.divideCard());
            // 5. 플레이어들은 공개할 패를 선택한다.
            //List<Map<PockerCardShape, PockerCardCharacter>> newPlayerPublishingDeckList = new ArrayList<>();
            //newPlayerPublishingDeckList.add(playerList.get(i).publishingPlayersCard());
            // 기존 해쉬맵에서 밸류값인 리스트를 가져와서 해당 값에 내용을 추가하고 다시 put해서 넣어야함.
            //List<Map<PockerCardShape, PockerCardCharacter>> existingPlayerPublishingDeckList;

            /*
            if (playerPubishingDeck.get(playerList.get(i)) == null) {
                existingPlayerPublishingDeckList = newPlayerPublishingDeckList;
            } else {
                existingPlayerPublishingDeckList = playerPubishingDeck.get(playerList.get(i));
                int existingDeckSize = existingPlayerPublishingDeckList.size();

                existingPlayerPublishingDeckList.add(newPlayerPublishingDeckList.get(0));
            }

            playerPubishingDeck.put(playerList.get(i), existingPlayerPublishingDeckList);

             */


            // 7. 가장 높은 패에게 턴 우선권을 제공한다.
            //    compareTo를 활용해서 비교를 하도록 구성해야함
            //    또한 실제 숫자는 ACE, 2 ~ 10, J, Q, K 로 13개씩 구성됨
            //    페어, 트리플, 포카드는 shape을 비교해야함
            //    하이카드는 문양과 숫자가 높은넘
            //    스트레이트, 플러쉬 등등의 케이스를 어떻게 판정할지에 대한 전략이 필요함.
            //    7-1. 정렬을 통해서 숫자들을 배치해야함
            //    7-2. 내용을 이동하면서 숫자가 순차적이지 않으면 스트레이트 x 순차적으로 5개가 배치되면 스트레이트
            //    7-3. 문양이 같은지 판별해서 스트레이트 플러쉬를 감지
            //    7-4. 위 조건을 만족하면서 10, J, Q, K, A로 연속적 배치가 되어 있다면 로열 플러쉬
            //    이제 나머지는 사실상 그냥 문양만 보거나 숫자만 확인하면 되서 어렵지 않음.
            //    풀하우스 - 같은 숫자 3 + 같은 숫자 2
            //    여기 파트에서 7-1 ~ 7-4 파트가 마지막 고비임.

            // 9. 베팅 머니 추가
        }

        //System.out.println(playerPubishingDeck);
    }

    public void acquireNewCards(int playerIdx, int currentRound) {
        if (currentRound == 0) {
            for (int i = 0; i < 3; i++) {
                playerList.get(playerIdx).acquireNewCards(pockerCard.divideCard());
            }
        } else {
            playerList.get(playerIdx).acquireNewCards(pockerCard.divideCard());
        }
    }
}

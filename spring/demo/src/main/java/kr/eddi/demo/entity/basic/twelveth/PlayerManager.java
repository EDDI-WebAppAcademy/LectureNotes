package kr.eddi.demo.entity.basic.twelveth;

import kr.eddi.demo.utility.basic.nineth.Score;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

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
            // 실제로 추가패를 받는 작업과 공개할 패를 받는 작업의 연관성이 존재함
            // 좋은 케이스: 여러 기능을 한 곳에서 처리하려고 하다보니 중복 코드가 발생하게 되었음
            //           작은 기능을 개발할 때는 크게 문제가 되지 않지만
            //           기능이 커질수록 분리를 안하는 경우 아래와 같이 중복 코드를 작성하게 됨.
            acquireNewCards(i, currentRound);

            // 5. 플레이어들은 공개할 패를 선택한다.
            publishingPlayerCard(i, currentRound);


            // 9. 베팅 머니 추가
        }

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
        checkPlayersPriority();

        //System.out.println(playerPubishingDeck);
    }

    public void checkPlayersPriority() {
        // 이 부분은 결국 공개패를 봐야하는 부분임. -> 공개패: playerPubishingDeck (Map)
        //                                 -> mapPlayerPublishingDeck이였으면 더 좋았음.
        // 초기에 playerPublishingDeck을 클래스화 하여 작업했으면
        // compareTo(), compare() 등을 사용함에 문제가 없었겠지만
        // 귀차니즘 때문에 이렇게 만들게 되어 직접 프로그램을 작성해야함
        for (int i = 0; i < playerNum; i++) {
            //System.out.println("사용자 공개패: " + playerPubishingDeck.get(playerList.get(i)));
            // 페어, 트리플, 포카드는 감지함.
            List<Map<PockerCardShape, PockerCardCharacter>> sameCardCharacters;
            sameCardCharacters = findSameCardCharacters(i);
            System.out.println(sameCardCharacters);
        }
    }

    // 실제로 상대편과 겨룰때 같은 페어가 숫자 차이, 문양 차이가 존재할 수 있음.
    // 그러므로 실제 리턴값은 [문양, 숫자, 개수] 형태의 List가 되어야함.
    // [스페이드, 3], [클로버, 3], 2 이러한 형태로 구성되어있음.
    // 그렇다면 실제로 이것을 리턴하기 위해선 ???
    // 결국 [스페이드, 3], [클로버, 3] 을 리턴하고 몇 개인지 정보는 리스트의 크기로 판정한다.
    // 실제로 스트레이트, 풀하우스, 로열플러쉬는 5개가 만들어지기 때문에
    // 모든 케이스를 려한다면 별도의 enum 태그가 필요함 SAME_SIZE_DECISION 같은 형태
    // ex) [스페이드, 3], [클로버, 3], [PockerCardPattern.TWO_PAIR, PockerCardPattern.TWO_PAIR]
    public List<Map<PockerCardShape, PockerCardCharacter>> findSameCardCharacters(int playerIdx) {
        int sameCharacterCnt = 0;
        List<Map<PockerCardShape, PockerCardCharacter>> publishingCards;
        publishingCards = playerPubishingDeck.get(playerList.get(playerIdx));

        List<Map<PockerCardShape, PockerCardCharacter>> sameCardCharacterList = new ArrayList<>();

        int publishingDeckSize = playerPubishingDeck.get(playerList.get(playerIdx)).size();

        for (int currentCardIdx = 0; currentCardIdx < publishingDeckSize; currentCardIdx++) {
            Map<PockerCardShape, PockerCardCharacter> currentCard = publishingCards.get(currentCardIdx);
            Map.Entry<PockerCardShape, PockerCardCharacter> currentCardEntry = currentCard.entrySet().iterator().next();
            PockerCardCharacter currentCardCharacter = currentCardEntry.getValue();

            for (int otherCardIdx = 0; otherCardIdx < publishingDeckSize; otherCardIdx++) {
                if (currentCardIdx == otherCardIdx) { continue; }

                Map<PockerCardShape, PockerCardCharacter> otherCard = publishingCards.get(otherCardIdx);
                Map.Entry<PockerCardShape, PockerCardCharacter> otherCardEntry = otherCard.entrySet().iterator().next();
                PockerCardCharacter otherCardCharacter = otherCardEntry.getValue();

                if (currentCardCharacter.equals(otherCardCharacter)) {
                    //System.out.println("currentCardCharacter: " + currentCardCharacter);
                    //System.out.println("otherCardCharacter: " + otherCardCharacter);
                    // [스페이드, 3], [클로버, 3], [PockerCardPattern.TWO_PAIR, PockerCardPattern.TWO_PAIR]
                    sameCardCharacterList.add(publishingCards.get(otherCardIdx));
                }
            }
        }

        return sameCardCharacterList;
    }

    public void publishingPlayerCard(int playerIdx, int currentRound) {
        if (currentRound == 0) {
            List<Map<PockerCardShape, PockerCardCharacter>> newPlayerPublishingDeckList = new ArrayList<>();
            newPlayerPublishingDeckList.add(playerList.get(playerIdx).publishingPlayersCard());

            // 기존 해쉬맵에서 밸류값인 리스트를 가져와서 해당 값에 내용을 추가하고 다시 put해서 넣어야함.
            List<Map<PockerCardShape, PockerCardCharacter>> existingPlayerPublishingDeckList;

            if (playerPubishingDeck.get(playerList.get(playerIdx)) == null) {
                existingPlayerPublishingDeckList = newPlayerPublishingDeckList;
            } else {
                existingPlayerPublishingDeckList = playerPubishingDeck.get(playerList.get(playerIdx));
                int existingDeckSize = existingPlayerPublishingDeckList.size();

                existingPlayerPublishingDeckList.add(newPlayerPublishingDeckList.get(0));
            }

            playerPubishingDeck.put(playerList.get(playerIdx), existingPlayerPublishingDeckList);
        }
    }

    public void acquireNewCards(int playerIdx, int currentRound) {
        if (currentRound == 0) {
            for (int i = 0; i < 3; i++) {
                playerList.get(playerIdx).acquireNewCards(pockerCard.divideCard());
            }
        } else {
            List<Map<PockerCardShape, PockerCardCharacter>> existingPlayerPublishingDeckList;
            List<Map<PockerCardShape, PockerCardCharacter>> newPlayerPublishingDeckList = new ArrayList<>();
            newPlayerPublishingDeckList.add(pockerCard.divideCard());

            playerList.get(playerIdx).acquireNewCards(newPlayerPublishingDeckList.get(0));

            if (playerPubishingDeck.get(playerList.get(playerIdx)) == null) {
                existingPlayerPublishingDeckList = newPlayerPublishingDeckList;
            } else {
                existingPlayerPublishingDeckList = playerPubishingDeck.get(playerList.get(playerIdx));
                int existingDeckSize = existingPlayerPublishingDeckList.size();

                existingPlayerPublishingDeckList.add(newPlayerPublishingDeckList.get(0));
            }

            playerPubishingDeck.put(playerList.get(playerIdx), existingPlayerPublishingDeckList);
        }
    }
}

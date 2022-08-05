package kr.eddi.demo.entity.basic.twelveth;

public class RoundManager {

    private PockerCard pockerCards;
    private int currentRound;

    public RoundManager() {
        currentRound = 0;
    }
    
    // 4. 참여 순서대로 플레이어들에게 패를 돌린다. -> 카드 생성
    // 5. 플레이어들은 공개할 패를 선택한다.
    // 6. 라운드를 시작한다.
    // 7. 가장 높은 패에게 턴 우선권을 제공한다.
    // 8. 추가패를 받는다.
    // 9. 베팅 머니 추가
    // 10. 6 ~ 9번이 반복된다 -> 추가패를 4번 받을때까지
    public void playGame(PlayerManager playerManager) {
        
    }
}

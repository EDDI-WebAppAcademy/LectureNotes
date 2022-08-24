package kr.eddi.demo.entity.basic.twelveth;

import kr.eddi.demo.utility.basic.twelveth.BettingMoneyManager;
import lombok.Setter;

import java.util.ArrayList;

// 기능 위주(하향식 설계)로 가게 되면 머리만 아프고 결과는 제대로 안나올 가능성이 높음.
// 초보일때는 일단 기능을 먼저 구현해야 되서 하향식 설계를 위주로 하게 된다는 것.
// 결국 유저 스토리 기반의 백로그를 바라봐야 컴포넌트를 볼 수 있어야
// 상향식 설계가 가능해집니다.
@Setter
public class PockerGameManager {
    private PlayerManager playerManager;
    private RoundManager roundManager;

    private final int DEFAULT_BETTING_MONEY = 1000000;

    public PockerGameManager(int playerNum) {
        playerManager = new PlayerManager(playerNum);
        roundManager = new RoundManager();
    }

    public void startGame() {
        // 3. 초기 베팅 머니를 부과한다.
        BettingMoneyManager.betMoney(DEFAULT_BETTING_MONEY * playerManager.getPlayerNum());

        // 4. 참여 순서대로 플레이어들에게 패를 돌린다.
        // 5. 플레이어들은 공개할 패를 선택한다.
        // 6. 라운드를 시작한다.
        // 7. 가장 높은 패에게 턴 우선권을 제공한다.
        // 8. 추가패를 받는다.
        // 9. 베팅 머니 추가
        do {
            roundManager.playPockerGame(playerManager);
        } while (isGameFinish());
        // 10. 6 ~ 9번이 반복된다 -> 추가패를 4번 받을때까지
    }

    // 11. 최종 승자 판정
    public Player dicisionWinner() {
        return new Player();
    }

    public Boolean isGameFinish() {
        if (roundManager.getCurrentRound() == 5) { return false; }

        return true;
    }
}

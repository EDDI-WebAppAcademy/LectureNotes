package kr.eddi.demo.controller.basic.sixth;

import kr.eddi.demo.entity.basic.sixth.clean.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sixth-clean")
public class SixthCleanDiceGameController {

    private final int DEFAULT_PLAYER_NUM = 2;
    private Player[] players;
    private int playerNum;

    @GetMapping("/dice-game-starter")
    public String diceGameStarter() {

        createPlayer();
        gameStart();

        return "고고싱";
    }

    public void createPlayer() {
        players = new Player[DEFAULT_PLAYER_NUM];
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayer(int playerNum) {
        players = new Player[playerNum];
        this.playerNum = playerNum;

        createPlayerObj(players, playerNum);
    }

    public void createPlayerObj(Player player[], int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            player[i] = new Player();
        }
    }

    // 사용자가 게임을 시작해서
    // 주사위를 굴리고
    // 굴린 주사위가 짝수라면
    // 앞서 만든 유틸리티 사용하고
    // 유틸리티를 사용해서 각 플레이어들에게 옵션 적용
    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            //players[i].gameStart();
        }
    }
    
    // 최종 승자 판정
    public void checkWinner() {
        
    }
}

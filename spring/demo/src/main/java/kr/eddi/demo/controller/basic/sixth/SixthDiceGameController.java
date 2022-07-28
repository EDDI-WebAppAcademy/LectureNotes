package kr.eddi.demo.controller.basic.sixth;


import kr.eddi.demo.entity.basic.sixth.dirty.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sixth")
public class SixthDiceGameController {
    private final int DEFAULT_PLAYER_NUM = 2;
    private Player[] player;

    @GetMapping("/dice-game")
    public String startDiceGame() {
        log.info("주사위 게임 시작!");

        makePlayer();
        playGame();
        return checkWinner();
    }

    public void makePlayer() {
        player = new Player[DEFAULT_PLAYER_NUM];

        for (int i = 0; i < DEFAULT_PLAYER_NUM; i++) {
            player[i] = new Player();
        }
    }

    public void playGame() {
        log.info("게임을 시작합니다!");

        for (int i = 0; i < DEFAULT_PLAYER_NUM; i++) {
            player[i].getDice().rollDice();
        }
    }

    public String checkWinner() {
        int[] score = new int[DEFAULT_PLAYER_NUM];

        for (int i = 0; i < DEFAULT_PLAYER_NUM; i++) {
            score[i] = player[i].getDice().getScore().getTotalScore();
        }
        
        if (score[0] > score[1]) {
            return "플레이어 1 승리";
        } else if (score[0] < score[1]) {
            return "플레이어 2 승리";
        } else {
            return "무승부";
        }
    }
}

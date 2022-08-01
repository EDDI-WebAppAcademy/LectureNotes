package kr.eddi.demo.controller.basic.nineth;

import kr.eddi.demo.entity.basic.nineth.LottoCardManager;
import kr.eddi.demo.entity.basic.nineth.Player;
import kr.eddi.demo.utility.basic.nineth.Score;
import kr.eddi.demo.entity.basic.nineth.WinnerManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nineth")
public class NinethLottoGameController {

    private List<Player> players;
    private LottoCardManager lottoManager;
    private final int MAX_PLAYER = 100;
    private Score scoreManager;
    private WinnerManager winnerManager;

    @GetMapping("/lotto-game")
    public String lottoGame() {
        log.info("lottoGame()");

        allocPlayer();
        lottoManager = new LottoCardManager(players.size());
        lottoManager.allocLottoCardNumber();

        for (int i = 0; i < players.size(); i++) {
            players.get(i).acquireLottoCard(lottoManager, i);
        }

        //scoreManager = new ScoreManager(players.size());
        //scoreManager.calcScore(lottoManager);

        winnerManager = new WinnerManager();
        List winner = winnerManager.sortWinner(players);
        winnerManager.doReward(winner);

        return "승자 선출이 완료되었습니다!";
    }

    private void allocPlayer() {
        players = new ArrayList<>();

        for (int i = 0; i < MAX_PLAYER; i++) {
            players.add(new Player());
        }
    }
}

package kr.eddi.demo.entity.basic.nineth;

import kr.eddi.demo.utility.basic.nineth.NicknameGenerator;

public class Player {
    private LottoCard card;
    private String nickName;

    public Player() {
        nickName = NicknameGenerator.generateRandomNickname();
        card = new LottoCard();
    }
}

package kr.eddi.demo.controller.basic.seventh;

import kr.eddi.demo.entity.basic.seventh.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seventh")
public class SeventhCleanDiceGameController {

    private final int DEFAULT_PLAYER_NUM = 2;
    private final int DEATH_SCORE = -4444;
    private List<Player> players;
    private int playerNum;

    @GetMapping("/dice-game")
    public String diceGameStarter() {

        createPlayer();
        gameStart();

        return checkWinner();
    }

    // Collection을 사용한다는 것은 결국 특정 집합체를 다루는 것을 의미함
    // 특정 집합체를 다루는 가장 기본형태는 배열이다.
    // 근데 배열은 단점은 ?
    // 1. 길이가 고정됨
    // 2. 한 가지 종류만 저장된다 ? (Object 타입 배열)
    // 3. 중간에 값을 끼워넣을 수 있을까 ???
    //    가능은 하지만 코드가 매우 쓰잘데기 없이 드러워짐
    //    기존 내용들을 전부 다 뒤로 빼고 해당 위치에 새로운것을 배치해야함
    //    근데 데이터가 1억개면 ?
    //    이렇게 만들면 모니터랑 머리랑 결합됩니다.

    //    만약 배열 형태가 아니라 특정 정보를 끼워넣고 참조하는 위치만 변경할 수 있다면 어떨까요 ?

    // * 배열 vs 연결리스트
    //            1  1  1  1  1  1  1  1  1  1
    // 배열의 형태 [0][1][2][3][4][5][6][7][8][9]  <--- 구조 자체가 순차적임 (하드웨어적으로도)
    //
    // 리스트의 형태 { 1, 참조 } ---> { 1, 참조 } ---> { 1, 참조 } ---> ...
    //
    // 위 케이스에서 1번 인덱스에 숫자 7을 넣는 작업을 생각해봅시다.
    // 일단 1번 인덱스의 위치로 이동
    // 1번 ~ 9번 인덱스의 내용을 외부 공간에 저장 (별도의 변수 생성하던지 등등)
    // 인덱스 1에 숫자 7 배치
    // 인덱스 2번부터 별도의 공간에 생성한 정보 가져와서 재배치
    // (이때 사실은 기존 메모리를 날리고 새롭게 증가된 배열을 할당 받아야함)
    // new int[origin_arr.length + 1] 형태로
    // 보기만 해도 코드 구조 자체가 매우 더러울 것이 자명함
    //
    // 리스트 케이스
    // { 1, 참조 } ---> { 1, 참조 } ---> { 1, 참조 } ---> ...
    // 1번 인덱스를 조정할 것이니 아래와 같이 연결을 일시적으로 끊음.
    // { 1, 참조 }      { 1, 참조 } ---> { 1, 참조 } ---> ...
    // 새로 배치할 정보를 생성함
    // { 1, 참조 }      { 1, 참조 } ---> { 1, 참조 } ---> ...
    //         { 7, 참조 }
    // 참조 연결을 다시 맵핑
    // { 1, 참조 }      { 1, 참조 } ---> { 1, 참조 } ---> ...
    //     |                 ^
    //     |                 |
    //     ---> { 7, 참조 } ---
    // 뭐가 더 좋은가요 ?
    // 이게 Collection 쓰는 이유의 시작이자 마지막이고 모든것임.
    // 물론 HashSet 등등 Red Black 트리 쓰는 기법이 있는데 일단 여기까지 신경쓰진 말자!
    public void createPlayer() {
        // 기존에 플레이어 정보를 배열로 관리하고 있었음
        // 만약 네트워크 대전 게임이라고 가정한다면 ?
        // 보편적인 네트워크 대전 게임엔 어떤 기능이 있나요 ? 난입 <<<
        // 사람 숫자 제한이 없다고 가정한다면 ??? 접속자가 몇명이 될지 알 수 없으니 배열로 커버가 안됨.
        // 그렇다면 여기에서 뭘 써야 할까요 ? Collection 내의 정보 집합체들

        players = new ArrayList<>();
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayerObj(List<Player> players, int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            players.add(new Player());
        }
    }

    // 사용자가 게임을 시작해서
    // 주사위를 굴리고
    // 굴린 주사위가 짝수라면
    // 앞서 만든 유틸리티 사용하고
    // 유틸리티를 사용해서 각 플레이어들에게 옵션 적용
    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players.get(i).gameStart(players);
        }
    }
    
    // 최종 승자 판정
    // 현재 이 부분은 일반화하지 않았고 2명이라 가정하고 진행함
    // 실제로는 Collection에 넣고 sort() 시키면 정렬이 됨
    // 여기선 그냥 두명 가정하고 만듭시다.
    // 이거까지 또 일반화하면 ... 머리 터질것 같으니까 ㅋㅋㅋ
    public String checkWinner() {
        // 기본적으로 Java는 String에 대한 처리를 서포트하지만
        // 사용자 커스텀 자료타입인 class에 대해서는 부가적 작업을 해줘야함
        // Collections가 기본적으로 Comparable을 extends 하고 있으며
        // 실제 Comparable은 interface임을 볼 수 있다.
        // 해당 인터페이스는 compareTo 프로토타입을 가지고 있으므로
        // 우리가 정렬하고자 하는 Player 클래스에 이에 대한 구현체가 필요하다.
        log.info("정렬전: " + String.valueOf(players));
        
        Collections.sort(players);

        log.info("정렬후: " + String.valueOf(players));

        int maxPlayerScore = acquirePlayerTotalScore(playerNum - 1);

        if (maxPlayerScore == DEATH_SCORE) { return "전원 탈락!!!"; }

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for (int i = playerNum - 2; i >= 0; i--) {
            int tmpScore = acquirePlayerTotalScore(i);

            if (maxPlayerScore != tmpScore) { break; }

            sameScoreIdxList.add(i);
        }

        if (sameScoreIdxList.size() > 0) { return "무승부입니다!"; }

        return "플레이어: " + players.get(playerNum - 1).getNickName() + " 님이 승리하였습니다!";
    }

    public int acquirePlayerTotalScore(int idx) {
        return players.get(idx).getScore().getTotalScore();
    }
}

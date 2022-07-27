package kr.eddi.demo.utility.basic.sixth.clean;

// 주사위를 굴릴 것임
// 근데 주사위 숫자에 규칙은 있을 수도 없을 수도 있고
// 특정 규칙이 존재한다면 해당 규칙은 상황에 따라 바뀔 수도 있을 것이다.
// A 게임사, B 게임사, C 게임사, D 카지노, E 카지노 등등

// 이렇게 규칙이 바뀌는 상황에서도 일관된 처리를 유지하고자 하는 경우
// 사용하는 방식이 바로 interface(인터페이스)에 해당한다.

import kr.eddi.demo.entity.basic.sixth.clean.Player;

// interface는 매서드 프로토타입만 작성한다.
// 프로토타입: 리턴타입, 매서드 이름, 파라메터
public interface SpecialDiceOption {
    public void checkSpecialDice(Player player[], int diceNum, int playerIdx);
}

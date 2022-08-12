package kr.eddi.demo.controller.basic.eighteeth;

import kr.eddi.demo.entity.basic.eighteenth.Fruit;
import kr.eddi.demo.entity.basic.eighteenth.PlayerCharacter;
import kr.eddi.demo.entity.basic.eighteenth.SyllableNameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/18th")
public class FirstExerciseController {

    /*
    게임 아이템 중 음식 클래스 내부에 사과, 귤, 포도, 빵 등을 구현해봅시다.
    음식들을 먹으면 어떤 음식을 먹었냐에 따라서 각기 다른 능력이 발휘됨
    (이건 각자 하고 싶은대로 hp를 회복시키던 공격력을 올리던 등등) <-- 캐릭터 클래스가 하나 필요하긴함.

    * for 문으로 객체 다루는 경우엔
    포도를 5개 한 번에 먹기 기능 같은 구현으로 작업합니다.

    * 인터페이스의 경우엔 각각의 과일을 먹었을때 기능이 될 것임.

    * 리스트의 경우엔 과일들을 관리하는 차원에서 필요함. */
    @GetMapping("/exercise1")
    public String doExercise1() {
        Fruit fruit = new Fruit();
        PlayerCharacter character = new PlayerCharacter(fruit);

        character.viewFoodList();
        System.out.println("플레이어 정보: " + character);

        character.eatFood("사과");
        System.out.println("플레이어 정보: " + character);

        character.eatAllFood();
        System.out.println("플레이어 정보: " + character);

        return "0";
    }

    /*
    학교종이 땡땡땡의 음계표를 enum을 활용해서 구현해보자.
    "솔솔라라 솔솔미" <<<--- 요기까지만
     */
    @GetMapping("/exercise2")
    public int[] doExercise2() {
        SyllableNameManager syllableNameManager = new SyllableNameManager("솔솔라라솔솔미");

        syllableNameManager.analysisSyllables();
        return syllableNameManager.getSyllablesNumber();
    }
}

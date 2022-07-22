package kr.eddi.demo.entity.basic.second;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 위의 Getter, Setter가 실제 Lombok에서 제공하는 자동화 기능임.
// 클래스 내부의 변수들을 보고 알아서 Getter와 Setter를 만듬
// 그러나 경우에 따라 커스텀 매서드를 만들어야 할 수도 있으므로
// 실제로 매서드를 만드는 방법에 대해서는 잘 숙지하고 있어야함
public class Member {
    private String userName = "eddi";
    private String password = "456123";
}

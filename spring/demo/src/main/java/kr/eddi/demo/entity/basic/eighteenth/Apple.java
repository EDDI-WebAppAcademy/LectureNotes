package kr.eddi.demo.entity.basic.eighteenth;

public class Apple implements FoodFeature {
    private String description = "멸망한 인간 왕국의 전통 과일중 하나로 맛있고 hp를 50 회복시켜준다.";

    public int eatFood() {
        return 50;
    }
}

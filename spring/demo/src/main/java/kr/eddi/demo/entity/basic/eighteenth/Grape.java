package kr.eddi.demo.entity.basic.eighteenth;

public class Grape implements FoodFeature {
    private String description = "멸망한 인간 왕국의 피로회복제 및 술로 활용되었던 과일중 하나로 hp를 200 회복시켜줍니다.";

    public int eatFood() {
        return 200;
    }
}

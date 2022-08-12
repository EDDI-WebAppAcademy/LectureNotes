package kr.eddi.demo.entity.basic.eighteenth;

public class Banana implements FoodFeature {
    private String description = "과거 바나나를 먹으면 인간 왕국 내에서도 부잣집 도련님으로 볼 정도로 귀한 식품이며 hp를 500 회복시켜줍니다.";

    public int eatFood() {
        return 500;
    }
}

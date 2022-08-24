package kr.eddi.demo.entity.basic.eighteenth;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class PlayerCharacter {

    private final int APPLE = 1;
    private final int GRAPE = 2;
    private final int BANANA = 3;

    private String name;
    private int maxHp;
    private int hp;
    private int mp;
    private int atk;
    private int mag;
    private int str;
    private int dex;
    private int intelli;

    // Inventory inventory;
    Map<String, Map<String, Object>> inventory;

    public PlayerCharacter(Fruit fruit) {
        name = "마검사";

        maxHp = 2500;
        hp = 1500;
        mp = 1000;
        atk = 800;
        mag = 700;
        str = 100;
        dex = 70;
        intelli = 90;

        inventory = new HashMap<>();
        inventory.put("과일", fruit.getFruits());
    }

    public void viewFoodList() {
        System.out.println("현재 다른 기능이 없습니다 - 과일만 볼 수 있습니다.");

        Map<String, Object> myFruitLists = inventory.get("과일");

        for (Object fruit: myFruitLists.keySet()) {
            System.out.println(fruit);
        }
    }

    public int checkFoodKinds(String foodName) {
        System.out.println("과일 종류를 찾습니다.");

        int fruitNumber = 0;

        switch (foodName) {
            case "사과":
                fruitNumber = APPLE;
                break;

            case "포도":
                fruitNumber = GRAPE;
                break;

            case "바나나":
                fruitNumber = BANANA;
                break;
        }

        return fruitNumber;
    }

    public void eatFood(String foodName) {
        System.out.println("선택한 과일을 먹습니다: " + foodName);

        int foodNumber = checkFoodKinds(foodName);

        // 중복 1 <--- 하단의 중복1 과 중복2가 있음
        // 이런 것들이 사실상 클래스 분리가 이뤄졌으면 중복하지 않아도 되었던 것들임.
        Map<String, Object> myFruitLists = inventory.get("과일");
        Object fruit = myFruitLists.get(foodName);

        switch (foodNumber) {
            case APPLE:
                /* 의사 코드 - 대략적인 형태 
                1번째 방법
                FoodFeatureManager ffm = new;
                ffm.eatFood(this, fruit);
                
                2번째 방법
                Fruit 클래스 자체에서 처리하는 방법
                public void eatFood() { } 형태를
                public FruitFeature eatFood() { } 형태로 변경하여
                FruitFeature 객체를 리턴하고 그 객체의 정보를 기반으로 hp던 atk던 값을 적용할 수 있도록 구성하는 방법 */

                // Map<String, List<Fruit>>
                this.hp += ((Apple)fruit).eatFood();
                break;

            case GRAPE:
                this.hp += ((Grape)fruit).eatFood();
                break;

            case BANANA:
                this.hp += ((Banana)fruit).eatFood();
                break;
        }

        myFruitLists.remove(fruit);
    }

    public void eatAllFood() {
        System.out.println("남아 있는 모든 과일을 먹습니다: ");

        // 중복 2
        Map<String, Object> myFruitLists = inventory.get("과일");

        for (Map.Entry<String, Object> fruit: myFruitLists.entrySet()) {
            String foodName = fruit.getKey();
            eatFood(foodName);
        }
    }
}

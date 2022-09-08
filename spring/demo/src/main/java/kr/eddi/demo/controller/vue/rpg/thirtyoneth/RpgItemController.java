package kr.eddi.demo.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo.controller.vue.rpg.thirtyoneth.request.Items;
import kr.eddi.demo.controller.vue.rpg.thirtyoneth.request.RequestBuyItem;
import kr.eddi.demo.entity.vue.rpg.ShopItems;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgItemController {

    private List<ShopItems> allShopLists = new ArrayList<>();
    private List<ShopItems> userInventoryList = new ArrayList<>();

    public void buildDefaultItemList () {
        if (allShopLists.size() == 0) {
            allShopLists.add(new ShopItems("낡은 검", 5000000, "무기 공격력 100", 100));
            allShopLists.add(new ShopItems("검", 50000000, "무기 공격력 200", 200));
            allShopLists.add(new ShopItems("강철 검", 150000000, "무기 공격력 300", 300));
            allShopLists.add(new ShopItems("화열검", 550000000, "무기 공격력 500", 500));
            allShopLists.add(new ShopItems("군주의검", 1000000000, "무기 공격력 1000", 1000));
        }
    }

    public void buildRandomShopList (List<ShopItems> randomShopLists) {
        int everyItemSize = allShopLists.size();

        for (int i = 0; i < 10; i++) {
            ShopItems oneThing = allShopLists.get(CustomRandom.makeIntCustomRandom(0, everyItemSize - 1));
            randomShopLists.add(oneThing);
        }
    }

    @GetMapping("/random-shop-item-lists")
    public List<ShopItems> shuffleShopItems () {
        log.info("shuffleShopItems()");

        buildDefaultItemList();
        List<ShopItems> randomShopLists = new ArrayList<>();
        buildRandomShopList(randomShopLists);

        return randomShopLists;
    }

    @PostMapping("/buy-item")
    public String buyItems (@RequestBody RequestBuyItem requestBuyItem) {
        log.info("buyItems() - requestBuyItem: " + requestBuyItem);

        List<Items> tmp = requestBuyItem.getItemLists();

        for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {
            ShopItems tmpItem = new ShopItems(tmp.get(i).getName(), tmp.get(i).getPrice(),
                    tmp.get(i).getDescription(), tmp.get(i).getAtk());
            userInventoryList.add(tmpItem);
        }

        return "아이템 구매 성공!";
    }

    @PostMapping("/my-inventory")
    public List<ShopItems> viewInventory () {
        log.info("shuffleShopItems()");

        return userInventoryList;
    }
}

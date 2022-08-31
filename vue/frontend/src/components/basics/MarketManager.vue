<template>
  <div>
    <h3>상점 (Local Component)</h3>
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
      판매 목록
    </label>
    <button v-on:click="calcBuyList()">구매 확정</button>
    <table border="1" v-if="shopView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">구매</th>
      </tr>
      <tr v-for="(item, index) in shopList" :key="index">
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.effect.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="shopListValue" :value="index">
          </label>
        </th>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "CharacterManager",
  data () {
    return {
      shopView: false,
      shopList: [],
      shopListValue: [],
      itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
        { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
        { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
        { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
        { name: '화열검', price: 550000000, effect: { description: '무기 공격력 500', atk: 500 }},
        { name: '군주의검', price: 1000000000, effect: { description: '무기 공격력 1000', atk: 1000 }},
        { name: '아이스소드', price: 1500000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
        { name: '칠지도', price: 2000000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
        { name: '군주의휘장', price: 1000000000, effect: { description: '악세사리 공격력 1000', atk: 1000 }},
      ],
    }
  },
  methods: {
    shuffleShopList () {
      if (!this.shopView) {
        this.shopListValue = []
      }

      for (let i = 0; i < 10; i++) {
        let randIdx = Math.floor(Math.random() * this.itemBooks.length)
        this.shopList[i] = this.itemBooks[randIdx]
      }
    },
    calcBuyList () {
      let tmpSum = 0

      for (let i = 0; i < this.shopListValue.length; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if (this.shopListValue[i] === j) {
            tmpSum += this.shopList[j].price
            break
          }
        }
      }

      console.log(tmpSum)

      /*
      if (this.characterStatus.money - tmpSum >= 0) {
        this.characterStatus.money -= tmpSum

        for (let i = 0; i < this.shopListValue.length; i++) {
          this.myInventory.push({
            name: this.shopList[this.shopListValue[i]].name,
            effect: this.shopList[this.shopListValue[i]].effect
          })
        }

        alert("물품 구매 완료!")
      } else { alert("돈읎다 - 돈벌어와!!!") }
       */
    },
  }
}
</script>

<style scoped>

</style>
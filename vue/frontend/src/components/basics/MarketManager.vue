<template>
  <div>
    <h3>상점 (Local Component)</h3>
    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
      판매 목록
    </label>
    <button v-on:click="buyItem()">구매 확정</button>
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
        <th align="center" width="320">{{ item.description }}</th>
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

import {mapActions} from "vuex";

export default {
  name: "CharacterManager",
  data () {
    return {
      shopView: false,
      shopList: [],
      shopListValue: [],
    }
  },
  methods: {
    ...mapActions([
        'requestRandomGameItem',
        'requestBuyItem'
    ]),
    async shuffleShopList() {
      if (!this.shopView) {
        this.shopListValue = []
        await this.requestRandomGameItem()
        this.shopList = this.$store.state.randomShopItem
      }
    },
    async buyItem () {
      let calculatedPrice = this.calcBuyList()
      let selectedItems = this.checkSelectedItemList()
      let payload = { calculatedPrice, selectedItems }
      await this.requestBuyItem(payload)
    },
    checkSelectedItemList () {
      let tmpList = []

      for (let i = 0; i < this.shopListValue.length; i++) {
        tmpList.push(this.shopList[this.shopListValue[i]])
      }

      console.log(tmpList)
      return tmpList
    },
    calcBuyList () {
      let calculatedPrice = 0

      for (let i = 0; i < this.shopListValue.length; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if (this.shopListValue[i] === j) {
            calculatedPrice += this.shopList[j].price
            break
          }
        }
      }

      console.log(calculatedPrice)

      return calculatedPrice

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
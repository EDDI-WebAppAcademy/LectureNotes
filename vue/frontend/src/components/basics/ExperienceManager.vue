<template>
  <div>
    <h3>경험치 교환 시스템 (Local Component)</h3>
    <p>경험치 1000만당 스탯치 교환이 가능합니다. (hp, mp는 50, 나머지는 5)</p>
    <button v-on:click="doExpExchange()">교환</button>
    <table border="1">
      <tr>
        <th align="center" width="120">교환 리스트</th>
        <th align="center" width="40">교환</th>
      </tr>
      <tr v-for="(exchangeList, idx) in expExchangeLists" :key="idx">
        <th align="center" width="120">{{ exchangeList }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="exchangeListValue" :value="idx">
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
      expExchangeLists: ["hp", "mp", "atk", "str", "dex", "int", "def"],
      exchangeListValue: [],
    }
  },
  methods: {
    ...mapActions([
      'requestExperienceExchangeFromSpring',
    ]),
    async doExpExchange () {
      await this.requestExperienceExchangeFromSpring(this.exchangeListValue)
    }
  }
}
</script>

<style scoped>

</style>
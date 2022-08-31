<template>
  <div>
    <h2>Vue 컴포넌트 테스트</h2>

    <div>
      <!-- v-bind:initial-test === :initial-test -->
      <p>{{ msg }}</p>
      <global-component :initial-test="counter"/>
      <local-component :initial-value="num"/>
      <button v-on:click="plus">클릭해봐!</button>
    </div>
  </div>
</template>

<script>

import Vue from 'vue'
import GlobalComponent from "@/components/basics/GlobalComponent";
import LocalComponent from "@/components/basics/LocalComponent";

Vue.component(GlobalComponent.name, GlobalComponent)

export default {
  name: "ComponentTestView",
  components: {
    'local-component': LocalComponent
  },
  data () {
    return {
      counter: 0,
      num: 0,
      msg: 'vue가 이래서 생산성이 높고 트렌디한 것임.'
    }
  },
  methods: {
    plus () {
      this.num++
    }
  }
}
</script>

<style scoped>

</style>
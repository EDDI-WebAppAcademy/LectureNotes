<template>
  <div>
    <h2>Vue 컴포넌트 테스트</h2>

    <div>
      <!-- v-bind:initial-test === :initial-test -->
      <global-component :initial-test="counter"/>
    </div>
  </div>
</template>

<script>

import Vue from 'vue'
import GlobalComponent from "@/components/basics/GlobalComponent";

Vue.component(GlobalComponent.name, GlobalComponent)

export default {
  name: "ComponentTestView",
  data () {
    return {
      counter: 0,
    }
  }
}
</script>

<style scoped>

</style>
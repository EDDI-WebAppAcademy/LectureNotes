<template>
  <div>
    <h2>Vue 2 Spring Test</h2>
    <button @click="callRequestDataFromSpring">눌러봐!</button>
  </div>
</template>

<script>

import { mapState, mapActions } from 'vuex'

export default {
  name: "VueToSpringView",
  computed: {
    ...mapState(['springFromVueTestValue'])
  },
  methods: {
    ...mapActions(['requestDataFromSpring']),
    callRequestDataFromSpring () {
      this.requestDataFromSpring()
    }
  }
}
</script>

<style scoped>

</style>
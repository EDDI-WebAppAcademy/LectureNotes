<template>
  <div>
    <h2>Vue 2 Spring Test</h2>
    <button @click="callRequestDataFromSpring">눌러봐!</button>
    <p>{{ returnValue }}</p>
  </div>
</template>

<script>

import { mapState, mapActions } from 'vuex'

export default {
  name: "VueToSpringView",
  data () {
    return {
      returnValue: 0,
    }
  },
  computed: {
    ...mapState(['springFromVueTestValue'])
  },
  methods: {
    ...mapActions(['requestDataFromSpring']),
    async callRequestDataFromSpring({commit}) {
      await this.requestDataFromSpring({commit})
      this.returnValue = this.$store.state.springFromVueTestValue
    }
  }
}
</script>

<style scoped>

</style>
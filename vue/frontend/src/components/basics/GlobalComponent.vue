<template>
  <button @click="addCounter">{{ counterValue }}</button>
</template>

<script>
export default {
  name: "global-component",
  // 헝가리안 표기법 -> 초기 소문자 이후로 이니셜마다 대문자
  // 이런 형태가 vue와 연결시에는 initial-test
  props: ['initialTest'],
  data () {
    return {
      counterValue: this.initialTest
    }
  },
  methods: {
    addCounter () {
      this.counterValue += 1
    }
  }
}
</script>

<style scoped>

</style>
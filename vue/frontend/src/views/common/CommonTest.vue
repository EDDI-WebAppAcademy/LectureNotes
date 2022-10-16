<template>
  <CommonButton
      @click="letsGo"
      color="teal darken-1"
      rounded
      small
      block
      iconName="mdi-magnify"
      btnName="Search"
  ></CommonButton>
</template>

<script>
export default {
  name: "CommonTest",
  methods: {
    letsGo() {
      console.log('가즈아!!!')
    },
  },
}
</script>

<style scoped>

</style>
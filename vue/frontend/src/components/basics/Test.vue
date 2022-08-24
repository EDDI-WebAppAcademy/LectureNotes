<template>
  <div>
    <h1>{{ testMsg }}</h1>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() {
    return {
      testMsg: "My Message",
    }
  }
}
</script>

<style scoped>

</style>
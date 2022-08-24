<template>
  <div>
    <h1>{{ testMsg }}</h1>
    <li v-for="(item, index) in lists" :key=index>
      {{ item }}
    </li>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() {
    return {
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape']
    }
  }
}
</script>

<style scoped>

</style>
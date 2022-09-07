<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>이름</td>
        <td>
          <input type="text" v-model="memberName"/>
        </td>
      </tr>
      <tr>
        <td>전공</td>
        <td>
          <input type="text" v-model="major"/>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">전송</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "DataSendTestForm",
  data () {
    return {
      memberName: '이름을 작성하세요',
      major: '전공을 적어주세요',
    }
  },
  methods: {
    onSubmit () {
      const { memberName, major } = this
      this.$emit('submit', { memberName, major })
    }
  }
}
</script>

<style scoped>

</style>
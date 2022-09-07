<template>
  <div>
    <h2>vue에서 spring으로 요청시 데이터 전송 테스트</h2>
    <data-send-test-form @submit="onSubmit"/>
  </div>
</template>

<script>

import DataSendTestForm from "@/components/basics/DataSendTestForm";
import axios from "axios";

export default {
  name: "DataSendTestView",
  components: {
    DataSendTestForm
  },
  methods: {
    onSubmit (payload) {
      const { memberName, major } = payload
      axios.post('http://localhost:7777/32th/vue2spring/receive-test',
          { memberName, major })
          .then(() => {
            alert('전송 요청 완료')
          })
          .catch(() => {
            alert('문제 발생!')
          })
    }
  }
}
</script>

<style scoped>

</style>
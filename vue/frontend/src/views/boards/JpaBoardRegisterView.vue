<template>
  <div align="center">
    <h2>게시물 작성</h2>
    <jpa-board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import JpaBoardRegisterForm from "@/components/boards/JpaBoardRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "JpaBoardRegisterView",
  components: {
    JpaBoardRegisterForm
  },
  methods: {
    ...mapActions([
      'requestCreateBoardContentsToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestCreateBoardContentsToSpring(payload)

      await this.$router.push({
        name: 'JpaBoardListView'
      })
    }
  }
}
</script>

<style scoped>

</style>
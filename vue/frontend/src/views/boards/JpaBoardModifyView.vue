<template>
  <div align="center">
    <h2>Vue + Spring 게시물 수정</h2>
    <jpa-board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
    <p v-else>Loading .........</p>
  </div>
</template>

<script>
import JpaBoardModifyForm from "@/components/boards/JpaBoardModifyForm";
import {mapActions, mapState} from "vuex";
export default {
  name: "JpaBoardModifyView",
  components: {JpaBoardModifyForm},
  props: {
    boardNo: {
      type: String,
      required: true,
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions([
        'requestBoardFromSpring',
        'requestBoardModifyToSpring'
    ]),
    async onSubmit (payload) {
      const { title, content, writer, regDate } = payload
      const boardNo = this.boardNo

      await this.requestBoardModifyToSpring({ boardNo, title, content, writer, regDate })
      await this.$router.push({
        name: 'JpaBoardReadView',
        params: { boardNo: this.boardNo }
      })
    }
  },
  created () {
    this.requestBoardFromSpring(this.boardNo)
  }
}
</script>

<style scoped>

</style>
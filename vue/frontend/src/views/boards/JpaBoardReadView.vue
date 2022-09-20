<template>
  <div align="center">
    <h2>Vue + Spring 게시판 읽기</h2>
    <jpa-board-read v-if="board" :board="board"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'JpaBoardModifyView', params: { boardNo } }">
      게시물 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'JpaBoardListView' }">
      돌아가기
    </router-link>
  </div>
</template>

<script>
import JpaBoardRead from "@/components/boards/JpaBoardRead";
import {mapActions, mapState} from "vuex";
export default {
  name: "JpaBoardReadView",
  components: {JpaBoardRead},
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions([
        'requestBoardFromSpring',
        'requestDeleteBoardToSpring',
    ]),
    async onDelete () {
      await this.requestDeleteBoardToSpring(this.boardNo);
      await this.$router.push({ name: 'JpaBoardListView' })
    }
  },
  created() {
    this.requestBoardFromSpring(this.boardNo)
  }
}
</script>

<style scoped>

</style>
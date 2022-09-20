<template>
  <div id="board">
    <h2>Vue + Spring + JPA Boards</h2>
    <router-link :to="{ name: 'JpaBoardRegisterView' }">
      게시물 작성
    </router-link>
    <jpa-board-list :boards="boards"/>
  </div>
</template>

<script>

import { mapState, mapActions } from "vuex";
import JpaBoardList from "@/components/boards/JpaBoardList";

export default {
  name: "JpaBoardListView.vue",
  components: {
    JpaBoardList
  },
  computed: {
    ...mapState([
        'boards'
    ]),
  },
  mounted() {
    this.requestBoardListFromSpring()
  },
  methods: {
    ...mapActions([
        'requestBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>
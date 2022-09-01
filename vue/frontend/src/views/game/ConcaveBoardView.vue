<template>
  <div>
    <div>{{ turnShape }} 님의 턴입니다.</div>
    <table-component
      :table-data="tableData"
      :turn-shape="turnShape"
      @updateTurnShape="updateTurnShape"
      @updateWinner="updateWinner"
      @updateTableData="updateTableData"/>
    <div v-if="winner">{{ winner }} 님의 승리!</div>
  </div>
</template>

<script>

import TableComponent from "@/components/game/TableComponent";

export default {
  name: "ConcaveBoardView",
  components: {
    TableComponent
  },
  data () {
    return {
      turnShape: 'O',
      winner: '',
      tableData: [
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
      ]
    }
  },
  methods: {
    updateTurnShape (passingValue) {
      console.log('ConcaveBoardView - turnShape: ' + passingValue)
      this.turnShape = passingValue
    },
    updateWinner (passingValue) {
      console.log('ConcaveBoardView - winner: ' + passingValue)
      this.winner = passingValue
    },
    updateTableData () {
      this.tableData = [
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
        ['', '', '', '', ''],
      ]
    }
  }
}
</script>

<style scoped>

</style>
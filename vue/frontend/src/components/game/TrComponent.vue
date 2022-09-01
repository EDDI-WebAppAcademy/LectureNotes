<template>
  <tr>
    <td-component
      v-for="(cellData, index) in rowData"
      :key="index"
      :cell-data="cellData"
      :cell-index="index"
      :row-index="rowIndex"
      :table-data="tableData"
      :turn-shape="turnShape"
      @updateTurnShape="updateTurnShape"
      @updateWinner="updateWinner"
      @updateTableData="updateTableData"/>
  </tr>
</template>

<script>

import TdComponent from "@/components/game/TdComponent";

export default {
  name: "TrComponent",
  components: {
    TdComponent
  },
  props: {
    rowData: Array,
    rowIndex: Number,
    tableData: Array,
    turnShape: String,
  },
  methods: {
    updateTurnShape (passingValue) {
      console.log('TrComponent - turnShape: ' + passingValue)
      this.propsTurnShape = passingValue
      this.$emit('updateTurnShape', this.propsTurnShape)
    },
    updateWinner (passingValue) {
      this.propsWinner = passingValue
      this.$emit('updateWinner', this.propsWinner)
    },
    updateTableData () {
      this.$emit('updateTableData')
    }
  }
}
</script>

<style scoped>

table {
  border-collapse: collapse;
}

td {
  border: 1px solid black;
  width: 80px;
  height: 80px;
  text-align: center;
}

</style>
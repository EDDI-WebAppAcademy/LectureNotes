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
      @updateTurnShape="updateTurnShape"/>
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
<template>
  <table>
    <tr-component
      v-for="(rowData, index) in tableData"
      :key="index"
      :row-data="rowData"
      :row-index="index"
      :table-data="tableData"
      :turn-shape="turnShape"
      @updateTurnShape="updateTurnShape"/>
  </table>
</template>

<script>

import TrComponent from "@/components/game/TrComponent";

export default {
  name: "TableComponent",
  data () {
    return {

    }
  },
  components: {
    TrComponent
  },
  props: {
    tableData: Array,
    turnShape: String,
  },
  methods: {
    updateTurnShape (passingValue) {
      console.log('TableComponent - turnShape: ' + passingValue)
      this.propsTurnShape = passingValue
      this.$emit('updateTurnShape', this.propsTurnShape)
    }
  }
}
</script>

<style scoped>

</style>
<template>
  <table>
    <tr-component
        v-for="(rowData, index) in tableData"
        :key="index"
        :row-data="rowData"
        :row-index="index"
        :table-data="tableData"/>
  </table>
</template>

<script>

import TrComponent from "@/components/game/TrComponent";

export default {
  name: "TableComponent",
  components: {
    TrComponent
  },
  props: {
    tableData: Array
  }
}
</script>

<style scoped>

</style>
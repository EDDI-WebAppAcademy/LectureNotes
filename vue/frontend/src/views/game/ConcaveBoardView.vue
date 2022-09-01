<template>
  <div>
    <table-component :table-data="tableData"/>
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
      tableData: [
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
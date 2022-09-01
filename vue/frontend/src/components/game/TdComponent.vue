<template>
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
export default {
  name: "TdComponent",
  data () {
    return {

    }
  },
  props: {
    cellData: String,
    cellIndex: Number,
    rowIndex: Number,
    tableData: Array,
  },
  methods: {
    onClickTd () {
      if (this.cellData) {
        return
      }

      this.$set(this.tableData[this.rowIndex], this.cellIndex, 'X')
      this.$emit('updateGameBoard', '')
    }
  }
}
</script>

<style scoped>

</style>
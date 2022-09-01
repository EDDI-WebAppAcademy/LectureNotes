<template>
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
export default {
  name: "TdComponent",
  data () {
    return {
      game: {
        propsTurnShape: this.turnShape,
      }
    }
  },
  props: {
    cellData: String,
    cellIndex: Number,
    rowIndex: Number,
    tableData: Array,
    turnShape: String,
  },
  methods: {
    onClickTd () {
      if (this.cellData) {
        return
      }

      this.$set(this.tableData[this.rowIndex], this.cellIndex, this.game.propsTurnShape)
      //this.$emit('updateGameBoard', '')

      this.game.propsTurnShape = this.turnShape === 'O' ? 'X' : 'O'

      this.$emit('updateTurnShape', this.game.propsTurnShape)
    }
  }
}
</script>

<style scoped>

</style>
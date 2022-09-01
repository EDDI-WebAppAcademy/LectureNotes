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
        propsWinner: '',
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

      this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turnShape)

      let win = this.checkWinner()

      if (win) {
        this.game.propsWinner = this.turnShape

        this.$emit('updateWinner', this.game.propsWinner)
        this.$emit('updateTableData')
      } else {
        let allCellFull = true

        this.tableData.forEach(row => {
          row.forEach(cell => {
            if (!cell) {
              allCellFull = false
            }
          })
        })

        if (allCellFull) {
          this.$emit('updateTableData')
        }
      }

      this.game.propsTurnShape = (this.turnShape === 'O' ? 'X' : 'O')
      this.$emit('updateTurnShape', this.game.propsTurnShape)
    },
    checkWinner () {
      if (
          this.tableData[this.rowIndex][0] === this.turnShape &&
          this.tableData[this.rowIndex][1] === this.turnShape &&
          this.tableData[this.rowIndex][2] === this.turnShape &&
          this.tableData[this.rowIndex][3] === this.turnShape &&
          this.tableData[this.rowIndex][4] === this.turnShape
      ) {
        return true
      } else if (
          this.tableData[0][this.cellIndex] === this.turnShape &&
          this.tableData[1][this.cellIndex] === this.turnShape &&
          this.tableData[2][this.cellIndex] === this.turnShape &&
          this.tableData[3][this.cellIndex] === this.turnShape &&
          this.tableData[4][this.cellIndex] === this.turnShape
      ) {
        return true
      } else if (
          this.tableData[0][0] === this.turnShape &&
          this.tableData[1][1] === this.turnShape &&
          this.tableData[2][2] === this.turnShape &&
          this.tableData[3][3] === this.turnShape &&
          this.tableData[4][4] === this.turnShape
      ) {
        return true
      } else if (
          this.tableData[0][4] === this.turnShape &&
          this.tableData[1][3] === this.turnShape &&
          this.tableData[2][2] === this.turnShape &&
          this.tableData[3][1] === this.turnShape &&
          this.tableData[4][0] === this.turnShape
      ) {
        return true
      }
    }
  }
}
</script>

<style scoped>

</style>
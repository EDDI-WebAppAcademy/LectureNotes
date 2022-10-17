<template>
  <v-container>
    <!-- something wrong -->
    <!-- something wrong -->
    <!-- something wrong -->
    <!-- something wrong -->
    <!-- something wrong -->
    <!-- something wrong -->
    <!-- something wrong -->
    <!--  v-for="(chart, idx) in chartList" :key="idx" -->
    <v-layout>
      <v-card v-for="(chart, idx) in chartList" :key="idx">
        <v-card-title class="headline">
          {{ chart.text }}
        </v-card-title>
        <v-card-text>
          <ChartTest :type="chart.type" :text="chart.text"></ChartTest>
        </v-card-text>
      </v-card>
    </v-layout>
  </v-container>
</template>

<script>

import ChartTest from "@/components/d3test/ChartTest";


export default {
  name: "D3SensorTestView",
  components: {ChartTest},
  data () {
    return {
      sensors: [],
      chartList: [
        {
          "type": "temp",
          "text": "온도"
        },
        {
          "type": "wv",
          "text": "풍속"
        },
        {
          "type": "humi",
          "text": "습도"
        },
      ],
    }
  },
  /*
  setup() {

    async onMounted(() => {
      await
      store.subscribe((mutation) => {
        if (mutation.type === "CHANGE_SENSOR_CHART") {
          if (this.sensors.value.length === 10) loading.value = false
        } else if (mutation.type === "CLOSE_SERVICE") {
          console.log("change the loading")
          loading.value = true
        }
      })
    })
    return {
      chartList,
      loading
    }
  }
   */
}
</script>

<style scoped>

</style>
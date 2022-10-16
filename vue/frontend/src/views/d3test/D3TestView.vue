<template>
  <svg :width="width" :height="height">
    <path fill="none" stroke="#76BF8A" stroke-width="3" :d="path"></path>
  </svg>
</template>

<script>

import * as d3 from "d3";

export default {
  name: "D3TestView",
  data() {
    return {
      data: [90.9, 90, 90.2, 25, 10.2, 92],
      width: 500,
      height: 300,
      padding: 20,
    };
  },
  computed: {
    path() {
      console.log("path()")
      return this.line(this.data);
    },
    line() {
      console.log("line()")
      return d3
          .line()
          .x((d, i) => this.xScale(i))
          .y((d) => this.yScale(d));
    },
    xScale() {
      console.log("xScale()")
      return d3
          .scaleLinear()
          .range([this.padding, this.width - this.padding])
          .domain(d3.extent(this.data, (d, i) => i));
    },
    yScale() {
      console.log("yScale()")
      return d3.scaleLinear().range([this.height - this.padding, this.padding]).domain([0, 100]);
    },
  },
}
</script>

<style scoped>

</style>
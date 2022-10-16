<template>
  <v-container>
    <svg :width="width" :height="height">
      <path fill="none" stroke="#76BF8A" stroke-width="3" :d="path"></path>
      <circle cx=100 cy=150 r=40 stroke=#34495E fill=#41B883></circle>
    </svg>
  </v-container>
</template>

<script>

import * as d3 from "d3";

export default {
  name: "D3TestView",
  data() {
    return {
      data: [90.9, 90, 90.2, 25, 10.2, 92],
      reg_data: [
        { date: "24-Apr-07", amount: 93.24 },
        { date: "25-Apr-07", amount: 95.35 },
        { date: "26-Apr-07", amount: 98.84 },
        { date: "27-Apr-07", amount: 99.92 },
        { date: "30-Apr-07", amount: 99.8 },
        { date: "1-May-07", amount: 99.47 },
        { date: "2-May-07", amount: 100.39 },
        { date: "3-May-07", amount: 100.4 },
        { date: "4-May-07", amount: 100.81 },
        { date: "7-May-07", amount: 103.92 },
        { date: "8-May-07", amount: 105.06 },
        { date: "9-May-07", amount: 106.88 },
        { date: "10-May-07", amount: 107.34 },
      ],
      width: 800,
      height: 500,
      padding: 0,
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
  mounted(){
    const width = 800;
    const height = 500;
    const svg = d3.select("svg").attr("width", width + 100).attr("height", height + 100);
    const g = svg.append("g");

    const parseTime = d3.timeParse("%d-%b-%y");

    const x = d3
        .scaleTime()
        .domain(
            d3.extent(this.reg_data, function (d) {
              return parseTime(d.date);
            })
        )
        .rangeRound([0, width]);

    const y = d3
        .scaleLinear()
        .domain(
            d3.extent(this.reg_data, function (d) {
              return d.amount;
            })
        )
        .rangeRound([height, 0]);

    const line = d3
        .line()
        .x(function (d) {
          return x(parseTime(d.date));
        })
        .y(function (d) {
          return y(d.amount);
        });

    g.append("g")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    g.append("g")
        .call(d3.axisLeft(y))
        .append("text")
        .attr("fill", "#000")
        .attr("transform", "rotate(-90)")
        .attr("y", 16)
        .attr("dy", "0.71em")
        .attr("text-anchor", "end")
        .text("Price ($)");

    g.append("path")
        .datum(this.reg_data)
        .attr("fill", "none")
        .attr("stroke", "steelblue")
        .attr("stroke-width", 1.5)
        .attr("d", line);
  }
}
</script>

<style scoped>

</style>
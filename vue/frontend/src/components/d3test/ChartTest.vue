<template>
  <div class="`Chart Chart-${type}`">
    <h1>{{ 1 }}</h1>
  </div>
</template>

<script>

import sensorCategory from "@/assets/json/data.json";

import {
  margin,
  chartWidth,
  chartHeight
} from '@/config'

import * as d3 from 'd3'
const timeFormat = d3.timeFormat("%H:%M")

export default {
  name: "ChartTest",
  props: {
    type: String,
    text: String,
  },
  data () {
    return {
      sesnorList: sensorCategory,
      margin: {
        top: 50, right: 50, bottom: 50, left: 50, value: 2
      },
      chartWidth: 300,
      chartHeight: 300
    }
  },
  methods: {

  },
  mounted () {
    let svg, xScale, yScale, xAxis, yAxis, line, tooltip, circle, area

    const sensors = sensorCategory

    console.log(sensors)
    console.log(this.sesnorList[0])
    console.log(this.type)

    const setAreaAndScale = (key) => {
      svg = d3.select(`.Chart-${key}`).append("svg")
        .attr("width", chartWidth + margin.left + margin.right)
        .attr("height", chartHeight + margin.top + margin.bottom)
        .append("g")
        .attr("transform", `translate(${margin.left}, ${margin.top}`)

      xScale = d3.scaleTime().range([0, chartWidth])
      yScale = d3.scaleLinear().range([chartHeight, 0])

      xAxis = d3.axisBottom(xScale).tickFormat(timeFormat)
      yAxis = d3.axisLeft(yScale)

      area = d3.area()
        .curve(d3.curveMonotoneX)
        .x(d => xScale(d.time))
        .y0(yScale(0))
        .y1(d => yScale(d[key]))

      line = d3.line().x(d => xScale(d.time)).y(d => yScale(d[key])).curve(d3.curveMonotoneX)
      tooltip = d3.select(`.tooltip`)
    }

    const initDraw = (data, key) => {
      console.log("initDraw()")
      data.forEach(d => d.time = new Date(d.time))
      xScale.domain(d3.extent(data, d => d.time))

      const mn = d3.min(data, d => d[key])
      const mx = d3.max(data, d => d[key])

      yScale.domain([mn - this.margin.value, mx + this.margin.value])
      svg.append("g")
        .attr("class", "x axis")
        .attr("transform", `translate(0, ${this.chartHeight})`)
        .call(xAxis)

      svg.append("g")
        .attr("class", "y axis")
        .call(yAxis)

      svg.append("path")
        .datum(data)
        .attr("fill", "steelblue")
        .attr("d", area)
        .attr("class", "area")

      svg.append("path")
        .attr("d", line(data))
        .attr("class", "line")

      circle = svg.selectAll("dot")
        .data(data)
        .enter().append("circle")
        .attr("r", 3)
        .on("mouseover", (event, d) => {
          console.log(event)
          console.log(key)

          tooltip.transition()
            .duration(200)
            .style("opacity", 1)

          const content = `<p>${this.text}</p> <p>[${timeFormat(d.time)}]</p><h2>${d[key]}</h2>`

          tooltip
            .html(content)
            .style("left", (event.pageX) - 83 + "px")
            .style("top", (event.pageY) - 130 + "px")
        })
        .on("mouseout", () => {
          tooltip.transition()
              .duration(200)
              .style("opacity", 0)
        })

      circle
        .attr("cx", d => xScale(d.time))
        .attr("cy", d => yScale(d[key]))
    }
    const draw = (data, key) => {
      console.log("draw()")
      data.forEach(d => d.time = new Date(d.time))

      const mn = d3.min(data, d => d[key])
      const mx = d3.max(data, d => d[key])
      xScale.domain(d3.extent(data, d => d.time))
      yScale.domain([mn - this.margin.value, mx + this.margin.value])

      svg.select(".area")
          .transition()
          .duration(750)
          .attr("d", area(data))

      svg.select(".line")
          .transition()
          .duration(750)
          .attr("d", line(data))

      svg.select(".x.axis")
          .transition()
          .duration(750)
          .call(xAxis)
      svg.select(".y.axis")
          .transition()
          .duration(750)
          .call(yAxis)

      circle
          .data(data)
          .transition()
          .duration(750)
          .attr("cx", d => xScale(d.time))
          .attr("cy", d => yScale(d[key]))
    }

    setAreaAndScale(this.type.valueOf())
    let flag = false

    console.log(sensors.valueOf())

    if (!flag && sensors.valueOf().length === 10) {
      initDraw(sensors.valueOf(), this.type.valueOf())
      flag = true
    } else if (flag) {
      draw(sensors.valueOf(), this.type.valueOf())
    }

    /*
    store.subscribe((mutation) => {
      if (mutation.type === "CHANGE_SENSOR_CHART") {
        if (!flag && sensors.value.length === 10) {
          initDraw(sensors.value, type.value)
          flag = true
        } else if (flag) {
          draw(sensors.value, type.value)
        }
      }

    })
     */
  }
}
</script>

<style scoped>

</style>
<template>
  <div class="slide-3d">
    <v-carousel :cycle="cycle" :interval="interval" :height="height" v-model="model">
      <v-carousel-item
          v-for="(color, i) in colors"
          :key="i">

        <v-sheet
            :color="color"
            :height="height"
            tile>

          <v-row
              class="fill-height"
              align="center"
              justify="center">

            <div class="text-h2">
              <v-img :src="require('@/assets/img/mario.png')" :height="height" contain></v-img>
            </div>
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

<script>

export default {
  name: "SwiperTestView",
  data: () => ({
    model: 0,
    colors: [
      'primary',
      'secondary',
      'yellow',
      'red',
      'purple',
      'orange',
    ],
    cycle: true,
    interval: 1000,
    height: 300,
  }),
}
</script>

<style scoped>

</style>
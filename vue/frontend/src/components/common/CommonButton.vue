<template>
  <v-btn
      class="white--text"
      v-on="$listeners"
      v-bind="$attrs"
      v-if="!isMobile()">
    <v-icon small>
      {{ iconName }}
    </v-icon>
    <span style="width: 5px" v-if="btnName"></span>
    {{ btnName }}
  </v-btn>
  <v-btn class="white--text" v-on="$listeners" v-bind="$attrs" v-else>
    <v-icon small>
      {{ iconName }}
    </v-icon>
  </v-btn>
</template>

<script>
import btnMixins from '@/mixins/buttonMixins'

export default {
  mixins: [btnMixins],
  props: {
    iconName: String,
    btnName: String,
  },
}

</script>

<style scoped>

</style>
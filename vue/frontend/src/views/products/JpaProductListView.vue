<template>
  <div id="product">
    <h2>Vue + Spring + JPA 기반 상품 리스트</h2>
    <router-link :to="{ name: 'JpaProductRegisterView' }">
      상품 등록
    </router-link>
    <jpa-product-list :products="products"/>
  </div>
</template>

<script>

import { mapState, mapActions } from "vuex";
import JpaProductList from "@/components/products/JpaProductList";

export default {
  name: "JpaProductListView.vue",
  components: {
    JpaProductList
  },
  computed: {
    ...mapState([
        'products'
    ]),
  },
  mounted() {
    this.requestProductListFromSpring()
  },
  methods: {
    ...mapActions([
        'requestProductListFromSpring'
    ])
  }
}
</script>

<style scoped>

</style>
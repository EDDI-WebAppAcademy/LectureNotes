<template>
  <div align="center">
    <h2>Vue + Spring 상품 세부 사항 보기</h2>
    <jpa-product-read v-if="product" :product="product"/>
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'JpaProductModifyView', params: { productNo } }">
      상품 정보 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'JpaProductListView' }">
      돌아가기
    </router-link>
  </div>
</template>

<script>

import JpaProductRead from "@/components/products/JpaProductRead";
import {mapActions, mapState} from "vuex";

export default {
  name: "JpaProductReadView",
  components: {JpaProductRead},
  props: {
    productNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['product'])
  },
  methods: {
    ...mapActions([
        'requestProductFromSpring',
        'requestDeleteProductToSpring',
    ]),
    async onDelete () {
      await this.requestDeleteProductToSpring(this.productNo);
      await this.$router.push({ name: 'JpaProductListView' })
    }
  },
  created() {
    this.requestProductFromSpring(this.productNo)
  }
}
</script>

<style scoped>

</style>
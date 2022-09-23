<template>
  <div align="center">
    <h2>상품 등록</h2>
    <jpa-product-register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import JpaProductRegisterForm from "@/components/products/JpaProductRegisterForm";
import {mapActions} from "vuex";

export default {
  name: "JpaProductRegisterView",
  components: {
    JpaProductRegisterForm
  },
  methods: {
    ...mapActions([
      'requestRegisterProductToSpring'
    ]),
    async onSubmit (payload) {
      await this.requestRegisterProductToSpring(payload)

      await this.$router.push({
        name: 'JpaProductListView'
      })
    }
  }
}
</script>

<style scoped>

</style>
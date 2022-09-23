<template>
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>상품 번호</td>
          <td>
            <input type="text" :value="product.productNo" disabled>
          </td>
        </tr>
        <tr>
          <td>상품명</td>
          <td>
            <input type="text" v-model="productName">
          </td>
        </tr>
        <tr>
          <td>판매자</td>
          <td>
            <input type="text" :value="product.seller" disabled>
          </td>
        </tr>
        <tr>
          <td>상품 가격</td>
          <td>
            <input type="number" v-model="price">
          </td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td>
            <input type="text" :value="product.regDate" disabled>
          </td>
        </tr>
        <tr>
          <td>상품 세부 정보</td>
          <td>
            <textarea cols="50" rows="20" v-model="productDescription">
            </textarea>
          </td>
        </tr>
      </table>

      <div>
        <button type="submit">수정 완료</button>
        <router-link :to="{ name: 'JpaProductReadView',
                            params: { productNo: product.productNo.toString() } }">
          취소
        </router-link>
      </div>

    </form>
  </div>
</template>

<script>
export default {
  name: "JpaProductModifyForm",
  props: {
    product: {
      type: Object,
      required: true,
    }
  },
  data () {
    return {
      productName: '',
      productDescription: '',
      price: 0,
      seller: '',
      regDate: '',
    }
  },
  created () {
    this.productName = this.product.productName
    this.seller = this.product.seller
    this.price = this.product.price
    this.productDescription = this.product.productDescription
    this.regDate = this.product.regDate
  },
  methods: {
    onSubmit () {
      const { productName, productDescription, price, seller, regDate } = this
      this.$emit('submit', { productName, productDescription, price, seller, regDate })
    }
  }
}
</script>

<style scoped>

</style>
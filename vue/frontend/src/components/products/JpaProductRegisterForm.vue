<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" v-model="productName">
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" v-model="seller">
        </td>
      </tr>
      <tr>
        <td>상품 가격</td>
        <td>
          <input type="number" v-model="price">
        </td>
      </tr>
      <tr>
        <td>상품 상세 설명</td>
        <td>
          <textarea cols="50" rows="20" v-model="productDescription">
          </textarea>
        </td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link to="{ name: 'JpaProductListView' }">
        취소
      </router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: "JpaProductRegisterForm",
  data () {
    return {
      productName: '제목을 입력하세요',
      seller: '너님은 누군가요 ?',
      price: 0,
      productDescription: '본문을 작성하세요',
    }
  },
  methods: {
    onSubmit () {
      const { productName, seller, price, productDescription } = this
      this.$emit('submit', { productName, seller, price, productDescription })
    }
  }
}
</script>

<style scoped>

</style>
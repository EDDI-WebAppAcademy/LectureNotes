<template>
  <div>
    <table>
      <tr>
        <td>상품 번호</td>
        <td>
          <input type="text" :value="product.productNo" readonly>
        </td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>
          <input type="text" :value="product.productName" readonly>
        </td>
      </tr>
      <tr>
        <td>판매자</td>
        <td>
          <input type="text" :value="product.seller" readonly>
        </td>
      </tr>
      <tr>
        <td>상품 가격</td>
        <td>
          <input type="text" :value="product.price" readonly>
        </td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td>
          <input type="text" :value="product.regDate" readonly>
        </td>
      </tr>
      <tr>
        <td>상품 세부 정보</td>
        <td>
          <textarea cols="50" rows="20" :value="product.productDescription" readonly>
          </textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaProductRead",
  props: {
    product: {
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>

</style>
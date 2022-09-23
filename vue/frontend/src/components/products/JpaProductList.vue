<template>
  <div>
    <h3>게시물 목록</h3>
    <table border="1">
      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="640">상품명</th>
        <th align="center" width="150">판매자</th>
        <th align="center" width="240">등록일자</th>
      </tr>
      <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
        <td colspan="4">
          현재 등록된 상품이 없습니다!
        </td>
      </tr>
      <tr v-else v-for="product in products" :key="product.productNo">
        <td align="center">
          {{ product.productNo }}
        </td>
        <td align="left">
          <router-link :to="{ name: 'JpaProductReadView',
                              params: { productNo: product.productNo.toString() }}">
            {{ product.productName }}
          </router-link>
        </td>
        <td align="right">
          {{ product.seller }}
        </td>
        <td align="center">
          {{ product.regDate }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaProductList",
  props: {
    products: {
      type: Array
    }
  }
}
</script>

<style scoped>

</style>
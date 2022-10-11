<template>
  <v-container>
    <div id="home">
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/test">Test</router-link> |
        <router-link to="/components-test">Component Test</router-link> |
        <router-link to="/concave-board-game">오목 게임</router-link> |
        <router-link to="/vue2spring">Vue 2 Spring 통신 테스트</router-link> |
        <router-link to="/rpg-game">RPG 게임</router-link> |
        <router-link to="/vue2spring-data-send-test">Vue 2 Spring 데이터 전송 테스트</router-link><br/>
        <router-link to="/board-list">게시판</router-link> |
        <router-link to="/product-list">상품 게시판</router-link> |
        <router-link to="/vuetify-taste">Vuetify 맛보기</router-link> |
      </nav>
      <router-view/>
    </div>
  </v-container>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  components: {
  }
}
</script>

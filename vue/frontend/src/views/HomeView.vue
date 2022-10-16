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
        <router-link to="/swiper-test">Swiper 테스트</router-link> |
        <router-link to="/calendar-test">달력 테스트</router-link> |
        <router-link to="/image-gallery-test">이미지 갤러리 테스트</router-link> |
        <router-link to="/file-upload-test">파일 업로드 테스트</router-link> |
        <router-link to="/common-component-test">mixins 공통 컴포넌트 맛보기</router-link> |
        <router-link to="/d3-test">d3 test</router-link> |

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

<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/test">Test</router-link> |
      <router-link to="/components-test">Component Test</router-link> |
      <router-link to="/concave-board-game">오목 게임</router-link> |
      <router-link to="/vue2spring">Vue 2 Spring 통신 테스트</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<scopedstyle>
nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</scopedstyle>

<template>
  <v-container>
    <div>
      <p class="blue lighten-4 red--text">Test</p>
      <p class="blue white--text">Test</p>
      <p class="blue darken-3">Test</p>
      <p class="teal lighten-1 text-center">
        뷰.티.파.이!
      </p>
      <p class="purple darken-5 white--text">Test</p>

      <v-btn class="teal" rounded @click="btnClick">Round Button</v-btn>
      <v-btn class="indigo white--text">Basic Button</v-btn>
      <v-btn class="teal" text>기본 버튼</v-btn>
      <v-btn class="teal" dark>
        <!-- https://materialdesignicons.com/ -->
        <v-icon>mdi-battery-alert-variant-outline</v-icon>
        <span>배터리 교체</span>
      </v-btn>
      <v-btn fab color="orange" dark>
        <v-icon>mdi-bluetooth</v-icon>
      </v-btn>
    </div>

    <v-layout wrap>
      <v-flex class="primary white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="red white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="green white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="blue white--text">
        <div>Test</div>
      </v-flex>
    </v-layout>
    <v-layout wrap>
      <v-flex class="teal white--text">
        <div>Test</div>
      </v-flex>
      <v-flex class="red white--text">
        <div>Test</div>
      </v-flex>
    </v-layout>

    <v-layout justify-center>
      <v-dialog v-model="dialog" persisten max-width="400">
        <template v-slot:activator="{on}">
          <v-btn color="primary" dark v-on="on">결제</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            {{ name }}
          </v-card-title>
          <v-card-text>
            오늘만 날이다! 먹고 죽엇! 할인 30%!!!
          </v-card-text>
          <v-card-text>
            지금 당장 결제 하시겠습니꽈 ?
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click="btnClick">
              취소
            </v-btn>
            <v-btn color="teal darken-1" text @click.native="btn_click($event)">
              결제 승인
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog><br/>
    </v-layout>

    <!-- transition animation은 아래 참조
         https://vuejs.org/guide/built-ins/transition.html
         https://vuejs.org/guide/extras/animation.html -->
    <v-layout justify-center>
      <v-dialog v-model="loginDialog" persistent max-width="500px">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">로그인</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            <span>
              로그인
            </span>
          </v-card-title>
          <v-card-text>
            <v-text-field label="Email" v-model="email" required></v-text-field>
          </v-card-text>
          <v-card-text>
            <v-text-field label="Password" v-model="password" required></v-text-field>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click="btnClick">
              취소
            </v-btn>
            <v-btn color="teal darken-1" text @click="btnClick">
              로그인
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>

    <v-toolbar dense dark>
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
      </v-app-bar-nav-icon>
      <v-toolbar-title>
        <span class="font-weight-light">쵝오의 여행!</span>
        <span>꾸르팁</span>
      </v-toolbar-title>
      <v-toolbar-items>
        <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
          {{ link.text }}
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense>
        <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
          <v-list-item-action>
            <v-icon left>
              {{ link.icon }}
            </v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ link.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <div>
      <v-menu offset-y>
        <template v-slot:activator="{ on }">
          <v-btn color="teal darken-1" class="white--text ma-5" v-on="on">
            마! 이거시 Drop Down 이닷!
          </v-btn>
        </template>

        <v-list>
          <v-list-item v-for="(dropItem, index) in dropItems" :key="index" link>
            <v-list-item-title>
              {{ dropItem.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>

    <v-data-table :headers="headerTitle"
                  :items="contents"
                  :items-per-page="10"
                  class="elevation-1">
    </v-data-table>

    <div>
      <v-img class="responsive-img" src="@/assets/img/mario.png"/>
    </div>
    <div class="video-container">
      <iframe width="1200" height="720" src="https://www.youtube.com/embed/3AyCy1UUlpU"
              frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
              allowfullscreen>
      </iframe>
    </div><br/>

    <div class="row">
      <div class="col-sm-2 green text-center">2</div>
      <div class="col-sm-2 blue text-center">2</div>
      <div class="col-sm-1 red text-center">1</div>
      <div class="col-sm-3 purple text-center">3</div>
      <div class="col-sm-4 yellow text-center">4</div>

      <div class="col-sm-1 green text-center">1</div>
      <div class="col-sm-2 blue text-center">2</div>
      <div class="col-sm-6 red text-center">6</div>
      <div class="col-sm-2 purple text-center">2</div>
      <div class="col-sm-1 yellow text-center">1</div>
    </div>

    <!-- npm add vue-coverflow -->
    <div>
      <coverflow :coverList="coverList" :coverWidth="260" :index="2"/>
    </div>
  </v-container>
</template>

<script>

import coverflow from 'vue-coverflow'

export default {
  name: "VuetifyTasteView",
  components: {
    coverflow
  },
  data () {
    return {
      coverList: [
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
        {
          cover: require('@/assets/img/mario.png'),
          title: 'mario'
        },
        {
          cover: require('@/assets/logo.png'),
          title: 'logo'
        },
      ],
      headerTitle: [
        { text: '번호', value: 'boardNo', width: "70px" },
        { text: '제목', value: 'title', width: "200px" },
        { text: '작성자', value: 'writer', width: "100px" },
        { text: '내용', value: 'content', width: "100px" },
      ],
      contents: [
        { boardNo: 1, title: '야호', writer: '으마으마', content: '으아아앜' },
        { boardNo: 2, title: '야호', writer: '으마으마', content: '으아아앜' },
        { boardNo: 3, title: '야호', writer: '으마으마', content: '으아아앜' },
        { boardNo: 4, title: '야호', writer: '으마으마', content: '으아아앜' },
        { boardNo: 5, title: '야호', writer: '으마으마', content: '으아아앜' },
        { boardNo: 6, title: '야호야호', writer: '으아아앜', content: 'ㅇㅋ' },
        { boardNo: 7, title: 'ㅇㅋ', writer: 'ㄷㅋ', content: 'ㅇㅋㄷㅋ' },
        { boardNo: 8, title: '가즈아', writer: '주식폭망', content: '손잡고한강' },
        { boardNo: 9, title: '간드앗', writer: '폭등', content: '다같이손잡고' },
        { boardNo: 10, title: '끝까지버틴다', writer: '존버는승리', content: '나락감' },
        { boardNo: 11, title: '마포대교줄서라', writer: '한강어디', content: '주식 조짐' },
        { boardNo: 12, title: '한강도만원', writer: '지금작살남', content: '어디가맛집' },
        { boardNo: 13, title: '야호', writer: '으마으마', content: '으아아앜' },
        { boardNo: 14, title: '야호', writer: '으마으마', content: '으아아앜' },
        { boardNo: 15, title: '야호', writer: '으마으마', content: '으아아앜' },
      ],
      name: '7박 8일 여행 코스!',
      email: '',
      password: '',
      loginDialog: false,
      dialog: false,
      nav_drawer: false,
      links: [
        { icon: 'mdi-home', text: 'Home', name: 'home', route: '/' },
        { icon: 'mdi-ev-station', text: '전기차 충전소', name: 'home', route: '/' },
      ],
      dropItems: [
        { title: '가즈아!!!!!' },
        { title: '간드아!!!!!' },
        { title: '고고싱!!!!!' },
        { title: '달려ㅆ!!!!!' },
      ]
    }
  },
  methods: {
    btnClick () {
      alert('Vuetify 테스트 버튼')
    }
  }
}
</script>

<style scoped>

</style>
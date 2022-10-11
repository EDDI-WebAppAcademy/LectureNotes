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
  </v-container>
</template>

<script>
export default {
  name: "VuetifyTasteView",
  data () {
    return {
      name: '7박 8일 여행 코스!',
      email: '',
      password: '',
      loginDialog: false,
      dialog: false
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
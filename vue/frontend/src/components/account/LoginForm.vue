<template>
  <div class="grey lighten-5" style="font-family: Arial">
    <v-row justify="center">
      <v-col cols="auto" style="padding-bottom: 90px">
        <router-link to="/">
          <v-img
              :src="require('@/assets/logo.png')" width="120" class="mx-auto mb-6"/>
        </router-link>
        <v-card width="460">
          <v-card-text class="text-center px-12 py-16">
            <v-form @submit.prevent="onSubmit">
              <div class="text-h4 font-weight-black mb-10">로그인</div>

              <div class="d-flex">
                <v-text-field v-model="email" label="이메일" @change="emailValidation" color="teal"
                              :rules="email_rule" clearable prepend-icon="mdi-account-outline"/>
              </div>

              <div class="d-flex">
                <v-text-field v-model="password" label="비밀번호" type="password" color="teal"
                              :rules="password_rule" clearable prepend-icon="mdi-lock-outline"/>
              </div>

              <v-btn type="submit" block x-large rounded color="teal lighten-2"
                     class="mt-6"  :disabled="false">
                로그인
              </v-btn>

            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "LoginForm",
  data () {
    return {
      email: "",
      password: "",
      email_rule: [
        v => !!v || '이메일을 입력해주세요.',
        v => {
          const replaceV = v.replace(/(\s*)/g, '')
          const pattern = /^(([^<>()[\]\\.,;:\s@]+(\.[^<>()[\]\\.,;:\s@]+)*)|(.+))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(replaceV) || '이메일 형식을 입력하세요.'
        }
      ],
      password_rule: [
        v => this.state === 'ins' ? !!v || '패스워드는 필수 입력사항입니다.' : true,
        v => !(v && v.length >= 30) || '패스워드는 30자 이상 입력할 수 없습니다.',
      ],
    }
  },
  methods: {
    onSubmit () {
      const { email, password } = this
      this.$emit("submit", { email, password })
    }
  }
}
</script>

<style scoped>

</style>
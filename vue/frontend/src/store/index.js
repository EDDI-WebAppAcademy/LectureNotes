import Vue from 'vue'
import Vuex from 'vuex'

import state from "@/store/states";
import actions from "@/store/actions";
import mutations from "@/store/mutations";
import getters from "@/store/getters";

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters,
})

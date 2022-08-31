import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from '@/components/basics/Test.vue'
import ComponentTestView from "@/views/basics/ComponentTestView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/test',
    name: 'test',
    component: Test
  },
  {
    path: '/components-test',
    name: 'ComponentTestView',
    component: ComponentTestView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from '@/components/basics/Test.vue'

import ComponentTestView from "@/views/basics/ComponentTestView";
import ConcaveBoardView from "@/views/game/ConcaveBoardView";
import VueToSpringView from "@/views/axiosTest/VueToSpringView";
import RpgGameView from "@/views/rpg/RpgGameView";
import DataSendTestView from "@/views/basics/DataSendTestView";

import JpaBoardListView from "@/views/boards/JpaBoardListView";
import JpaBoardRegisterView from "@/views/boards/JpaBoardRegisterView";
import JpaBoardReadView from "@/views/boards/JpaBoardReadView";
import JpaBoardModifyView from "@/views/boards/JpaBoardModifyView";

import JpaProductListView from "@/views/products/JpaProductListView";
import JpaProductRegisterView from "@/views/products/JpaProductRegisterView";
import JpaProductReadView from "@/views/products/JpaProductReadView";
import JpaProductModifyView from "@/views/products/JpaProductModifyView";

import VuetifyTasteView from "@/views/vuetify/VuetifyTasteView";
import SwiperTestView from "@/views/vuetify/SwiperTestView";
import CalendarTestView from "@/views/vuetify/CalendarTestView";
import ImageGalleryTestView from "@/views/vuetify/ImageGalleryTestView";

import FileUploadView from "@/views/file/FileUploadView";

import CommonTest from "@/views/common/CommonTest";

import D3TestView from "@/views/d3test/D3TestView";
import D3PercentTestView from "@/views/d3test/D3PercentTestView";
import D3SensorTestView from "@/views/d3test/D3SensorTestView";

import SignUpView from "@/views/account/SignUpView";
import SignInView from "@/views/account/SignInView";

import CarouselView from "@/views/support/CarouselView";

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
  },
  {
    path: '/concave-board-game',
    name: 'ConcaveBoardView',
    component: ConcaveBoardView
  },
  {
    path: '/vue2spring',
    name: 'VueToSpringView',
    component: VueToSpringView
  },
  {
    path: '/rpg-game',
    name: 'RpgGameView',
    component: RpgGameView
  },
  {
    path: '/vue2spring-data-send-test',
    name: 'DataSendTestView',
    component: DataSendTestView
  },
  {
    path: '/board-list',
    name: 'JpaBoardListView',
    component: JpaBoardListView
  },
  {
    path: '/board-register',
    name: 'JpaBoardRegisterView',
    component: JpaBoardRegisterView
  },
  {
    path: '/board-read/:boardNo',
    name: 'JpaBoardReadView',
    components: {
      default: JpaBoardReadView
    },
    props: {
      default: true
    }
  },
  {
    path: '/board-modify/:boardNo',
    name: 'JpaBoardModifyView',
    components: {
      default: JpaBoardModifyView
    },
    props: {
      default: true
    }
  },
  {
    path: '/product-list',
    name: 'JpaProductListView',
    component: JpaProductListView
  },
  {
    path: '/product-register',
    name: 'JpaProductRegisterView',
    component: JpaProductRegisterView
  },
  {
    path: '/product-read/:productNo',
    name: 'JpaProductReadView',
    components: {
      default: JpaProductReadView
    },
    props: {
      default: true
    }
  },
  {
    path: '/product-modify/:productNo',
    name: 'JpaProductModifyView',
    components: {
      default: JpaProductModifyView
    },
    props: {
      default: true
    }
  },
  {
    path: '/vuetify-taste',
    name: 'VuetifyTasteView',
    component: VuetifyTasteView
  },
  {
    path: '/swiper-test',
    name: 'SwiperTestView',
    component: SwiperTestView
  },
  {
    path: '/calendar-test',
    name: 'CalendarTestView',
    component: CalendarTestView
  },
  {
    path: '/image-gallery-test',
    name: 'ImageGalleryTestView',
    component: ImageGalleryTestView
  },
  {
    path: '/file-upload-test',
    name: 'FileUploadView',
    component: FileUploadView
  },
  {
    path: '/common-component-test',
    name: 'CommonTest',
    component: CommonTest
  },
  {
    path: '/d3-test',
    name: 'D3TestView',
    component: D3TestView
  },
  {
    path: '/d3-percent-test',
    name: 'D3PercentTestView',
    component: D3PercentTestView
  },
  {
    path: '/d3-sensor-test',
    name: 'D3SensorTestView',
    components: {
      default: D3SensorTestView
    },
    props: {
      default: true
    }
  },
  {
    path: '/sign-up',
    name: 'SignUpView',
    component: SignUpView
  },
  {
    path: '/sign-in',
    name: 'SignInView',
    component: SignInView
  },
  {
    path: '/carousel-test',
    name: 'CarouselView',
    component: CarouselView
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

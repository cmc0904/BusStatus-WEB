/*import { createRouter, createWebHashHistory } from 'vue-router'*/
import { createRouter, createWebHistory  } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import StarPage from '../views/StarPage.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/star',
    name: 'startPage',
    component: StarPage
  },
  {
    path: '/about/:id',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue'),
    props: true 
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition; // 이전에 스크롤한 위치로 이동
    } else {
      return { x: 0, y: 0 }; // 페이지 상단으로 스크롤
    }
  },
});

export default router;


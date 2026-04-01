import { createRouter, createWebHistory } from 'vue-router';
// import HomeView from '../views/HomeView.vue'
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import MemberInfo from '@/pages/Memberinfo.vue';
import VideoPlayer from '@/pages/VideoPlayer.vue';
// 컴포넌트가 있는 것만 import 가능, 없는 것을 지정하면 실행 에러

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 요청주소 경로 하나 당 컴포넌트 하나 설정, {path:'경로', component :랜더링할 컴포넌트 이름}
    {
      path: '/home',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: About,
    },
    {
      path: '/members',
      name: 'members',
      component: Members,
    },
    {
      path: '/members/:id',
      name: 'members/id',
      component: MemberInfo,
    },
    {
      path: '/videos',
      name: 'videos',
      component: Videos,

      children:[path:':id', name:'videos/id',component : VideoPlayer]
    },
  ],
});

export default router;

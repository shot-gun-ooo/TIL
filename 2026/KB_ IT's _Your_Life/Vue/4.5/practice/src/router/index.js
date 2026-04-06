import { createRouter, createWebHistory } from 'vue-router';

import StockList from '../views/StockList.vue'; // 조금 뒤에 만들 예정!
import StockDetail from '@/views/StockDetail.vue';

const routes = [
  {
    path: '/stocks',
    name: 'stocks',
    component: StockList,
  },
  {
    path: '/stock/:id', // :id는 변하는 값(1, 2, 3...)을 의미함
    name: 'detail',
    component: StockDetail,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;

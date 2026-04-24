import { createRouter, createWebHistory } from 'vue-router'

// [Step 1] 주소록 만들기 (Routes 정의)
// 어떤 주소로 가면 어떤 부품(Component)을 보여줄지 정하기
const routes = [
  // 1. 메인 페이지 (지금은 HomeView가 없으니 /todos로 바로 보냅니다)
  { 
    path: '/', 
    redirect: '/todos' 
  },
  // 2. 할 일 목록 페이지 (건우님이 만든 TodoList.vue 연결)
  { 
    path: '/todos', 
    name: 'todos', 
    component: () => import('@/pages/TodoList.vue') 
  }
]

// [Step 2] Router 인스턴스 생성
// 위의 주소록을 가지고 실제 라우터 기계 만들기
const router = createRouter({
  history: createWebHistory(), // 건우님 노트대로 깔끔하게!
  routes // 위에서 만든 주소록(routes)을 여기에 쏙 넣음
})

export default router
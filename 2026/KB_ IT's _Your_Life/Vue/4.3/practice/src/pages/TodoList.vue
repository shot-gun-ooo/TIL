<template>
  <div style="background-color: #f0f0f0; padding: 20px">
    <h1 style="color: blue">🚀 레벨 1 성공!</h1>
    <p>건우님, 이 글자가 브라우저에 보이면 페이지 연결 성공입니다.</p>
    <ul>
      <li v-for="item in todoList" :key="item.id">
        {{ item.todo }}
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'; // 1. 도구들 가져오기
import axios from 'axios'; // 2. 엑시오스 가져오기

const todoList = ref([]); // 3. 서버에서 받을 데이터를 담을 '바구니'
const fetchTodos = async () => {
  try {
    // Vite 프록시 설정(/api)을 믿고 3000번 서버로 출발!
    const response = await axios.get('/api/todos');
    todoList.value = response.data; // 서버가 준 소중한 데이터를 바구니에 쏙!
  } catch (error) {
    console.error('데이터 가져오기 실패ㅠ:', error);
  }
};
onMounted(() => {
  fetchTodos(); // 페이지가 마운트(딱 뜨면) 되면 바로 심부름 시작!
});
// 아직 아무 기능도 넣지 않습니다. 연결 확인이 우선!
</script>

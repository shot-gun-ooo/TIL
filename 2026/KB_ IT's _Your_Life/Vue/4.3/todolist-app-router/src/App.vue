<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>

<script setup>
import { reactive, computed, provide, onMounted } from 'vue'; // 1. onMounted 추가
import Header from '@/components/Header.vue';
import axios from 'axios';

const states = reactive({
  todoList: [],
});

const BASEURI = '/api/todos';

// [조회] 서버에서 목록 가져오기
const fetchTodoList = async () => {
  try {
    const response = await axios.get(BASEURI);
    if (response.status === 200) {
      console.log('✅ 데이터 로드 성공:', response.data);
      states.todoList = response.data;
    }
  } catch (e) {
    // 2. 아까 error라고 쓰고 e라고 출력했던 오타 수정
    console.error('❌ 서버 연결 에러:', e.message);
  }
};

// 3. 앱이 켜질 때 실행되도록 명시적으로 호출
onMounted(() => {
  fetchTodoList();
});

// [추가] 일단 로컬에서만 작동 (나중에 axios.post로 바꿀 예정)
const addTodo = async ({ todo, desc }) => {
  try {
    const payload = { todo, desc, done: false };
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      states.todoList.push(response.data);
      console.log('✅ 2단계 성공: 서버에 새 할 일 저장 완료!');
    }
  } catch (e) {
    console.error('❌ 2단계 실패: 저장 중 에러 발생', e.message);
  }
  states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
};

const updateTodo = ({ id, todo, desc, done }) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  if (index !== -1) states.todoList[index] = { id, todo, desc, done };
};

const deleteTodo = async (id) => {
  try {
    const response = await axios.delete(`${BASEURI}/${id}`);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
      console.log(`✅ ${id}번 데이터 삭제 완료!`);
    }
  } catch (e) {
    console.error('❌ 삭제 실패:', e.message);
  }
};

const toggleDone = async (id) => {
  try {
    const todo = states.todoList.find((t) => t.id === id);
    const response = await axios.patch(`${BASEURI}/${id}`, {
      done: !todo.done,
    });

    if (response.status === 200) {
      // 3. 서버가 오케이(200) 하면, 내 화면의 체크박스 상태도 바꿉니다.
      todo.done = !todo.done;
      console.log(`✅ ${id}번 항목 상태 변경 완료!`);
    }
  } catch (e) {
    console.error('❌ 상태 변경 실패:', e.message);
  }
};
provide(
  'todoList',
  computed(() => states.todoList),
);
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>

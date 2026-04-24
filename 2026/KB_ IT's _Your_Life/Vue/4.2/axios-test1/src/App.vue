<template>
  <div class="container mt-5">
    <h2 class="mb-4">나의 할 일 목록</h2>
    
    <div class="input-group mb-3">
      <input v-model="todoName" type="text" class="form-control" placeholder="할 일을 입력하세요">
      <button @click="addTodo" class="btn btn-primary">추가하기</button>
    </div>

    <ul class="list-group">
      <li v-for="item in todoList" :key="item.id" class="list-group-item">
        <strong>{{ item.todo }}</strong> - <small>{{ item.desc }}</small>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const todoList = ref([]);
const todoName = ref('');

// [GET] 목록 가져오기
const fetchTodos = async () => {
  try {
    const response = await axios.get('/api/todos');
    todoList.value = response.data;
  } catch (e) {
    console.error('불러오기 실패:', e.message);
  }
};

// [POST] 데이터 추가하기
const addTodo = async () => {
  if (!todoName.value) return;

  try {
    const newTodo = { 
      todo: todoName.value, 
      desc: "방금 추가됨", 
      done: false 
    };

    // 서버로 데이터 전송
    await axios.post('http://localhost:3000/todos', newTodo);

    // 입력칸 비우고 목록 다시 부르기
    todoName.value = '';
    fetchTodos();
  } catch (e) {
    console.error('추가 실패:', e.message);
  }
};

onMounted(fetchTodos);
</script>
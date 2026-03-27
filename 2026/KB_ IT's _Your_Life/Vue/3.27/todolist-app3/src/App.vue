<template>
  <div class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div>키워드검색1 <SearchInput v-model="keyword" /></div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todoList="filteredList"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        />
      </div>
    </div>
  </div>
</template>
s
<script setup>
import { reactive, ref, computed } from 'vue';
// 1. import만 하면 등록(components: {}) 과정 필요 없음!
import SearchInput from './components/SearchInput.vue';
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

let ts = new Date().getTime();

// 원본 데이터
const todoList = reactive([
  { id: ts, todo: '자전거 타기', completed: false },
  { id: ts + 1, todo: '딸과 공원 산책', completed: true },
  { id: ts + 2, todo: '일요일 애견 카페', completed: false },
  { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
]);

const keyword = ref('');

// 2. 검색 필터 로직 (핵심 수정!)
const filteredList = computed(() => {
  // keyword.value가 포함된 항목만 필터링 (state. 없이 바로 todoList 접근)
  return todoList.filter((item) => item.todo.includes(keyword.value));
});

const addTodo = (todo) => {
  if (todo.length >= 2) {
    todoList.push({
      id: new Date().getTime(),
      todo: todo,
      completed: false,
    });
  }
};

const deleteTodo = (id) => {
  let index = todoList.findIndex((item) => id === item.id);
  if (index !== -1) todoList.splice(index, 1);
};

const toggleCompleted = (id) => {
  let index = todoList.findIndex((item) => id === item.id);
  if (index !== -1) todoList[index].completed = !todoList[index].completed;
};
</script>

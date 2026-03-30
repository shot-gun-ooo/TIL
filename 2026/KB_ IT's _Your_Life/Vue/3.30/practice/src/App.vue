<template>
  <div>
    <h3 class="text-center mb-4">:: Todolist App (입력 연결 단계)</h3>
    <InputTodo @add-todo="addTodo" />
    <h5>배달된 데이터 목록 (총 {{ state.todoList.length }}개)</h5>
    <pre>{{ state.todoList }}</pre>
    <ul>
      <li v-for="item in state.todoList" :key="item.id">
        {{ item.content }}
      </li>
    </ul>

    <TodoList
      :todoList="state.todoList"
      @toggle-todo="toggleTodo"
      @delete-todo="deleteTodo"
    />
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';

const state = reactive({ todoList: [] });
const addTodo = (todoText) => {
  state.todoList.push({
    id: Date.now(),
    content: todoText,
    completed: false,
  });
  console.log('데이터 추가 완료', todoText);
};
const toggleTodo = (id) => {
  const index = state.todoList.findIndex((todo) => todo.id == id);
  if (index !== -1) {
    state.todoList[index].completed = !state.todoList[index].completed;
  }
};
const deleteTodo = (id) => {
  const index = state.todoList.findIndex((todo) => todo.id === id);
  if (index !== -1) {
    state.todoList.splice(index, 1);
  }
};
</script>

<style></style>

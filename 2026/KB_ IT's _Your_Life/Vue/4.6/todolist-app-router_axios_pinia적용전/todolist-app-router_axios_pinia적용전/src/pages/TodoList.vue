<template>
  <div class="row">
    <div class="col p-3">
      <router-link class="btn btn-primary" to="/todos/add">
        할일 추가
      </router-link>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoItem
          v-for="todoItem in todoListStore.states.todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import TodoItem from '@/pages/TodoItem.vue';
import { useTodoListStore } from '@/stores/todoList';

// Pinia 스토어 불러오기
const todoListStore = useTodoListStore();

// 만약 화면이 처음에 비어있다면, 여기서 데이터를 한 번 불러와야 할 수도 있습니다.
// todoListStore.fetchTodoList(); 
</script>
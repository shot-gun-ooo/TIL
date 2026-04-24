<template>
  <div>
    <InputTodo @add-todo="addTodo" />
    <ul >
      <li v-for="item in state.todoList" :key="item.id">
        ID :{{ item.id }} 내용 : {{ item.content }}

      </li>
    </ul>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import InputTodo from './components/InputTodo.vue';
const state = reactive({ todoList: [] });
const addTodo = (todo) => {
  if (todo.length >= 2) {
    state.todoList.push({
      id: new Date().getTime(),
      content: todo,
      completed: false,
    });
  }
};
</script>

<style></style>

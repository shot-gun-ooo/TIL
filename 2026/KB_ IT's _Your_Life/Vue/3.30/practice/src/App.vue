<template>
  <div>
    <InputTodo @add-todo="addTodo" />
    <strong>최근 추가된 할 일:</strong>
    {{ state.todoList.length > 0 ? state.todoList[state.todoList.length - 1].content : '없음' }}
  </div>
</template>

<script setup>
import InputTodo from './components/InputTodo.vue';
import { reactive } from 'vue';

const state = reactive({
  todoList: [],
});

const addTodo = (todo) => {
  if (todo.length >= 2) {
    state.todoList.push({
      id: new Date().getTime(),
      content: todo,
      completed: false,
    });
    console.log('부모가 받은 데이터', todo);
  }
};
</script>

<style></style>

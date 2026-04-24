<template>
  <div class="input-group mb-3 shadow-sm">
    <input
      v-model.trim="todo"
      @keyup.enter="sendTodo"
      class="form-control"
      placeholder="할 일을 입력하세요 (2글자 이상)"
    >
    </input>
    <button @click="sendTodo" class="btn btn-primary fw-bold">추가</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const todo = ref('');
const emit = defineEmits(['add-todo']);
const sendTodo = () => {
  if (todo.value.length >= 2) {
    emit('add-todo', todo.value);
    todo.value = '';
  } else {
    alert('2글자 이상 입력하세요!');
  }
};
</script>

<style></style>

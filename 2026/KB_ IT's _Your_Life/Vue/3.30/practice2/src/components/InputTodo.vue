<template>
  <div>
    <input
      type="text"
      @keyup.enter="addTodoHandler"
      class="form-control"
      v-model="todo"
    />
    <button class="btn btn-outline-secondary" @click="addTodoHandler">
      추가
    </button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const emit = defineEmits(['add-todo']);
const todo = ref('');
const addTodoHandler = () => {
  if (todo.value.length >= 3) {
    emit('add-todo', todo.value);
    todo.value = '';
  }
};
</script>

<style></style>

<template>
  <div>
    <h1>잘나오나..</h1>
    <input type="text" v-model="todoText" placeholder="할 일을 입력하세요" />
    <button @click="sendTodo">할일을 추가합니다.</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const emit = defineEmits(['add-item']);
const todoText = ref('');
const sendTodo = () => {
  if (todoText.value.trim() === '') {
    return;
  }
  emit('add-item', todoText.value);
  todoText.value = '';
};
</script>

<style></style>

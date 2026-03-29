<template>
  <div>
    <input type="text" v-model="newTodo" @keyup.enter = "dispatchTodo" class="form-control" placeholder="할 일을 입력하세요" />
    <button @click ='dispatchTodo' class="btn btn-primary">추가</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const emit = defineEmits(['add-todo']);
const newTodo = ref('');
const dispatchTodo = () => {
  if (!newTodo.value.trim()) return;
  emit('add-todo', newTodo.value);
};
</script>

<style></style>

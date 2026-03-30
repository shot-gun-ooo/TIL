<template>
  <div>
    <input
      type="text"
      class="form-control"
      placeholder="뭐하고싶어용"
      v-model="todo"
      @keyup.enter="addTodoHandler"
    />
    <button class="btn btn-primary" @click="addTodoHandler">
      할 일을 추가해봐용
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
  } else {
    alert('3글자 이상 입력해용');
  }
};
</script>

<style></style>

<template>
  <div class="row">
    <div class="col p-3">
      <h2>할 일 추가</h2>
      <div class="form-group">
        <label>할 일:</label>
        <input type="text" class="form-control" v-model="todoItem.todo" />
      </div>
      <div class="form-group">
        <label>설명:</label>
        <textarea class="form-control" rows="3" v-model="todoItem.desc"></textarea>
      </div>
      <div class="form-group">
        <button type="button" class="btn btn-primary m-1" @click="actions.addTodo({ ...todoItem })">추가</button>
        <button type="button" class="btn btn-secondary m-1" @click="router.push('/todos')">취소</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, inject } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const actions = inject('actions'); // App.vue에서 provide한 actions 받기

const todoItem = reactive({ todo: '', desc: '' });
</script>
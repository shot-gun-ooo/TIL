<template>
  <div>
    <ul class="list-group">
      <li
        v-for="todoItem in todoList"
        :key="todoItem.id"
        class="list-group-item d-flex justify-content-between align-items-center"
      ></li>
    </ul>
    <div class="d-flex align-items-center">
        <input type="checkbox" class="form-check-input me-3" :checked="todoItem.completed" @change="emit('toggle-todo', todoItem.id)">

    </div>
  </div>
</template>

<script setup>
const props = defineProps({todoList:{type:Array,required:true}})</script>

<style></style>

<template>
  <ul>
    <li v-for="item in todoList" :key="item.id" class="list-group-item">
      <span :class="{ 'todo-done': item.completed }">
        {{ item.content }}
      </span>
      <button
        class="btn btn-sm btn-danger float-end"
        @click="emit('delete-todo', item.id)"
      >
        삭제
      </button>
    </li>
  </ul>
</template>

<script setup>
const props = 




</script>

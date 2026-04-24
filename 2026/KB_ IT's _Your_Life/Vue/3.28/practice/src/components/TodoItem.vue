<template>
  <div>
    <input
      type="checkbox"
      class="form-check-input me-2"
      :checked="todoObj.isDone"
      @change="$emit('toggle-todo', todoObj.id)"
    />
    <span
      :class="{ 'text-decoration-line-through text-muted': todoObj.isDone }"
    >
      {{ todoObj.content }}
    </span>
    <button
      @click="$emit('delete-todo', todoObj.id)"
      class="btn btn-danger btn-sm"
    >
      삭제
    </button>
  </div>
</template>

<script setup>
defineProps(['todoObj']);
defineEmits(['toggle-todo', 'delete-todo']);
</script>

<style></style>

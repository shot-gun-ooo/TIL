<template>
  <div>
    <h3>할 일 목록</h3>
    <ul>
      <li v-for="item in todos" :key="item.id">
        <span
          @click="onToggle(item.id)"
          :style="{
            textDecoration: item.done ? 'line-through' : 'none',
            cursor: 'pointer',
          }"
          >{{ item.text }}</span
        >
        <button @click="onRemove(item.id)">삭제</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { defineProps, defineEmits } from 'vue';
const props = defineProps({
  todos: Array,
});
const emit = defineEmits(['remove', 'toggle']);
const onRemove = (id) => {
  emit('remove', id);
};
const onToggle = (id) => {
  emit('toggle', id);
};
</script>

<style lang="scss" scoped></style>

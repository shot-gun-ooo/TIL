<template>
  <div>
    <ul>
      <li v-for="item in list" :key="item.id">
        <input
          type="checkbox"
          :checked="item.completed"
          @change="$emit('toggle-item', item.id)"
        />

        <span :style="item.completed ? { textDecoration: 'line-through' } : {}">
          {{ item.todo }}
        </span>

        <button @click="$emit('delete-item', item.id)">삭제</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
defineProps(['list']);
defineEmits(['delete-item', 'toggle-item']);
</script>

<style></style>

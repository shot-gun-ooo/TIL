<template>
  <div>
    <h3>현재 전등 상태: {{ isOn ? '💡 켜짐' : '🌑 꺼짐' }}</h3>
    <button @click="toggle" class="btn btn-warning">스위치 딸깍!</button>
  </div>
</template>

<script setup>
defineProps(['isOn']);
const emit = defineEmits(['toggle-light']);
const toggle = () => {
  emit('toggle-light');
};
</script>

<style></style>

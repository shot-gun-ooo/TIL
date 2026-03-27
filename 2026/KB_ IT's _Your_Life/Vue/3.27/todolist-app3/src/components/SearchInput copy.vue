<template>
  <input type="text" v-model="keyword" placeholder="할일 검색" />
</template>
<script setup>
const keyword = defineModel();
</script>

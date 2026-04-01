<template>
  <div class="card card-body">
    <h2>About</h2>
    <p>이 컴포넌트에서 요청한 경로 : {{route.fullPath}}</p>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
</script>

<style></style>

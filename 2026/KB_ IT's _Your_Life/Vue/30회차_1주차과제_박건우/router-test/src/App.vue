<template>
  <div class="container">
    <Header />

    <router-view />
  </div>
</template>

<script setup>
import Header from '@/components/Header.vue';
import 'bootstrap/dist/css/bootstrap.min.css';
</script>

<style>
.container {
  text-align: center;
  margin-top: 10px;
}
</style>

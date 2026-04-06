<template>
  <div class="container">
    <Header />
    <router-view />
    <Loading v-if="todoStore.states.isLoading" />
  </div>
</template>

<script setup>
import Header from './components/Header.vue';
import Loading from './components/Loading.vue';
import { useTodoListStore } from './stores/todoList'; // 스토어 설계도 불러오기

// 1. 설계도(useTodoListStore)를 실행해서 실제 데이터 바구니(todoStore)를 만듭니다.
const todoStore = useTodoListStore(); 

// 2. 이제 template에서는 위에서 만든 'todoStore'라는 이름만 사용하면 됩니다.
</script>
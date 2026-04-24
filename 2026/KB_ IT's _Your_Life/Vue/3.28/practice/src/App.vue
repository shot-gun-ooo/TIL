<template>
  <div>
    <child :msg="hello" />
    <button @click="changeMessage">메시지 변경</button>
    <h1>우리 집 거실</h1>
    <LightSwitch :isOn="isLightOn" @toggle-light="handleUpdate" />
  </div>
  <div style="max-width: 600px">
    <TodoInput @add-todo="addTodo" />
    <ul class="list-group shadow-sm">
      <TodoItem
        v-for="item in items"
        :key="item.id"
        :todoObj="item"
        @toggle-todo="toggleTodo"
        @delete-todo="deleteTodo"
      />
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import child from './components/child.vue';
import LightSwitch from './components/LightSwitch.vue';
import TodoInput from './components/TodoInput.vue';
import TodoItem from './components/TodoItem.vue';

const hello = ref('안녕하세요');
const changeMessage = () => {
  hello.value = '토요일이 끝나가요';
};
const isLightOn = ref(false);
const handleUpdate = () => {
  isLightOn.value = !isLightOn.value;
};
const items = ref([
  { id: 1, content: 'Vue 3 컴포넌트 마스터', isDone: false },
  { id: 2, content: '부트스트랩 디자인 적용', isDone: true },
]);

const addTodo = (text) => {
  items.value.push({
    id: Date.now(),
    content: text,
    isDone: false,
  });
};
const deleteTodo = (id) => {
  items.value = items.value.filter((item) => item.id !== id);
};
const toggleTodo = (id) => {
  const target = items.value.find((item) => item.id === id);
  if (target) {
    target.isDone = !target.isDone;
  }
};
</script>

<style></style>

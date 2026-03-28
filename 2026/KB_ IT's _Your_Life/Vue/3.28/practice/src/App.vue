<template>
  <div>
    <child :msg="hello" />
    <button @click="changeMessage">메시지 변경</button>
    <h1>우리 집 거실</h1>
    <LightSwitch :isOn="isLightOn" @toggle-light="handleUpdate" />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import child from './components/child.vue';
import LightSwitch from './components/LightSwitch.vue';

const hello = ref('안녕하세요');
const changeMessage = () => {
  hello.value = '토요일이 끝나가요';
};
const isLightOn = ref(false);
const handleUpdate = () => {
  isLightOn.value = !isLightOn.value;
};
</script>

<style></style>

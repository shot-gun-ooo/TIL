<template>
  <div></div>
</template>

<script setup>
import axios from 'axios';
const reqApi = async() => {
  const url = 'http://localhost:3000/todos'
  let response = await axios.get(url)
  console.log(response);
  console.log(response.data);
  
}

reqApi();
</script>

<style lang="scss" scoped></style>

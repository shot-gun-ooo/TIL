<template>
  <div>
    <h1>나의 체크리스트</h1>
    <InputTodo @add-item="addItem" />
    <hr />
    <TodoList :list="items" @delete-item="deleteItem" @toggle-item="toggleItem" />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';

const items = ref([{id:1, todo:'vue마스터', completed:false},
  {id:2, todo:'vㅇㄹㅇ마스터', comppleted:true}
]);
const addItem = (newText) => {
  items.value.push({
    id: Date.now(),
    todo:newText,
    completed:false
  });
  console.log('새로운 일이 추가되었다.', newText);
};
const deleteItem =(id)=>{
  items.value = items.value.filter(item=> item.id !==id)
}
const toggleItem = (id)=>{
  const target = items.value.find(item=>item.id === id);
  if(target) target.completed = !target.completed;
}
</script>

<style></style>

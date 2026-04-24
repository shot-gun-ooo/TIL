<template>
  <div>
    <h1>나의 할 일 목록</h1>
    <ul>
      <TodoListItem v-for="item in todoList" :key="item.id" :todoItem="item" />
    </ul>
  </div>
</template>

<script>
import TodoListItem from './components/TodoListItem.vue';
export default {
  name: 'App',
  components: {
    TodoListItem, // 사용할 부품 등록
  },
  data() {
    return {
      // 실제 데이터는 부모가 관리함
      todoList: [
        { id: 1, todo: 'Vue 실습하기', completed: false },
        { id: 2, todo: '자식 컴포넌트 이해하기', completed: true },
      ],
    };
  },
};
</script>

<style></style>

<template>
  <div class="container">
    <h1>건우의 todo앱</h1>

    <ul>
      <TodoListItem
        v-for="item in todoList"
        :key="item.id"
        :todoItem="item"
        @toggle-completed="toggleTodo"
        @delete-todo="deleteTodo"
      />
    </ul>
  </div>
</template>

<script>
import TodoListItem from './components/TodoListItem.vue';
export default {
  name: 'App',
  components: {
    TodoListItem,
  },
  data() {
    return {
      todoList: [
        { id: 1, todo: 'Vue 실습하기', completed: false },
        { id: 2, todo: '자식 컴포넌트 이해하기', completed: true },
        { id: 3, todo: '맛있는 저녁 먹기', completed: false },
      ],
    };
  },
  methods: {
    toggleTodo(id) {
      const item = this.todoList.find((todo) => todo.id === id);
      if (item) {
        item.completed = !item.completed;
      }
    },
    deleteTodo(id) {
      this.todoList = this.todoList.filter((todo) => todo.id !== id);
    },
  },
};
</script>

<style lang="scss" scoped></style>

<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList :todoList="'todoList'"/>
      </div>
    </div>
  </div>
</template>

<script>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

let ts = new Date().getTime();

export default {
  name: 'App',
  // 파일이름과 똑같이
  components: {TodoList, InputTodo},
  data() {
    return {
      todoList: [
        { id: ts, todo: '자전거타기', completed: false },
        { id: ts + 1, todo: '공원 산책', completed: true },
        { id: ts + 2, todo: '카페가기', completed: false },
        { id: ts + 3, todo: '책읽기', completed: false },
      ],
    };
  },
  methods: {
    addTodo(todo) {
      if (todo.length >= 2) {
        this.todoList.push({
          id: new Date().getTime(),
          todo: todo,
          completed: false,
        });
      }
    },
    deleteTodo(id) {
      let index = this.todoList.findIndex((item) => id === item.id);
      this.todoList.splice(index, 1);
    },
    toggleCompleted(id) {
      let index = this.todoList.findIndex((item) => id === item.id);
      this.todoList[index].completed = !this.todoList[index].completed;
    },
  },
};
</script>

<style lang="scss" scoped></style>

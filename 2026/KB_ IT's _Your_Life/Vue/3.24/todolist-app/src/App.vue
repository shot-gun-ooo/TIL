<template>
  <div class="container">
    <InputTodo @add-todo="addTodo" />

    <p>현재 할 일 개수: {{ todoList.length }}개</p>
  </div>
</template>

<script>
import InputTodo from './components/InputTodo.vue';

export default {
  name: 'App',
  components: { InputTodo },

  data() {
    return {
      todoList: [
        { id: 1, todo: '자전거 타기', completed: false },
        { id: 2, todo: '딸과 공원 산책', completed: true },
      ],
    }; // data 끝
  },

  methods: {
    addTodo(todo) {
      this.todoList.push({
        id: Date.now(),
        todo: todo,
        completed: false,
      });
    }, // addTodo 함수 끝
  }, // methods 끝
}; // export default 끝
</script>

<template></template>

<script>
import InputTodo from './components/InputTodo.vue';
export default {
  // App.vue에서 export한 것은 -> 결국 프로젝트의 제일 뿌리인 **main.js**라는 파일이 받아서
  // 진짜 웹 브라우저 화면에 조립해 넣습니다.
  name: 'App',
  components: { InputTodo },
  data() {
    return {
      todoList: [
        { id: 1, todo: '자전거 타기', completed: false },
        { id: 2, todo: '딸과 공원 산책', completed: true },
      ],
      methods: {
        addTodo(todo) {
          this.todoList.push({
            id: Date.now(),
            todo: todo,
            completed: false,
          });
        },
      },
    };
  },
};
</script>

<template>
  <div class="input-group">
    <input
      type="text"
      v-model="todo"
      placeholder="할일을 입력하세요"
      @keyup.enter="addTodo"
    />
    <button @click="addTodo">추가</button>
  </div>
</template>

<script>
export default {
  name: 'TodoInput',
  data() {
    return {
      todo: '',
    };
  },
  emits: ['add-todo'],
  methods: {
    addTodo() {
      if (this.todo.trim() == '') {
        this.$emit('add-todo, this.todo');
        this.todo = '';
      }
    },
  },
};
</script>

<style></style>

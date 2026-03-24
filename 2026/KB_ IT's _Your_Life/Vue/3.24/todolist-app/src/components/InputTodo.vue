<template>
  <div class="input-group">
    <input
      type="text"
      class="form-control"
      placeholder="할일을 여기에 입력!"
      v-model.trim="todo"
      @keyup.enter="addTodoHandler"
    />
    <button class="btn btn-primary" @click="addTodoHandler">추가</button>
  </div>
</template>

<script>
export default {
  name: 'InputTodo',
  data() {
    return { todo: '' };
  },
  emits: ['add-todo'],
  methods: {
    addTodoHandler() {},
  },
};
</script>

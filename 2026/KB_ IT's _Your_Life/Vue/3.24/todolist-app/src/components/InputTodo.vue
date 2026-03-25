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
  emits:['add-todo'],
  data() {
    return { todo: '' };
  },
   methods: {
    addTodoHandler() {
        if (this.todo.length>=2){
            this.$emit('add-tood'. this.todo);
            this.todo=''
        }
    },
  },
};
</script>

<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': todoItem.completed }"
    
  >
    <span :class="{ 'todo-done': todoItem.completed }"
      >{{ todoItem.todo }}-{{ todoItem.completed }}
      {{ todoItem.completed ? '(완료)' : '(미완료)' }}</span
    >
    <span
      class="float-end badge bg -secondary pointer"
      @click.stop="$emit('delete-todo', todoItem.id)"
      >삭제</span
    >
  </li>
  <div></div>
</template>

<script>
export default {
  name: 'TodoListItem',
  props: {
    todoItem: { type: Object, required: true },
  },
};
</script>

<style></style>

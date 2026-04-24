<template>
  <li class="list-group-item">
    <input type="checkbox" :checked="todoItem.completed" @click="toggle" />

    <span>{{ todoItem.todo }}</span>
    <button class="float-end" @click="deleteItem">삭제</button>
  </li>
  <div></div>
</template>

<script>
export default {
  name: 'TodoListItem',
  // name: 이 부품의 '공식 이름'입니다.
  //   파일 하나당 export default는 단 하나 -> 그래서 파일명과 export name을 보통 같게한다.
  // 나중에 개발자 도구에서 이 부품을 찾을 때 이 이름으로 표시됩니다.
  props: {
    todoItem: {
      type: Object,
      required: true,
    },
  },
  emits: ['toggle-completed', 'delete-todo'],
  methods: {
    toggle() {
      this.$emit('toggle-completed', this.todoItem.id);
    },
    deleteItem() {
      this.$emit('delete-todo', this.todoItem.id);
    },
  },
};
</script>

<style scoped>
.list-group-item {
  list-style: none;
  padding: 10px;
  border-bottom: 1px solid #ddd;
}
.float-end {
  float: right;
  color: red;
}
</style>

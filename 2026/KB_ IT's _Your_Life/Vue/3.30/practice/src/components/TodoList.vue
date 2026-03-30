<template>
  <div class="container mt-3">
    <ul class="list-group">
      <li
        v-for="todoItem in todoList"
        :key="todoItem.id"
        class="list-group-item d-flex justify-content-between align-items-center"
      >
        <div class="d-flex align-items-center">
          <input
            type="checkbox"
            class="form-check-input me-3"
            :checked="todoItem.completed"
            @change="emit('toggle-todo', todoItem.id)"
          />
          
          <span :class="{ 'todo-done': todoItem.completed }">
            {{ todoItem.content }}
          </span>
        </div>

        <button
          @click="emit('delete-todo', todoItem.id)"
          class="btn btn-sm btn-outline-danger"
        >
          삭제
        </button>
      </li>
    </ul>
  </div>
</template>

<script setup>
// 부모(App.vue)로부터 전달받는 데이터 정의
const props = defineProps({ 
  todoList: { type: Array, required: true } 
});

// 부모(App.vue)에게 보낼 신호(이벤트) 정의
const emit = defineEmits(['toggle-todo', 'delete-todo']);
</script>

<style scoped>
/* 수업 시간에 했던 취소선 스타일 */
.todo-done {
  text-decoration: line-through;
  color: #adb5bd; /* 회색 처리 */
}
</style>
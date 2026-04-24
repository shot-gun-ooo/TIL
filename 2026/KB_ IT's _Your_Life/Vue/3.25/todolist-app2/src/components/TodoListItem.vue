<template>
  <div>
    <li>
      <input
        type="checkbox"
        :checked="todoItem.completed"
        @change="toggleCheck"
      />
      {{ todoItem.todo }}
    </li>
  </div>
</template>

<script>
export default {
  name: 'TodoListItem',
  props: ['todoItem'],
  },
};
</script>

<style></style>

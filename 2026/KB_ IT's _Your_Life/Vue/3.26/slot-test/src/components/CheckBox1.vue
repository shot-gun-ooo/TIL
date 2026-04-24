<template>
  <div>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <span v-if="checked === true" style="color: blue">{{ label }}</span>
    <span v-else="checked === true" style="color: lawngreen">{{ label }}</span>
  </div>
</template>

<script>
export default {
  name: 'CheckBox1',
  props: ['id', 'checked', 'label'],
  data() {
    //데이터는 부모가 가지고 있으니 받아와야함
  },
};
</script>

<style></style>

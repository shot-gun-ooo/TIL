<template>
  <ul>
    <CheckboxItem
      v-for="idol in idols"
      :key="idol.id"
      :id="idol.id"
      :name="idol.name"
      :checked="idol.checked"
      @check-changed="toggleIdol"
    />
  </ul>
</template>

<script>
import CheckboxItem from './components/CheckboxItem.vue';
export default {
  name: 'App',
  components: { CheckboxItem },
  data() {
    return {
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
      ],
    };
  },
  methods: {
    toggleIdol(id) {
      const index = this.idols.findIndex((item) => item.id === id);
      this.idols[index].checked = !this.idols[index].checked;
      console.log(id + '번 클릭됨');
    },
  },
};
</script>

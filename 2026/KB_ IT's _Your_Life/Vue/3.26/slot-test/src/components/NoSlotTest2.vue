<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은? 첫번째:Slot사용(x)</h3>
    <!-- <span v-for="item in items" :key="item.id">
        {{ item.label }},  </span>-->
    <CheckBox2
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :checked="item.checked"
      :label="item.label"
      @check-changed="CheckBoxChanged"
      ><span v-if="item.checked" style="color: red; text-decoration: underline">
        <i>{{ item.label }}</i>
      </span>
      <span v-else style="color: gray">{{ item.label }}</span>
    </CheckBox2>
    <!-- slot에 넣어줄 내용을 CheckBox2태그 안에 적어줘야한다. 속성쓰고 싶어서 span은 사이에 쓴 것임 -->

    <br />
  </div>
</template>

<script>
import CheckBox2 from './CheckBox2.vue';
export default {
  name: 'NoSlotTest2',
  components: { CheckBox2 },
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' },
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      let item = this.items.find((item) => item.id === e.id);
      item.checked = e.checked;
    },
  },
};
</script>

<style></style>

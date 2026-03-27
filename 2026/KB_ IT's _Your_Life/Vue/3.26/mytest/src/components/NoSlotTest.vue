<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은? (첫번째: Slot 사용 X)</h3>

    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    >
    </CheckBox1>
  </div>
</template>
<script>
// 1. 자식 컴포넌트 가져오기
import CheckBox1 from './Checkbox1.vue';

export default {
  name: 'NoSlotTest',
  // 2. 가져온 컴포넌트를 등록 (나만의 태그로 사용 가능해짐)
  components: { CheckBox1 },

  data() {
    return {
      // 3. 원본 데이터 정의 (모든 상태의 주인)
      items: [
        { id: 'V', label: 'Vue', checked: true },
        { id: 'A', label: 'Angular', checked: false },
        { id: 'R', label: 'React', checked: false },
        { id: 'S', label: 'Svelte', checked: false },
      ],
    };
  },

  methods: {
    // 4. 자식이 $emit으로 보낸 신호를 처리하는 함수
    CheckBoxChanged(e) {
      // e 에는 자식이 보낸 { id, checked } 정보가 들어있음
      // 내 데이터(items)에서 해당 id를 가진 항목을 찾음
      let item = this.items.find((item) => item.id === e.id);

      // 찾은 항목의 체크 상태를 최신화
      item.checked = e.checked;

      console.log(`${item.label}의 상태가 ${e.checked}로 변경됨!`);
    },
  },
};
</script>

<style module>
.container {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 8px;
  margin: 10px;
}
</style>

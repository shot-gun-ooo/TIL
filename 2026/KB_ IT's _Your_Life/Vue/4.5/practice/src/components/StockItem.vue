<template>
  <div class="stock-card">
    <h3>{{ item.name }}</h3>
    <p>
      현재가: <strong>{{ item.price }}</strong>
    </p>
    <span :class="item.change.includes('+') ? 'up' : 'down'">
      변동: {{ item.change }}
    </span>
  </div>
  <div @click="$router.push(`/stock/${item.id}`)">
    <h3>{{ item.name }}</h3>
  </div>
  <div class="stock-card">
    <h3>{{ item.name }}</h3>
    <button @click.stop="$emit('remove', item.id)" class="delete-btn">
      삭제
    </button>
    <p>가격: {{ item.price }}원</p>
  </div>
</template>

<script setup>
// 부모(StockList)로부터 'item'이라는 이름으로 데이터를 받겠다고 선언
const props = defineProps({
  item: Object,
});
defineEmits(['remove']); // 삭제 신호(emit) 등록
</script>

<style scoped>
.stock-card {
  border: 1px solid #ddd;
  padding: 15px;
  margin: 10px;
  border-radius: 8px;
}
.up {
  color: red;
}
.down {
  color: blue;
}
</style>

<template>
  <div>
    <h1>📈 주식 위시리스트</h1>
    <p v-if="stocks.length === 0">데이터를 불러오는 중...</p>

    <ul v-else>
      <li v-for="stock in stocks" :key="stock.id">
        {{ stock.name }} - {{ stock.price }}원
      </li>
    </ul>
    
  </div>
  <StockItem
    v-for="stock in stocks"
    :key="stock.id"
    :item="stock"
    @remove="removeStock"
  />
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import StockItem from '../components/StockItem.vue';

const stocks = ref([]); // 데이터를 담을 빈 그릇

// 컴포넌트가 화면에 나타나자마자 실행
onMounted(async () => {
  try {
    // Axios로 가짜 서버(JSON Server)에 데이터 요청
    const response = await axios.get('http://localhost:3000/stocks');
    stocks.value = response.data; // 받아온 데이터를 그릇에 담기
  } catch (error) {
    console.error('데이터 로딩 실패:', error);
  }
});
// StockList.vue의 스크립트 부분
const removeStock = async (id) => {
  // 1. 확인창 띄우기 (취소 누르면 여기서 종료)
  if (!confirm('정말 삭제하시겠습니까?')) return;

  try {
    // 2. 서버에 삭제 요청 (응답이 올 때까지 여기서 딱 기다림!)
    await axios.delete(`http://localhost:3000/stocks/${id}`);

    // 3. 서버 삭제 성공 후, 내 화면 데이터에서도 해당 주식 제거
    // filter: id가 일치하지 않는 것들만 남겨서 새로 저장해!
    stocks.value = stocks.value.filter((s) => s.id !== id);

    alert('삭제되었습니다.');
  } catch (err) {
    // 서버가 죽었거나 네트워크 오류가 났을 때 실행됨
    console.error('삭제 중 오류 발생:', err);
    alert('삭제에 실패했습니다. 다시 시도해주세요.');
  }
};
</script>

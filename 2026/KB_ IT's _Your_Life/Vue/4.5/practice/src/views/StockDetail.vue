<template>
  <div v-if="stock" class="detail-container">
    <button @click="$router.back()">⬅️ 뒤로가기</button>
    <hr />
    <h1>{{ stock.name }} 상세 정보</h1>
    <div class="info-card">
      <p><strong>종목 코드:</strong> {{ stock.id }}</p>
      <p><strong>현재가:</strong> {{ stock.price }}원</p>
      <p><strong>전일대비:</strong> {{ stock.change }}</p>
      <p><strong>상세 설명:</strong> 이 주식은 현재 시장에서 매우 핫한 종목입니다.</p>
    </div>
  </div>
  <div v-else>
    <p>데이터를 불러오는 중입니다...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router' // 주소창 정보를 가져오는 도구
import axios from 'axios'

const route = useRoute() // 현재 경로 정보 객체
const stock = ref(null)  // 한 개의 주식 정보를 담을 그릇

onMounted(async () => {
  // route.params.id는 라우터 설정에서 만든 :id 값을 의미합니다.
  const id = route.params.id 
  
  try {
    // 특정 ID의 데이터만 한 건 가져오기 (예: http://localhost:3000/stocks/1)
    const response = await axios.get(`http://localhost:3000/stocks/${id}`)
    stock.value = response.data
  } catch (error) {
    console.error("상세 정보 로딩 실패:", error)
  }
})
</script>

<style scoped>
.detail-container { padding: 20px; }
.info-card { border: 2px solid #42b983; padding: 20px; border-radius: 10px; margin-top: 20px; }
button { padding: 5px 15px; cursor: pointer; }
</style>
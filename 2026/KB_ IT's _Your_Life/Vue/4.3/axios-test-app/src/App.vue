<template>
  <div>
    <h2>콘솔을 확인해주세요!</h2>
  </div>
</template>

<script setup>
//axios로 json-server 접속해서 todos의 crud작업 해보려고 함.
import axios from 'axios';
//axios할 수 있는 함수 만들어보자.
//화살표 함수 권장
const requestAPI = () => {
  const url = 'http://localhost:3000/todos/2';
  // let result = axios.get(url); //if 데이터불러올 때 오래걸린 경우 비동기함수(동시에 실행하는 함수)
  // console.log(result);
  //axios.get(url).then(get한 이후 결과 처리 내용).catch(에러가 났을 때 처리할 내용);
  axios.get(url).then((response) => {
    console.log(response);
    console.log('======================');

    console.log(response.data);
  });
};
//함수를 호출해보자
requestAPI();
</script>

<style></style>

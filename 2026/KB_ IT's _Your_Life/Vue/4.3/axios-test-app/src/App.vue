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
  // const url = 'http://localhost:3000/todos/2';
  const url = '/api/todos';
  // let result = axios.get(url); //if 데이터불러올 때 오래걸린 경우 비동기함수(동시에 실행하는 함수)
  // console.log(result);
  //axios.get(url).then(get한 이후 결과 처리 내용).catch(에러가 났을 때 처리할 내용);
  axios.get(url).then((response) => {
    console.log(response);
    console.log('======================');

    console.log(response.data);
  }).catch((error)=>{
    console.log(error);
    
  });
};

const requestAPI2 = async () => {
  const url = '/api/todos/22';
  //원격으로 http를 연결할 때는 네트워크로 연결하므로 에러가 발생할 가능성이 크다.
  //에러 처리도 같이 해주면 좋음.
  //async~await인 경우에는 try~catch로 해주고
  //then인 경우에는 catch만 붙여주면 됨.

  try {
    //에러 발생할 여지가 큰 코드를 넣어줌.
    let response = await axios.get(url);
    console.log(response.data);
    //try 안에서 에러가 발생하면 catch함수가 자동으로 호출됨
    
  } catch (error) {}
  console.log(error);
  
};
//함수를 호출해보자
// requestAPI();
requestAPI2();
</script>

<style></style>

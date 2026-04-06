<template>
  <div id="app">
    <nav>
      <router-link to="/stocks">주식 목록 보기</router-link>
    </nav>
    <hr />

    <router-view /> 
  </div>
</template>

<style>
nav { padding: 20px; text-align: center; }
a { margin: 10px; text-decoration: none; color: blue; font-weight: bold; }
</style>
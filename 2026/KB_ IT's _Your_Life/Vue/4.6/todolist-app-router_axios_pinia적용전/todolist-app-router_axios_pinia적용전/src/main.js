import './assets/main.css';
import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import 'bootstrap/dist/css/bootstrap.css';
import { createPinia } from 'pinia';

const app = createApp(App);

// 1. 피니아를 '실행'해서 인스턴스를 만든 뒤 등록해야 합니다.
app.use(createPinia());

app.use(router);
app.mount('#app');

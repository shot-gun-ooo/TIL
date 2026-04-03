import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueDevTools()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    proxy: {
      '/api': {
        // 1. 브라우저에서 '/api'로 시작하는 주소를 부르면
        target: 'http://localhost:3000', // 2. 실제로는 3000번 서버로 연결해줘!
        changeOrigin: true, // 3. 오리진 주소를 서버 주소와 맞춰서 속여줘
        rewrite: (path) => path.replace(/^\/api/, ''), // 4. 서버에 전달할 땐 '/api' 글자를 지워줘
      },
    },
  },
});

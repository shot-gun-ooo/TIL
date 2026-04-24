const http = require('http');
const server = http.createServer((req, res) => {
  if (req.url === '/home') {
    res.end('home');
  } else if (req.url === '/about') {
    res.end('about');
  }
});
server.listen(3000, () => {
  console.log('3000번 포트에서 서버 실행 중');
});

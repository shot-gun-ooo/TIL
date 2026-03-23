// npm init은 노드 프로젝트의 시작을 알리는 명령어다!
// 이걸 실행해야만 내가 어떤 패키지(자재)를 쓰는지 기록하는 'package.json'이라는 장부가 만들어진다

const c = require('ansi-colors');
function hello(name) {
  console.log(c.green(name) + '님 안녕하세요');
}
hello('홍길동');

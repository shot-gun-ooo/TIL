require('path');
const mypath = require('path');
const fullpath = mypath.join('some', 'work', 'ex.txt');
console.log(fullpath);
// console.log(path);

const path = require('path');

// 1. 현재 이 파일이 있는 실제 경로를 출력
console.log('현재 위치:', __dirname);

// 2. 현재 위치에 'data' 폴더와 'test.txt'를 합친 전체 경로 생성
const targetFile = path.join(__dirname, 'data', 'test.txt');
console.log('최종 주소:', targetFile);dd
const fs = require('fs');

const data = fs.readFile('example.txt', 'utf8', (err, data) => {
  if (err) {
    console.log(err);
  }
  console.log(data);
});
console.log('코드 끝');

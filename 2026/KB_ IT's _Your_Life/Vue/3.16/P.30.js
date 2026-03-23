function add(name, mobile, home = '몰라') {
  var str = `name=${name}, mobile=${mobile}, home=${home}`;
  console.log(str);
}
add('홍길동', '010-33004-2203');

let arr = [10, 20, 30, 40];
let [a1, a2, a3] = arr;
a1 = 200
a4 = 100
console.log(a1, a2, a3);


// let p1 = { name: '홍길동', age: 20, gender: 'M' };
// let { name: n, age: a, gender } = p1;
// console.log(n, a, gender);

let p1 = { name: '홍길동', age: 20, gender: 'M' };
let { name: n, age: a, gender } = p1;
console.log(n, a, gender);
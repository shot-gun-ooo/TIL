let num1 = 10;
let num2 = 20;
console.log(num1 + '과' + num2 + '을 더하면 ' + (num1 + num2) + '가 됩니다');
console.log(`${num1}과 ${num2}를 더하면`);

let hi = function () {
  return 'hee';
};
console.log(hi());

let hii = () => {
  return '안녕';
};
console.log(hii());

let sum = function (a, b) {
  return a + b;
};
console.log(sum(100, 200));

let summ = (c, d) => {
  return c + d;
};
console.log(summ(222, 333));

var getTriangle = function (base, height) {
  return (base * height) / 2;
};

console.log('삼각형이 면적:' + getTriangle(5, 2));

let triangle = (e, f) => {
  return (e * f) / 2;
};
console.log('삼각형이 면적:' + triangle(5, 2));

// let displayA = () => {
//   console.log('A');
// };
// function displayB(call) {
//   setTimeout(() => {
//     console.log('B');
//     call();
//   }, 2000);
// }
// let displayC = () => {
//   console.log('C');
// };

// displayA();
// displayB(displayC);

const order = (coffee,call) => {
    console.log(`${coffee} 주문 접수`)
   
    setTimeout(()=>{call(coffee)},3000)
};

const done = (result) => {
    console.log(`${result} 완료!`)
}

order('아메리카노', done)


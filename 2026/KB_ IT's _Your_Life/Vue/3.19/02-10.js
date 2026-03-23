var obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
};
var add2 = obj.add;
// obj.add(): 점(.) 찍고 부르면? 주인님은 obj!
// add2(): 점 없이 그냥 부르면? 주인님은 window(전역)!
// 익명함수에 변수명 지정해주면 평소에 쓸 때는 함수명처럼 할 수 있지만 본질적으론 이름 없는 것
console.log(add2 === obj.add);
add2(3,4)
console.log(obj);
console.log(result);


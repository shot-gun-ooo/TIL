let likepizza = true;
const pizza = new Promise((resolve, reject) => {
    // resolve와 reject는 매개변수 자리에 들어온 '함수'입니다. 
    // 함수이기 때문에 괄호를 붙여서 실행할 수 있는 것이고, 
    // 그 괄호 안에 넣은 데이터가 나중에 .then()이나 .catch()로 전달되는 선물 꾸러미가 되는 것입니다.
  if (likepizza) {
    resolve('피자를 주문합니다.');
  } else {
    reject('피자를 주문하지 않습니다');
  }
});

pizza
.then(result=>console.log(result))
// resolve('성공 데이터')**를 호출하면: 이 값은 자동으로 
// **.then(result => ...)**의 result 변수로 배달됩니다.
.catch(err=>console.log(err))

let order = (coffee, call) => {
  console.log(`${coffee} 주문 접수`);
  setTimeout(() => {
    call(coffee);
  },5000);
};
let display = (result) => {
  console.log(`${result} 완료!`);
};
order('옛날 통닭',display);


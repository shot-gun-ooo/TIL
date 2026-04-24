async function order() {
  console.log('1');
  await fetch(
    'https://www.casetify.com/ko_KR/macbook-cases?DG=MacBook&embedding=textVector',
  );
  console.log('3');
}
console.log(order())
console.log('2');


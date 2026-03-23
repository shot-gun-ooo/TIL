// fetch는 외부 서버와 통신할 때 쓰는 비동기 함수입니다. 
// 호출하면 즉시 프라미스를 반환하기 때문에, 
// 우리는 await를 사용해 데이터가 도착할 때까지 안전하게 기다렸다가 꺼내 쓰기만 하면 됩니다.

async function init(){
    const response = await fetch('https://pokeapi.co/api/v2/pokemon/ditto')
    const user = await response.json()
    console.log(user)
}

init()
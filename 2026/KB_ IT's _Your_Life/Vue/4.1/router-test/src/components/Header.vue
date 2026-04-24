<template>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-2">
    //div를 해도되지만 메뉴를 뜻하는 nav를 쓰면 부트스트랩쓰기도 좀 더 편함
    <span class="navbar-brand">이날치(LeeNalChi) </span>
    <button class="navbar-toggler" type="button" @click="changeIsNavShow">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div :class="navClass">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/home">홈</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/about">소개</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/members">멤버</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/videos">영상</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import { reactive, computed } from 'vue';
export default {
  setup() {
    //1.
    //오른쪽에 삼선무늬를 클릭 했을 때 하위 메뉴를 보이게 할지 말지를 결정
    //삼선무늬의 상태값을 저장할 수 있는 변수 하나 선언

    //2.
    //상태값 변화되었을 때 자동으로 처리하고 싶은 부분(computed())
    //computed()는 무조건 반환값이 있어야함.
    //삼선무늬의 상태값이 true/false인지에 따라서 설정할 css를 선택해주자.
    //(삼항연산자) 조건?true일때 실행되는 코드:false일 때 실행되는 코드

    const state = reactive({ isNavShow: false });
    const navClass = computed(() => {
      return state.isNavShow
        ? 'collapse navbar-collapse show'
        : 'collapse navbar-collapse';
    });

    //3.
    //삼선무늬를 눌렀을 때 상태값을 변경해주는 메서드를 하나 만들자.
    const changeIsNavShow = () => {
      state.isNavShow = !state.isNavShow;
    };
    // 누를 때마다 두 개의 값이 변경(Toggle기능)
    // ! --> not 의미

    return { state, navClass, computed, changeIsNavShow };
    // ref, reactice, computed 등 다 리턴해야한다 -> 객체리터럴{}으로 작성
  },
};
</script>

<style></style>

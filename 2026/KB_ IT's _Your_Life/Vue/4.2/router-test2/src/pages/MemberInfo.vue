<template>
  <div>id에 따른 개인정보 화면</div>
  <div class="mt-5">
    <img :src="member.photo" alt="member.name">
    <h4>{{ member.name }}-{{ member.role }}</h4>
    <p>{{ member.desc }}</p>
    <a :href="member.insta" v-if="member.insta && member.insta !=''" class="fa fa-instagram m-1"></a>
    <a :href="member.facebook" v-if="member.facebook && member.facebook !=''" class="fa fa-facebook m-1"></a>
    <a :href="member.youtube" v-if="member.youtube && member.youtube !=''" class="fa fa-youtube m-1"></a>
  </div>
</template>

<script>
import members from '@/members.json';
import { useRoute } from 'vue-router';

export default {
  name: 'MemberInfo',
  setup() {
    const currentRoute = useRoute();
    // 주소로 전달받은 파라메터는 항상 문자열로 인식
    const id = parseInt(currentRoute.params.id,10);
    //전달된 id를 꺼내서 id로 json에서 개인 정보 검색한 후
    //개인정보 return하면 template에 출력 가능

    //members안에 있는 것들을 하나씩 꺼내 m에 넣고,
    //한 사람에 대한 정보 객체리터럴인 m에 있는 id와 전달받은 파라메터가 같은지 확인하여
    //해당 객체 리터럴을 검색함.
    const member = members.find((m)=>m.id ==id)

    return {member};
  },
};
</script>

<style></style>

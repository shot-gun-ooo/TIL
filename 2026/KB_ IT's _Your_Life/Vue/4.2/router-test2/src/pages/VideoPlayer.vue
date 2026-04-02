<template>
  <div class="modal" v-if="videoInfo.video">
    <div class="box">
      <div class="heading">{{ videoInfo.video.title }}</div>
      <div class="player">
        <YoutubeVue3 :videoid="videoInfo.video.id" :autoplay="1" :controls="1">
        </YoutubeVue3>
      </div>
    </div>
  </div>
</template>

<script>
import { YoutubeVue3 } from 'youtube-vue3';
import { reactive, ref, inject } from 'vue';
import { useRoute, useRouter, onBeforeRouteUpdate } from 'vue-router';

export default {
  name: 'VideoPlayer',
  components: { YoutubeVue3 },
  setup() {
    const videos = inject('videos');
    const currentRoute = useRoute();

    // 🚩 포인트 1: 처음 로딩될 때(새로고침 시)는 비디오를 찾지 않고 빈 값으로 둡니다.
    // 이렇게 하면 v-if="videoInfo.video"가 거짓이 되어 창이 안 뜹니다.
    let videoInfo = reactive({ video: null });

    // 🚩 포인트 2: 라우트(주소)가 '업데이트' 될 때, 즉 "듣기" 버튼을 눌렀을 때만 데이터를 찾습니다.
    onBeforeRouteUpdate((to) => {
      videoInfo.video = videos.find((v) => v.id === to.params.id);
    });

    // 만약 "듣기"를 누르자마자 바로 보여야 한다면,
    // 기존 로직을 유지하되 '특정 조건'에서만 작동하게 해야 합니다.

    return { videoInfo };
  },
};
</script>

<style scoped>
.modal {
  display: block;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.4);
}
.box {
  background-color: white;
  margin: 80px auto;
  max-width: 500px;
  min-width: 100px;
  min-height: 350px;
  font: 13px 'verdana';
  padding: 10px 10px 10px 10px;
}
.box div {
  padding: 0;
  display: block;
  margin: 10px 0 0 0;
}
.box .heading {
  background: #33a17f;
  font-weight: 300;
  text-align: left;
  color: #fff;
  margin: 5px 0 5px 0;
  padding: 10px;
  min-width: 200px;
  max-width: 500px;
}
.box .player {
  background: white;
}
.pointer {
  cursor: pointer;
}
</style>

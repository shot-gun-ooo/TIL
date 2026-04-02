<template>
  <div class="card card-body">
    <h2>Videos</h2>
    <ul class="list-group">
      <li v-for="v in videos" :key="v.id" class="list-group-item text-left">
        {{ v.title }}
        <router-link :to="{ name: 'videos/id', params: { id: v.id } }"
          ><span class="float-end badge bg-secondary">듣기</span></router-link
        >
      </li>
    </ul>
    <!-- 중첩되어서 들어갈 자리를 만들어주어야함. -->
    <router-view></router-view>
  </div>
</template>

<script>
import { inject } from 'vue';
export default {
  name: 'Videos',
  setup() {
    const videos = inject('videos');

    return { videos };
  },
};
</script>

<style></style>

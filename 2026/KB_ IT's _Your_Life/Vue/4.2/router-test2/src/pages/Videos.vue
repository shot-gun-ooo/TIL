<template>
  <div class="card card-body">
    <h2>Videos</h2>
    <ul class="list-group">
      <li v-for="v in videos" :key="v.id" class="list-group-item text-left">
        {{ v.title }} <span class="float-end badge bg-secondary">듣기</span>
      </li>
    </ul>
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

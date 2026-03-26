<template>
  <div class="header">
    <h1 class="headerText">태평양 전쟁의 해전</h1>
    <nav>
      <ul class="nav nav-tabs nav-fill">
        <li v-for="tab in tabs" :key="tab.label" class="nav-item">
          <a
            style="cursor: pointer"
            class="nav-link"
            :class="{ active: tab.id === currentTab }"
            @click="changeTab(tab.id)"
            >{{ tab.label }}</a
          >
        </li>
      </ul>
    </nav>
  </div>

  <div>
    <KeepAlive>
      <Suspense timeout="0">
        <template #default>
          <component :is="currentTab" />
        </template>
        <template #fallback>
          <Loading />
        </template>
      </Suspense>
    </KeepAlive>
  </div>
</template>

<script>
// 1. defineAsyncComponent 이름 정확히 수정
import { defineAsyncComponent, markRaw } from 'vue';
import pMinDelay from 'p-min-delay';
// 2. 경로를 실제 파일이 있는 'dynamic' 폴더로 통일
import Loading from './components/dynamic/Loading.vue';

// 비동기 컴포넌트 정의 (경로를 모두 dynamic으로 수정했습니다)
const CoralSeaTab = markRaw(
  defineAsyncComponent(() =>
    pMinDelay(import('./components/dynamic/CoralSeaTab.vue'), 1000),
  )
);
const MidwayTabChart = markRaw(
  defineAsyncComponent(() =>
    pMinDelay(import('./components/dynamic/MidwayTabChart.vue'), 2000),
  )
);
const LeyteGulfTab = markRaw(
  defineAsyncComponent(() =>
    pMinDelay(import('./components/dynamic/LeyteGulfTab.vue'), 5000),
  )
);

export default {
  name: 'App',
  components: { Loading },
  data() {
    return {
      currentTab: CoralSeaTab,
      tabs: [
        { id: CoralSeaTab, label: '산호해 해전' },
        { id: MidwayTabChart, label: '미드웨이 해전' },
        { id: LeyteGulfTab, label: '레이테만 해전' },
      ],
    };
  },
  methods: {
    changeTab(tab) {
      this.currentTab = tab;
    },
  },
};
</script>

<style scoped>
/* 필요한 스타일이 있다면 여기에 추가하세요 */
.header { margin-bottom: 20px
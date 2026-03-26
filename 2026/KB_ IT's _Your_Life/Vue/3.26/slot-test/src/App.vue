<template>
  <div>
    <NoSlotTest />
    <br />
    <br />
    <NoSlotTest2 />
    <br />
    <br />
  </div>
</template>

<script>
import NoSlotTest from './components/NoSlotTest.vue';
import NoSlotTest2 from './components/NoSlotTest2.vue';
export default {
  name: 'App',
  components: { NoSlotTest: NoSlotTest, NoSlotTest2 },
};
</script>

<style></style>

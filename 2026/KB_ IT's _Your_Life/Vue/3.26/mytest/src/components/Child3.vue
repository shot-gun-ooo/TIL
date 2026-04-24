<template>
  <div :class="$style.child">
    <h2>Child3</h2>
  </div>
</template>
<script>
export default { name: 'Child3' ,
  created (){
    console.log('module활용')
  }
};

</script>
<style module >
.child {
  background-color: orange; /* 1번은 노란색 */
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>

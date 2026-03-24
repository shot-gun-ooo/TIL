<template>
  <li>
    <input type="checkbox" :checked="checked" @click="toggle" />
    {{ id }} - {{ name }}
  </li>
</template>

<script>
export default { 
    // 이 파일의 설정값들을 밖으로 내보내서 
    // 다른 파일(App.vue)이 읽을 수 있게 합니다.
    name : "CheckboxItem",
    props:['id', 'name', 'checked']
    // <template>에서 썼던 변수명들을 여기에 똑같이 적어줘야 
    // 컴퓨터가 "아, 이 글자들은 부모가 나중에 채워줄 데이터구나!"라고 알아먹습니다. 
    methods:{
        toggle(){
            this.$emit('check-changed', this.id)

        }
    }

}



</script>
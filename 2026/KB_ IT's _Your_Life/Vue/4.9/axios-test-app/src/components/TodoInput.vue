<template>
  <div>
    <input v-model="newText" placeholder="할 일 입력" />
    <button @click="submit">추가</button>
    
  </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue'
const newText = ref('')
const emit = defineEmits(['add-todo'])
const submit =()=>{emit('add-todo', newText.value)
newText.value=''

}


</script>
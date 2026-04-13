<template>
  <div>
    <h1>{{ userName }}님의 리스트</h1>
    <TodoInput @add-todo="addTodo" />
    <div style="margin: 20px 0">
      검색:
      <input v-model="searchQuery" placeholder="찾으실 내용을 입력하세요" />
    </div>

    <hr />
    <TodoList
      :todos="filteredTodoList"
      @remove="deleteTodo"
      @toggle="toggleTodo"
    ></TodoList>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import axios from 'axios';
import TodoInput from './components/TodoInput.vue';
import TodoList from './components/TodoList.vue';

const searchQuery = ref('');
const userName = ref('홍길동');
const todoList = ref([]);
// const addTodo = (text) => {
//   todoList.value.push({ id: Date.now(), text, done: false });
//   console.log('추가해써용');
// };
const addTodo = async (text) => {
  try {
    const response = await axios.post('http://localhost:3000/todos', {
      text: text, // 입력받은 글자
      done: false, // 기본값은 미완료
    });
    todoList.value.push(response.data);
  } catch (error) {
    console.error('추가 실패', error);
  }
};
// const deleteTodo = (id) => {
//   todoList.value = todoList.value.filter((item) => item.id != id);
// };
const deleteTodo = async (id) => {
  try {
    // 1. 서버에 삭제 무전 보내기 (DELETE 요청)
    // 주소 뒤에 /${id}를 붙여서 정확히 어떤 놈을 지울지 알려줍니다.
    await axios.delete(`http://localhost:3000/todos/${id}`);

    // 2. 서버에서 지워졌다면? 이제 우리 화면(데이터)에서도 지워줍니다.
    todoList.value = todoList.value.filter((item) => item.id !== id);

    console.log(`${id}번 할 일이 서버와 화면에서 모두 사라졌습니다!`);
  } catch (error) {
    console.error('삭제 실패:', error);
    alert('서버 통신 오류로 삭제하지 못했습니다.');
  }
};
// const toggleTodo = (id) => {
//   todoList.value = todoList.value.map((item) => {
//     if (item.id === id) {
//       item.done = !item.done;
//     }
//     return item;
//   });
// };
const toggleTodo = async (id) => {
  // 1. 현재 리스트에서 수정할 대상을 먼저 찾습니다.
  const target = todoList.value.find((item) => item.id === id);
  if (!target) return;

  try {
    // 2. 서버에 "이 ID를 가진 항목의 done 상태를 반대로 바꿔줘!"라고 요청합니다.
    const response = await axios.patch(`http://localhost:3000/todos/${id}`, {
      done: !target.done, // 현재 상태의 반대값 전송
    });

    // 3. 서버 수정이 성공하면, 우리 화면의 데이터도 서버가 보내준 최신 데이터로 업데이트!
    todoList.value = todoList.value.map((item) => {
      if (item.id === id) {
        return response.data; // 서버에서 받은 수정된 객체로 교체
      }
      return item;
    });

    console.log(`${id}번 상태 변경 완료!`);
  } catch (error) {
    console.error('상태 변경 실패', error);
  }
};
const filteredTodoList = computed(() => {
  if (!searchQuery.value) {
    return todoList.value;
  }
  return todoList.value.filter((item) => {
    return item.text.includes(searchQuery.value);
  });
});
// 앱이 시작될 때 데이터를 가져올 함수
const fetchTodos = async () => {
  isLoading.value = true; // 1. 시작할 때 로딩 스위치 ON!
  try {
    const response = await axios.get('http://localhost:3000/todos');
    todoList.value = response.data;
    console.log('데이터 로드 성공:', response.data);
  } catch (error) {
    console.error('데이터 로드 실패:', error);
  } finally {
    isLoading.value = false; // 2. 성공하든 실패하든 마지막엔 로딩 스위치 OFF!
  }
};


// ... 기존 코드 아래에 추가 ...

// 컴포넌트가 화면에 나타날 때(마운트될 때) fetchTodos를 실행해라!
onMounted(() => {
  fetchTodos();
});
</script>

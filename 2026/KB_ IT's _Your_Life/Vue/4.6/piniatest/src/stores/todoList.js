import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';

export const useTodoListStore = defineStore('todoList', () => {
  //states(컴포넌트에 공유하고 싶은 변수)
  const state = reactive({
    todoList: [
      { id: 1, todo: 'ES6학습', done: false },
      { id: 2, todo: 'React학습', done: false },
      { id: 3, todo: 'ContextAPI 학습', done: true },
      { id: 4, todo: '야구경기 관람', done: false },
    ],
    
  });
  //actions(컴포넌트에 공유하고 싶은 함수)
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };
  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1);
  };
  const toggleDone = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };
  //getters(미리 계산한 값을 다른 컴포넌트에서 가져다 쓰고 싶은 변수)
  //computed() //computed안에는 항상 화살표 함수
  //되도록이면 state(변수)에 정의된 이름으로 return, 외부 컴포넌트에서 써주세요!
  const todoList = computed(()=> state.todoList);
  const doneCount = computed(() => {
    return state.todoList.filter((todoItem) => todoItem.done === true).length;
    //배열명.filter(화살표함수) --> 배열에 있는 요소를 하나씩 꺼내서 화살표함수에 정의된 조건이 True인 것만 
    //배열에 묶어줌.[]
    //배열명.filter(화살표함수).length --> 배열으 개수를 구해줌(1)
  });

  return { state, addTodo, deleteTodo, toggleDone, todoList, doneCount };
});

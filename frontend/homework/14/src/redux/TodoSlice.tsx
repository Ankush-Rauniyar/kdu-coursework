import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface Todo {
  id: number;
  text: string;
}

interface TodosState {
  searchTerm: string;
  todos: Todo[];
  filteredTodos: Todo[];
}

const initialState: TodosState = {
  searchTerm: "",
  todos: [],
  filteredTodos: [],
};

const TodosSlice = createSlice({
  name: "todos",
  initialState,
  reducers: {
    addTodo: (state, action: PayloadAction<string>) => {
      state.todos.push({ id: state.todos.length + 1, text: action.payload } as Todo);
    },
    deleteTodo: (state, action: PayloadAction<number>) => {
      state.todos = state.todos.filter((todo) => todo.id !== action.payload);
      state.filteredTodos = state.filteredTodos.filter((todo) => todo.id !== action.payload);
    },
    setSearchTerm: (state, action: PayloadAction<string>) => {
      state.searchTerm = action.payload;
      state.filteredTodos = state.todos.filter((todo) => todo.text.includes(state.searchTerm));
    },
  },
});

export const { addTodo, deleteTodo, setSearchTerm } = TodosSlice.actions;
export default TodosSlice.reducer;

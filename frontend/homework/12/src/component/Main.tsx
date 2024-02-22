import React, { createContext, useContext, useState } from "react";
import Header from "./Header";
import Section from "./Section";
import { SearchContextProp, SearchProviderProp, Todo, TodoContextProp, TodoContextProviderProp } from "./Interfaces";


export const SearchContext = createContext<SearchContextProp>({
  search: "",
  changeSearch: (word: string) => {},
});

const SearchProvider = ({ children }: SearchProviderProp) => {
  const [search, setSearch] = useState("");
  const changeSearch = (currentWord: string) => {
    setSearch(currentWord);
  };
  return (
    <SearchContext.Provider value={{ search, changeSearch }}>
      {children}
    </SearchContext.Provider>
  );
};


export const TodoContext = createContext<TodoContextProp>({
  todos:[],
  addTodo:(newTodo:string)=>{},
  deleteTodo:(id:number)=>{},
  filterTodo:[]
})


const TodoContextProvider = ({children}: TodoContextProviderProp)=>{
  const {search} = useContext(SearchContext);
  const [todos,setTodos] = useState<Todo[]>([]);
  const addTodo = (newTodo : string)=>{
    const current : Todo = {
      id:todos.length+ 1,
      text:newTodo
    }
    setTodos((prevTodos) => [...prevTodos, current]);
  }

  const deleteTodo = (currentId:number)=>{
    setTodos((prevTodos)=> prevTodos.filter((todo)=>todo.id !== currentId));
  }

  const filterTodo = todos.filter((todo)=>{
    return todo.text.toLowerCase().includes(search.toLowerCase());
  });

  return(
    <TodoContext.Provider value={{todos,addTodo,deleteTodo,filterTodo}}>
      {children}
    </TodoContext.Provider>
  )
}


const Main: React.FC = () => {
  return (
    <div>
      <SearchProvider>
        <Header />
        <TodoContextProvider>
        <Section/>
        </TodoContextProvider>
      </SearchProvider>
    </div>
  );
};

export default Main;

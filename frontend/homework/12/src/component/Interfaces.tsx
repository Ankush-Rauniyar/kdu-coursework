import { ReactNode } from "react";

export interface SearchContextProp{
    search:string,
    changeSearch: (word:string) => void
}

export interface SearchProviderProp{
    children : ReactNode;
}

export interface TodoContextProp{
    todos:Todo[],
    addTodo:(newTodo:string)=>void;
    deleteTodo:(id:number)=>void;
    filterTodo: Todo[]
}

export interface Todo {
    id: number;
    text: string;
}

export interface TodoContextProviderProp{
    children: React.ReactNode;
}

export interface TodoContextProviderProp{
    children: React.ReactNode;
}
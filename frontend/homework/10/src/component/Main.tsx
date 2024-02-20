// Main.tsx
import React, { useState } from 'react';
import Header from './Header';
import Section from './Section';

interface Todo {
  id: number;
  text: string;
}

const Main: React.FC = () => {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [searchTerm, setSearchTerm] = useState<string>('');

  const handleSearchChange = (searchTerm: string) => {
    setSearchTerm(searchTerm);
  };

  const handleAddTodo = (todoText: string) => {
    const newTodo: Todo = {
      id: todos.length + 1,
      text: todoText,
    };
    setTodos((prevTodos) => [...prevTodos, newTodo]);
  };

  const handleDeleteTodo = (todoId: number) => {
    setTodos((prevTodos) => prevTodos.filter((todo) => todo.id !== todoId));
  };

  const filteredTodos = todos.filter((todo) =>
    todo.text.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div>
      <Header onSearchChange={handleSearchChange} />
      <Section onAddTodo={handleAddTodo} onDeleteTodo={handleDeleteTodo} todos={filteredTodos} />
    </div>
  );
};

export default Main;

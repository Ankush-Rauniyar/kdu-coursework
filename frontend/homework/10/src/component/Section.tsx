import React, { useState } from 'react';
import './Section.css';

interface SectionProps {
  onAddTodo: (todoText: string) => void;
  onDeleteTodo: (todoId: number) => void;
  todos: { id: number; text: string }[];
}

const Section: React.FC<SectionProps> = ({ onAddTodo, onDeleteTodo, todos }) => {
  const [newTodo, setNewTodo] = useState<string>('');

  const handleAddTodo = () => {
    if (newTodo.trim() !== '') {
      onAddTodo(newTodo);
      setNewTodo('');
    }
  };

  return (
    <div className='second-container'>
      <div>
        <h2>Add Items</h2>
        <input
          type="text"
          className='item-input'
          value={newTodo}
          onChange={(e) => setNewTodo(e.target.value)}
        />
        <button className='add-button' onClick={handleAddTodo}>Submit</button>
      {todos.length === 0 ? (
        <p>No Match found</p>
      ) : (
        <ul>
          {todos.map((todo) => (
            <li className='item' key={todo.id}>
              {todo.text}
              <button onClick={() => onDeleteTodo(todo.id)}className='delete-button'>X</button>
            </li>
          ))}
        </ul>
      )}
      </div>
    </div>
  );
};

export default Section;

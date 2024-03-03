import React, { useContext, useState } from 'react';
import './Section.css';
import { TodoContext } from './Main';

function Section(){
  const [newTodo, setNewTodo] = useState<string>('');

  const{addTodo,deleteTodo,filterTodo} = useContext(TodoContext);

  const handleAddTodo = () => {
    if (newTodo.trim() !== '') {
      addTodo(newTodo);
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
      {filterTodo.length === 0 ? (
        <p>No Match found</p>
      ) : (
        <ul>
          {filterTodo.map((todo) => (
            <li className='item' key={todo.id}>
              {todo.text}
              <button onClick={() => deleteTodo(todo.id)}className='delete-button'>X</button>
            </li>
          ))}
        </ul>
      )}
      </div>
    </div>
  );
};

export default Section;

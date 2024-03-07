import React, { useState } from 'react';
import '../styles/Section.css';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../redux/Store';
import { addTodo, deleteTodo,removeTodosCheckBox,deleteSelectedTodos} from '../redux/TodoSlice';

function Section() {
  const todos = useSelector((state: RootState) => state.todos.todos);
  const filterTodos = useSelector((state: RootState) => state.todos.filteredTodos);
  const search = useSelector((state: RootState) => state.todos.searchTerm);
  const rem = useSelector((state: RootState) => state.todos.removeTodos);
  const dispatch = useDispatch();
  const [current, setCurrent] = useState<string>("");

  const updateCurrent = (event: React.ChangeEvent<HTMLInputElement>) => {
    const curValue = event.target.value;
    setCurrent(curValue);
  };

  const handleAddTodo = () => {
    dispatch(addTodo(current));
    setCurrent("");
  };

  const onDeleteTodo = (id: number) => {
    dispatch(deleteTodo(id));
  };

  const removingTodosCheck = (id : number) =>{
    dispatch(removeTodosCheckBox(id));
  }

  const deletingTodos = () => {
    if (rem.length === 0) {
      alert('select items to delete');
    } else {
      dispatch(deleteSelectedTodos(true));
    }
  }
  
  const showTodos = search === "" ? todos : filterTodos;

  return (
    <div className='second-container'>
      <div>
        <h2>Add Items</h2>
        <input
          type="text"
          className='item-input'
          value={current}
          onChange={updateCurrent}
        />
        <button className='add-button' onClick={handleAddTodo}>
          Submit
        </button>
        <button className='add-button' onClick={deletingTodos}>
          Remove todos
        </button>
        {showTodos.length === 0 ? (
          <p>No Match found</p>
        ) : (
          <ul>
            {showTodos.map((todo) => (
              <li className='item' key={todo.id}>
                <input 
                className='checkbox-input'
                  type='checkbox'
                  onClick={() => removingTodosCheck(todo.id)}
                />
                <div className='inner-item'>
                {todo.text}
                <button onClick={() => onDeleteTodo(todo.id)} className='delete-button'>
                  X
                </button>
                </div>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}

export default Section;

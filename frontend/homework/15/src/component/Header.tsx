import React from 'react';
import '../styles/Header.scss';
import { useDispatch } from 'react-redux';
import {  setSearchTerm } from '../redux/TodoSlice';

function Header() {
  const dispatch = useDispatch();

  function modifySearchTerm(event: React.ChangeEvent<HTMLInputElement>) {
    const newSearchTerm = event.target.value;
    dispatch(setSearchTerm(newSearchTerm));
  }

  return (
    <div className='head-container'>
      <h1 data-testid="title-todo">Item Lister</h1>
      <input
        type="text"
        placeholder="Search Items..."
        onChange={modifySearchTerm}
        className='search-input'
      />
    </div>
  );
}

export default Header;

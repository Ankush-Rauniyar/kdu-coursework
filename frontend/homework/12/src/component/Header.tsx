import React, { useContext } from 'react';
import './Header.css'
import { SearchContext } from './Main';


function Header(){
  const {changeSearch} = useContext(SearchContext);

  return (
    <div className='head-container'>
      <h1>Item Lister</h1>
      <input
        type="text"
        placeholder="Search Items..."
        onChange={(e) => changeSearch(e.target.value)}
      className='search-input'/>
    </div>
  );
};

export default Header;

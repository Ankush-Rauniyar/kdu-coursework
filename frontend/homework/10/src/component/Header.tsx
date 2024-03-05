import React from 'react';
import './Header.css'

interface HeaderProps {
  onSearchChange: (searchTerm: string) => void;
}

const Header: React.FC<HeaderProps> = ({ onSearchChange }) => {
  return (
    <div className='head-container'>
      <h1>Item Lister</h1>
      <input
        type="text"
        placeholder="Search Items..."
        onChange={(e) => onSearchChange(e.target.value)}
      className='search-input'/>
    </div>
  );
};

export default Header;

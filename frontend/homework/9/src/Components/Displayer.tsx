import React from 'react';
import './Displayer.css';

interface IUser{
    name:string,
    fullName:string,
    qualification : string

}
interface IUserItem{
    userItem:IUser;
}
export function Displayer({userItem}:Readonly<IUserItem>) {
  return (
    <div>
      <h1 className='name'>{userItem.name}</h1>
      <h3 className='fullName'>{userItem.fullName}</h3>
      <h1 className='qualification'>{userItem.qualification}</h1>
    </div>
  )
}

import React from 'react'

import './Hobby.css'

interface IHobby{
    id:number,
    hobby:string
}

interface IHobbies{
    hobbiesArray:IHobby[];
}
export  function Hobby({hobbiesArray}:Readonly<IHobbies>) {
  return (
    <div className='hobby-container'>
        <h1 className='heading'>Hobbies</h1>
                <ul>
        {hobbiesArray.map((currentHobby) => (
          <li key={currentHobby.id}>{currentHobby.hobby}</li>
        ))}
        </ul>
    </div>
  )
}

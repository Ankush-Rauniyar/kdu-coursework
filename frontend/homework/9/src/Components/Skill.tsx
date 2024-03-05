import React from 'react'
import './SKill.css';
interface ISkill{
    id:number,
    skill:string
}
interface ISkills{
    skillArray:ISkill[];
}

export  function Skill({skillArray} : Readonly<ISkills>) {
  return (
    <div className='skill-container'>
        <h1 className='heading'>Skills</h1>
        <ul>
        {skillArray.map((currentSkill) => (
          <li key={currentSkill.id}>{currentSkill.skill}</li>
        ))}
        </ul>
    </div>
  )
}

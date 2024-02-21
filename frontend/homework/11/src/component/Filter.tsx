import React from 'react'

import './Filter.scss'
interface IFilterProp{
    filters:string[];
    onDeleteFilter: (filter: string) => void;
}
export function Filter({filters,onDeleteFilter }:IFilterProp) {
  return (
<div className='navigation'>
  Filters
      {filters.map((filter, index) => (
        <div className='filter-item__container' key={index} style={{ display: 'inline-block', margin: '4px' }}>
          <span className='filter-item'>{filter}</span>
          <button className='delete-button' onClick={() => onDeleteFilter(filter)}>X</button>
        </div>
      ))}
    </div>
  )
}

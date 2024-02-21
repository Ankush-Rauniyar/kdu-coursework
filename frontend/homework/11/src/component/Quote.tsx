import React from 'react'
import { APIQuote } from '../types/ApiQuote'
import './Quote.scss'

interface QuoteProps{
    setFilter:React.Dispatch<React.SetStateAction<string[]>>
    quote : APIQuote;
}
export function Quote({setFilter,quote}: QuoteProps) {

    function filterTheQuotes(event: React.MouseEvent<HTMLSpanElement>) {
        let selectedTag = event.currentTarget.textContent || '';
      
        setFilter((prevValue) => {
          if (!prevValue.includes(selectedTag)) {
            return [...prevValue, selectedTag];
          }
          return prevValue;
        });
      }
      
  return (
    <div className='quote-container'>
      <h2>{quote.content}</h2>
      <p className='author'>~{quote.author}</p>
      <p>{quote.dateAdded}</p>


      <div className='tags-container'>
        {quote.tags.map((q)=>{
            return <span key={q} onClick={filterTheQuotes} className='tag-item'>{q}</span>
        })}
      </div>
    </div>
  );
}

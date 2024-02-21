import React, { useEffect, useState } from "react";
import "./App.scss";
import { APIQuote } from "./types/ApiQuote";
import { Quote } from "./component/Quote";
import { Filter } from "./component/Filter";

function App() {
  let [quotes, setQuotes] = useState<APIQuote[]>([]);

  const [filterArray, setFilterArray] = useState<string[]>([]);

  // useEffect(()=>{

  //   setFilterArray((prevQuotes)=>{
  //     quotes.filter((quote)=>{
  //     return quote.content.includes(search)
  //   })
  // })
  // },[search]);

  // const onSearchChangeHandler = (e:React.ChangeEvent<HTMLInputElement>) =>{
  //   setSearch(e.target.value);
  // }

  function addAQuote() {
    fetch("https://api.quotable.io/quotes/random")
      .then((response) => response.json())
      .then((data: APIQuote[]) => {
        setQuotes([...data, ...quotes]);
        console.log(quotes);
      });
  }

  const handleDeleteFilter = (filterArray: string) => {
    setFilterArray((prevFilters) => prevFilters.filter((f) => f !== filterArray));
  };

  useEffect(() => {
    //this runs only once
    fetch("https://api.quotable.io/quotes/random?limit=3")
      .then((response) => response.json())
      .then((data: APIQuote[]) => {
        setQuotes(data);
      });
    console.log("fetched 3", quotes);
  }, []);

  const filteredQuotes = quotes.filter(
    (quote) =>
      filterArray.length === 0 ||
      filterArray.some((tag) => quote.tags.includes(tag))
  );

  return (
    <div className="main-container">
      <button onClick={addAQuote} id="new-quote_button">NEW QUOTE</button>
      <Filter filters={filterArray} onDeleteFilter={handleDeleteFilter}/>
      {filteredQuotes.map((quote) => {
        return (
          <Quote setFilter={setFilterArray} key={quote._id} quote={quote} />
        );
      })}
    </div>
  );
}

export default App;

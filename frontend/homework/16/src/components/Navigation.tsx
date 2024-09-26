import { useState } from "react"

import "./styles/Navigation.scss"
import { useDispatch } from "react-redux";
import { setSortTerm,setSearchTerm, showSearchProducts, filterProducts } from "../redux/ProductSlice";


export function Navigation() {
    const [searchItem,setSearchItem] = useState<string>('');

    const dispatch = useDispatch();

    const updateFiltering = (event : React.ChangeEvent<HTMLSelectElement>) => {
      const selectedFilter : string= event.target.value;
      console.log(selectedFilter);
      dispatch(filterProducts(selectedFilter));
    };
  
    const handleSortChange = (event:React.ChangeEvent<HTMLSelectElement>) => {
      const selectedSort = event.target.value;
      dispatch(setSortTerm(selectedSort));
    };
    const updateSearchItem = (event : React.ChangeEvent<HTMLInputElement>)=>{
        const searching = event.target.value;
        setSearchItem(searching);
        console.log('changing search');
    }

    const showUpdatedArray = ()=>{
        dispatch(setSearchTerm(searchItem));
        dispatch(showSearchProducts());
        console.log('updating search result');
    }

  return (
    <div className="navigation-container">
        <div className="search-container">
            <input type="text" value={searchItem}  placeholder="search Items.." onChange={updateSearchItem}></input>
            <button onClick={showUpdatedArray}>Search</button>
        </div>
        <div className="filter_sort-container">
            <span>Filter</span>
        <select name="filter" onChange={updateFiltering}>
            <option value="none">None</option>
            <option value="electronics">Electronics</option>
            <option value="jewelery">Jewelry</option>
            <option value="men's clothing">Men's Clothing</option>
            <option value="women's clothing">Women's Clothing</option>
        </select>
        <span>Sort</span>
        <select name="sort" onChange={handleSortChange}>
            <option value="none">None</option>
            <option value="price">Price</option>
            <option value="rating">Rating</option>
        </select>
        </div>
    </div>
  )
}

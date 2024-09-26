import {  useEffect } from "react";
import { Navigation } from "./Navigation";
import { Section } from "./Section";
import { fetchProductsFromAPI } from "../redux/FetchAPI";
import { useDispatch } from "react-redux";


export function Main() {
    const dispatch = useDispatch();
    useEffect(()=>{
        dispatch(fetchProductsFromAPI());
    },[dispatch])
  return (
    <div>
          <Navigation />
          <Section />
    </div>
  );
}

import { createAsyncThunk } from "@reduxjs/toolkit";


export const fetchProductsFromAPI = createAsyncThunk(
    "fetchingProducts",
    async()=>{
        try{
        const reponse = await fetch("https://fakestoreapi.com/products");
        const data = await reponse.json();
        return data;
        }catch(error){
            console.log(" error encountered");
            throw error;
        }
    }
)
import { createSlice } from "@reduxjs/toolkit";
import { fetchProductsFromAPI } from "./FetchAPI";

interface SnackBarStateProp{
    status:string,
    message:string,
}

const initialState:SnackBarStateProp = {
    status:"",
    message:"",
}

const SnackBarSlice = createSlice({
    name:"snackbar",
    initialState,
    reducers:{
    },
    extraReducers:(builder)=>{
        builder.addCase(fetchProductsFromAPI.fulfilled,(state)=>{
            state.status="success",
            state.message="Fetched products successfully from the API";
        })
        builder.addCase(fetchProductsFromAPI.rejected,(state)=>{
            state.status="error";
            state.message="Error while fetching data from API. Try Again"
        })
    }
});

export default SnackBarSlice.reducer;
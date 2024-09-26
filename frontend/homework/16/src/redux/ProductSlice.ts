import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { IItem } from "../components/interfaces/APIInterfaces";
import { fetchProductsFromAPI } from "./FetchAPI";

interface ProductState{
    products:IItem[],
    status : string,
    searchTerm:string,
    errorMessage:string,
    filteredProducts:IItem[],
    filterTerm:string,
}

const initialState:ProductState ={
    products:[],
    status:"pending",
    errorMessage:"",
    searchTerm:"",
    filteredProducts:[],
    filterTerm:""
}
const ProductSlice = createSlice({
    name:"products",
    initialState,
    reducers:{
        setSearchTerm:(state,action: PayloadAction<string>)=>{
            state.searchTerm = action.payload;
        },
        setSortTerm:(state,action:PayloadAction<string>)=>{
            state.filterTerm = action.payload;
            if(action.payload == "price"){
                state.filteredProducts = state.filteredProducts.sort((product1,product2)=>product1.price - product2.price);
            }else{
                state.filteredProducts = state.filteredProducts.sort((product1,product2)=>product2.rating.rate - product1.rating.rate);
            }
        },
        showSearchProducts:(state)=>{
            state.filteredProducts = state.filteredProducts.filter((product)=>{
                return product.title.toLowerCase().includes(state.searchTerm.toLowerCase());
            });
            console.log(state.searchTerm);
            console.log(state.filteredProducts);
        },
        filterProducts:(state,action:PayloadAction<string>)=>{
            state.filteredProducts = state.filteredProducts.filter((product)=>{
                return product.category === action.payload;
            })
        }
    },
    extraReducers: (builder)=>{
        builder.addCase(fetchProductsFromAPI.pending,(state)=>{
            state.status = "pending";
        })
        builder.addCase(fetchProductsFromAPI.fulfilled,(state,action)=>{
            state.products = action.payload;
            state.filteredProducts = action.payload;
            state.status="success";
        })
        builder.addCase(fetchProductsFromAPI.rejected,(state)=>{
            state.status = "error";
            console.log(state.status);
            state.errorMessage = "Error while fetching data"
        })
    }
})

export const {setSortTerm,setSearchTerm,showSearchProducts,filterProducts} = ProductSlice.actions;

export default ProductSlice.reducer;
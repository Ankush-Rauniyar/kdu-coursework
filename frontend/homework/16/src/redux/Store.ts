import { configureStore } from "@reduxjs/toolkit";

import productReducer from "./ProductSlice";
import snackBarSlice from "./SnackBarSlice";
export const store = configureStore({
    reducer:{
        products:productReducer,
        snackbar: snackBarSlice,
    },
})

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
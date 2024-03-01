import {PayloadAction, createSlice} from "@reduxjs/toolkit";
import { AddOn, Currency, RoomType } from "../component/Interfaces";
import { fetchRoomAvailableFromAPI } from "./FetchRoomTypes";

interface RoomsState{
    availableRooms : RoomType[],
    status:string,
    errorMessage:string,
    currentRoomType:RoomType,
    startDate:Date,
    endDate:Date,
    extraFeatures:AddOn[],
    total:number,
    checkFirst:boolean,
    checkLast:boolean,
}

const initialState : RoomsState = {
availableRooms:[],
status:"",
errorMessage:"",
currentRoomType:{
    id: -1,
    name: "demo",
    costPerNight: "demo",
    currency: Currency.Inr,
    addOns:[]
},
startDate:new Date(),
endDate:new Date(),
extraFeatures:[],
total:0,
checkFirst:false,
checkLast:false,
}

const RoomsState = createSlice({
    name:"rooms",
    initialState,
    reducers:{
        addRoomPreference : (state,action:PayloadAction<number>)=>{
            console.log(action.payload);
            console.log(state.currentRoomType);
            const currentRoom:RoomType[] = state.availableRooms.filter((room)=>{
                console.log(room.id,action.payload)
                return room && room.id == action.payload;
            });
            console.log(currentRoom[0]);
            state.currentRoomType = currentRoom[0];
            state.extraFeatures= [];
            state.total = parseInt(state.currentRoomType.costPerNight);
        },
        addFeatureToRoom:(state,action:PayloadAction<string>)=>{
            const feature = state.currentRoomType.addOns.filter((currentFeature)=>{
                return currentFeature && currentFeature.name == action.payload;
            });
            state.total += parseInt(feature[0].cost);
            state.extraFeatures.push(feature[0]);
        },
        addStartDate:(state,action:PayloadAction<string>)=>{
            state.startDate = new Date(action.payload);
            state.checkFirst = true;
        },
        addEndDate:(state,action:PayloadAction<string>)=>{
            state.endDate = new Date(action.payload);
            const totalTime  = state.endDate.getTime() - state.startDate.getTime();
            const totalDays = totalTime/(1000*60*60*24);
            state.total = parseInt(state.currentRoomType.costPerNight) * totalDays;
            state.checkLast = true;
        }

    },
    extraReducers:(builder)=>{
        builder.addCase(fetchRoomAvailableFromAPI.pending,(state)=>{
            state.status = "pending";
        })
        builder.addCase(fetchRoomAvailableFromAPI.fulfilled,(state,action)=>{
            state.status = "success";
            state.availableRooms = action.payload.roomTypes;
        })
        builder.addCase(fetchRoomAvailableFromAPI.rejected,(state)=>{
            state.status = "error";
            state.errorMessage ="error encountered while fetching from API";
        })
    }
})
export const {addRoomPreference,addFeatureToRoom,addEndDate,addStartDate} = RoomsState.actions;
export default RoomsState.reducer;
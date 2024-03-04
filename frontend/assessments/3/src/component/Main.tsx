import  { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { fetchRoomAvailableFromAPI } from '../redux/FetchRoomTypes';
import { RootState } from '../redux/Store';
import { RoomTypeComp } from './RoomTypeComp';
import { DateDetails } from './DateDetails';
import { AddOns } from './AddOns';
import { Calculation } from './Calculation';




export function Main() {
  const dispatch = useDispatch();
  useEffect(()=>{
    dispatch(fetchRoomAvailableFromAPI());
  },[]);

  const rooms = useSelector((state:RootState)=>state.rooms.availableRooms);
  console.log(rooms);
  return (
    <div>
      <RoomTypeComp/>
      <DateDetails/>
      <AddOns/>
      <Calculation/>
    </div>
  )
}

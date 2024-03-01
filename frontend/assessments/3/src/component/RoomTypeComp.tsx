import { useDispatch, useSelector } from 'react-redux'
import { RootState } from '../redux/Store'
import {createUseStyles} from 'react-jss';
import { addRoomPreference } from '../redux/RoomSlice';

 const useStyles = createUseStyles({
    titleRoomTypeContainer:{
        backgroundColor:"#f08a5d",
        color:"#ffffff",
        padding:"1rem",
        margin:"1rem",
        fontSize:"1.5rem",
    },
    contentRoomTypeContainer:{
        display:"flex",

        "& li":{
            listStyle:"none",
            padding:"1rem",
            border:"1px solid #f08a5d",
            margin:"1rem"
        }
    }
 })

export  function RoomTypeComp() {
    const roomsAvailable = useSelector((state:RootState)=>state.rooms.availableRooms);
    const dispatch = useDispatch();
    const classes = useStyles();

    const storeRoomType = (event)=>{
        const val = event.target.value;
        console.log(val);
        dispatch(addRoomPreference(val));
    }

  return (
    <div>
      <div className={classes.titleRoomTypeContainer}>
        Select Room Type
      </div>
      <div>
        <ul className={classes.contentRoomTypeContainer}>
            {roomsAvailable.map((currentRoomType)=>{
                return <li key={currentRoomType.id} value={currentRoomType.id} onClick={storeRoomType}>{currentRoomType.name}</li>
            })}
        </ul>
      </div>
    </div>
  )
}

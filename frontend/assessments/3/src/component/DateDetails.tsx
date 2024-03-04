import {createUseStyles} from 'react-jss';
import { useDispatch, useSelector } from 'react-redux';
import { addStartDate, addEndDate } from '../redux/RoomSlice';
import { RootState } from '../redux/Store';

const useStyles = createUseStyles({
    titleDateTypeContainer:{
        backgroundColor:"#f08a5d",
        color:"#ffffff",
        padding:"1rem",
        margin:"1rem",
        fontSize:"1.5rem",
    },
    contentDateTypeContainer:{
        display:"flex",
        margin:"2rem",

        "& input":{
            listStyle:"none",
            padding:"1rem",
            border:"1px solid #f08a5d",
            margin:"1rem"
        }
    }
 })


export function DateDetails() {
    const classes = useStyles();
    const start = useSelector((state:RootState)=>state.rooms.startDate);
    const dispatch = useDispatch();
    const currentRoom = useSelector((state:RootState)=>state.rooms.currentRoomType);

    const updateStartDate = (event: { target: { value: string; }; })=>{
        if(currentRoom.id == -1){
            return alert("Please Select A room Type first");
        }
        const val = event.target.value as string;
        dispatch(addStartDate(val));
    }

    const updateEndDate = (event: { target: { value: string; }; })=>{
        if(currentRoom.id == -1){
            return alert("Please Select A room Type first");
        }
        const val = event.target.value as string;
        const now = new Date(val);
        const diff = now.getTime() - start.getTime();
        if(diff < 0){
            return alert('End date should be after start Date');
        }
        dispatch(addEndDate(val));
    }

  return (
    <div>
      <div className={classes.titleDateTypeContainer}>
        Select Date
      </div>
      <div className={classes.contentDateTypeContainer}>
        <input type='date' onChange={updateStartDate}></input>
        <input type='date' onChange={updateEndDate}></input>
      </div>
    </div>
  )
}

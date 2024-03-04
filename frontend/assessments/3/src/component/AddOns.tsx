import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../redux/Store';
import { createUseStyles } from 'react-jss';
import { addFeatureToRoom } from '../redux/RoomSlice';

const useStyles = createUseStyles({
    addOnTitleContainer:{
        backgroundColor:"#f08a5d",
        color:"#ffffff",
        padding:"1rem",
        margin:"1rem",
        fontSize:"1.5rem",
    },
    addonContentContainer:{
        display:"flex",

        "& li":{
            listStyle:"none",
            padding:"1rem",
            border:"1px solid #f08a5d",
            margin:"1rem"
        }
    }
 })

export function AddOns() {
    const currentRoomSelected = useSelector((state:RootState)=>state.rooms.currentRoomType);
    const addOnsGiven = currentRoomSelected.addOns;
    const dispatch = useDispatch();
    const classes = useStyles();

    const storeFeatures=(event: { target: { id: string; }; })=>{
        const val = event.target.id as string;
        console.log(val);
        
        dispatch(addFeatureToRoom(val));
    }
  return (
    <div>
        <div className={classes.addOnTitleContainer}>
            Selected additional add ons/preferences
        </div>
        <div>
            {currentRoomSelected.id == -1 ? <div>
                Please Choose a Room First
                </div> :
            <ul className={classes.addonContentContainer}>
            {addOnsGiven.map((currentAddOn)=>{
                return <li key={currentAddOn.name} value={currentAddOn.name} id={currentAddOn.name}onClick={storeFeatures}>{currentAddOn.name}</li>
            })}
            </ul>
        }
        </div>
    </div>
  )
}

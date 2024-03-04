import { useSelector } from 'react-redux'
import { RootState } from '../redux/Store'
import { createUseStyles } from 'react-jss';

const useStyles = createUseStyles({
    calculationHeaderContainer:{
        fontSize:"2rem",
        padding:"1rem",
        margin:"2rem",

    },
    submitButtonContainer:{
        padding:"1rem",
        marginTop:"2rem",
        backgroundColor:"#f08a5d",
        color:"#ffffff",
        border:"none",
    }
});
export  function Calculation() {
    const classes = useStyles();
    const {currentRoomType,extraFeatures,startDate,endDate,total,checkFirst,checkLast} = useSelector((state:RootState)=>state.rooms);
    const gst : number = total * 0.18;

    const displayTotal = ()=>{
        console.log(currentRoomType,extraFeatures,startDate,endDate,total);
    }

  return (
    

        <div className={classes.calculationHeaderContainer}>
        {(checkFirst == true) && (checkLast == true) && total != 0 &&  <><div>
            {total} + {gst} = {total + gst}
            </div><div>
            <button className={classes.submitButtonContainer} onClick={displayTotal}>Submit</button>
            </div></>
        }
        </div>
  )
}

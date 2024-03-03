import { createUseStyles } from "react-jss"
export const useStyles= createUseStyles({
    whole_container:{
        display:"flex",
        justifyContent:"center",
        width:"98vw",
        height:"80vh",
        margin:"1rem",
    },
    left_stock_container:{
        display:"flex",
        flexDirection:"column",
        width:"70vw",
        height:"75vh",
        margin:"1rem",
        justifyContent:"space-between"
    },
    right_stock_container:{
        display:"flex",
        flexDirection:"column",
        width:"25vw",
        height:"75vh",
        margin:"1rem", 
    },
    top_action_container:{
        display:"flex",
    },
    select_stock_container:{
        width:"20%",
        height:"10vh",
        fontSize:"1.2rem",
        textAlign:"center",
    },
    stock_change_container:{
        height:"500px",
        width:"70vw",
        border:"1px solid #000000",
        display: 'flex',
        alignItems: 'flex-end', 
        overflowX:"auto",
    },
    price_percentage_container:{
        marginLeft:"1.5rem",
        border:"1px solid black",
        display:"flex",
        padding:"1rem",
        width:"22vw",
        fontSize:"1.5rem",
        justifyContent:"space-between",
    },
    buy_sell_container:{
        marginLeft:"1.5rem",
        display:"flex",
    },
    sell_button:{
        marginLeft:"1.5rem",
        width:"5vw",
        fontSize:"1.2rem",
        color:"#e54b4b",
        backgroundColor:"#ffc9c9",
        border:"1px solid #e54b4b",
    },
    buy_button:{
        marginLeft:"1.2rem",
        width:"5vw",  
        fontSize:"1.5rem",
        color:"#34a148",
        backgroundColor:"#b2f2bb",
        border:"1px solid #34a148 "
    },
    input_field:{
        width:"15vw",  
        fontSize:"1rem", 
        border:"1px solid black",
        padding:"1rem",
        textAlign:"center",
    },
    history_container:{
      border:"1px solid #000000",
      height:"37.5vh",
      overflowY:"auto",

      "& ul":{
        padding:"0",

        "& li":{
          listStyle:"none",
          border:"1px solid #000000",
          borderRadius:"15px",
          margin:'1rem',
          display:"flex",
          justifyContent:"space-between"
        }
      }
    },
    list_right_side:{
      fontSize:"1.5rem",
      display:"flex",
      justifyContent:"center",
      alignItems:"center",
      padding:"0.5rem",
    },
    list_up_side:{
      padding:"0.5rem",
      fontSize:"1.7rem",
      marginBottom:"0.5rem",
    },
    list_down_side:{
      padding:"0.5rem",
      fontSize:"1rem",
      marginBottom:"0.5rem",
    },
    news_others_container:{
      marginTop:"1rem",
      border:"1px solid #000000",
      height:"37.5vh",
      overflowY:"auto",
    },
    percentageChange:{
        fontSize:"0.8rem",
        paddingTop:"1rem"
    },
    currentPrice:{
        fontSize:"1.5rem",
        paddingLeft:"2rem",
    },
    news_item:{
        fontSize:"1.5rem",
        fontWeight:"500",
        listStyle:"none",
        marginBottom:"1rem",
        paddingLeft:"1rem",
    }
  
})
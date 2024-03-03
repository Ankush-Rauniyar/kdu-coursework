import { createUseStyles } from "react-jss";
export const useStyles = createUseStyles({
    navigationContainer: {
      backgroundColor: "#1971c2",
      minHeight: "10vh",
      maxHeight:"10vh",
      width: "100%",
      display: "flex",
      justifyContent: "space-between",
      position:"sticky",
      top:"0",
    },
    leftNavigationContainer: {
      marginLeft:"1rem",
      display: "flex",
      justifyContent:"center",
      alignItems:"center",
      "& > a":{
          textDecoration:"none",
      "& i": {
          fontSize: "3rem", 
          color: "white",
          textDecoration:"none",
        },
      },
        "& span":{
          color: "white",
          padding: "1rem",
          margin: "1rem",
          fontSize: "2.5rem",
      },
        
    },
    rightNavigationContainer: {
      display: "flex",
      justifyContent:"center",
      alignItems:"center",
      "& > a":{
          textDecoration:"none",
          "& span": {
              color: "white",
              padding: "1rem",
              margin: "1rem",
              marginTop:"2rem",
              fontSize: "2.5rem",
              textDecoration: "none",
            },
      },
    },
    hamburgerIcon: {
      fontSize: "2.5rem",
      color: "white",
      cursor: "pointer",
      marginRight: "1rem",
    },
  
    mobileNavMenu: {
      display: "none",
      flexDirection: "column",
      position: "absolute",
      top: "10vh",
      left: 0,
      backgroundColor: "#1971c2",
      width: "100%",
      padding: "1rem",
      zIndex: 1,
    },
  
    mobileNavLink: {
      textDecoration: "none",
      color: "white",
      padding: "1rem",
      fontSize: "2rem",
      "&:hover": {
        backgroundColor: "#135190",
      },
    },
  
    "@media (max-width: 740px)": {
      leftNavigationContainer: {
        "& i": {
          display: "none",
        },
        "& span": {
          display: "none",
        },
      },
      hamburgerIcon: {
        display: "block",
      },
      rightNavigationContainer: {
        display: "none",
      },
      mobileNavMenu: {
        display: "flex",
      },
    },
    
    },
  );
  
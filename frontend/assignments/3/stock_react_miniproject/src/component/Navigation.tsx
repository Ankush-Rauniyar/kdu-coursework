import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { NavLink } from "react-router-dom";
import { fetchAllStocksAPI } from "../redux/FetchStocksFromAPI";
import { useStyles } from "./NavigationStyle";



export function Navigation() {
  const classes = useStyles();

  const dispatch = useDispatch();
  useEffect(()=>{
    dispatch(fetchAllStocksAPI());
  },[dispatch]);


  return (
    <div className={classes.navigationContainer}>
      <div className={classes.leftNavigationContainer}>
          <NavLink to="/">
            <i className="fi fi-sr-chart-histogram"></i>
            </NavLink>
          <span>KDU Stock Market</span>
      </div>
      <div className={classes.rightNavigationContainer}>
            <NavLink to="/summarizer"><span>
                Summarizer
                </span></NavLink>
            <NavLink to="/myportfolio">
                <span>
                My Portfolio
                </span>
            </NavLink>
      </div>
    </div>
  );
}

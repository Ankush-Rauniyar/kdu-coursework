import { IndividualItem } from "./IndividualItem";
import "./styles/Section.scss"
import { useSelector } from "react-redux";
import { RootState } from "../redux/Store";
import CustomizedSnackbars from "./Snackbar";


export function Section() {
    const products = useSelector((state:RootState)=>{
      return state.products.filteredProducts
    })
    const status = useSelector((state:RootState)=> state.products.status);
    if (status === 'pending') {
      return (
        <div className="loader-container">
          <div className="loader"></div>
        </div>
      );
    }

    if(status === "error"){
      console.log(status);
      return(
        <>
        <CustomizedSnackbars /></>
      );
    }
  return (
    <><div className="section-container">
      <div className="title-container">KDU MARKETPLACE</div>
      <ul>
        {products.map((item) => {
          return <li key={item.id}><IndividualItem item={item} /></li>;
        })}
      </ul>
    </div>
    <CustomizedSnackbars /></>
  )
}

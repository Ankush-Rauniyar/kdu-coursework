import { IItem } from "./interfaces/APIInterfaces";
import "./styles/IndividualItem.scss"
interface ItempProp{
    item:IItem;
}

export  function IndividualItem({item}:Readonly<ItempProp>) {
  return (
    <div className="item-current">
      <div className="image-container"><img src={item.image} alt={item.title}></img>
      </div>
        <div className="down-container">
            <span>
            {item.title}    
            </span>
            <div>

            <span className="price">${item.price}</span>
            <span>{item.rating.rate}</span>
            </div>
        </div>
    </div>
  )
}

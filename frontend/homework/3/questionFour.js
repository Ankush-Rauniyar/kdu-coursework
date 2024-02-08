class Shoe{
    constructor(type,color,size,price){
        this.type = type;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    getPrice(){
        return this.price;
    }
}

class Shirt{
    constructor(type,color,size,price){
        this.type = type;
        this.color = color;
        this.size = size;
        this.price = price;
    }
    getPrice(){
        return this.price;
    }
}

let shoe1 = new Shoe('cotton','black','9',500);
let shoe2 = new Shoe('leather','brown','7',2000);
let shirt1 = new Shirt('denim','blue','40',1500);
let shirt2 = new Shirt('silk','purple','32',1000);

let warehouse = [shoe1,shoe2,shirt1,shirt2];
let total = 0;
warehouse.forEach(function(object){
    total += object.getPrice();
})

console.log(total);

warehouse.sort((item1,item2) =>(item1.getPrice() < item2.getPrice() ? 1 : -1));

console.log(warehouse);

console.log(warehouse.filter(function(item){
    return item.color ==='blue';
}))
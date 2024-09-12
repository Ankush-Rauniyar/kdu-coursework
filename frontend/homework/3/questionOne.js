let bills = [140,45,280];

function calculateTips(bill){
    if(bill< 50){
        return 0.2 * bill;
    }else if(bill >= 50 && bill <= 200){
        return 0.15*bill;
    }else{
        return 0.1*bill;
    }
}

let tips = bills.map(function(bill){
    return calculateTips(bill);
});

console.log(tips);

let total = [];

for(let i = 0 ; i < bills.length ; i++){
    total.push(bills[i] + tips[i]);
}

console.log(total);
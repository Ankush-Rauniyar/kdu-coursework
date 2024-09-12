function convertToJson(entity){    
    let current = JSON.parse(entity);

    for(let key in current){
        if (key !== 'email' && typeof current[key] === 'string') {
            current[key] = current[key].toUpperCase();
        }
    }
    return current;
}

function removeEmail(entity){
    delete entity.email;
    return JSON.stringify(entity);
}

let given = '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';

let result =convertToJson(given);
console.log(result);

console.log(removeEmail(result));
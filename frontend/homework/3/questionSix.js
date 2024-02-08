function displayKeys(object){
    for(let key in object){
        if(typeof(object[key]) === 'object'){
            displayKeys(object[key]);
        }
        console.log(key);
    }
}

function displayValues(object){
    for(let key in object){
        if(typeof(object[key]) === 'object'){
            displayValues(object[key]);
        }else{
            console.log(object[key]);
        }
    }
}

let current = {
    firstName: "Leo",
    lastName: "Messi",
    address: {
        country: "Spain",
        city: "Barcelona",
        },
    careerInfo: {
        fcBarcelona: {
            appearances: 780,
            goals: {
                premierLeagueGoals: 590,
                championsLeagueGoals: 50,
               },
             },
        },
    };
console.log("\nThe list of keys: \n");
displayKeys(current);
console.log("\nThe list of values: \n");
displayValues(current);
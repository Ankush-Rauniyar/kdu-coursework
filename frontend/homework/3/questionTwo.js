let days =['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];

let result = [];

result = days.map(function(day){
    return day.slice(0,3).toUpperCase();
})

console.log(result);
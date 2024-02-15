const http = require('http');
const express = require('express');

import { recipes } from "./repository/recipeRepository";
import { IRecipe } from "./dto/ReicpeDto";

let app = express();
app.use(express.json());

const PORT:number | string = process.env.PORT ?? 4500;

app.listen(PORT,()=>{
    console.log(`listening to PORT: ${PORT}`);
})

app.get('/',(req:any,resp:any)=>{
    resp.send('Recipes received successfully');
});

function convertIntoRecipes(recipesReceived : any) : void{
    const current = recipesReceived.recipes;

        current.forEach((item:any)=> {
            let nowItem: IRecipe = {
                image : item.image,
                name : item.name,
                rating:item.rating,
                cusine:item.cuisine,
                ingredients:item.ingredients,
                difficulty:item.difficulty,
                timeTaken:{
                    prepTimeMinutes:item.prepTimeMinutes,
                    cookTimeMinutes:item.cookTimeMinutes
                },
                caloireCount:item.caloriesPerServing
            };
            console.log(nowItem);
        });
}

async function fetchRecipesFromAPI(){
    try {
        const response = await fetch('https://dummyjson.com/recipes');
        const recipesReceived = await response.json();
        const current = recipesReceived.recipes;

        current.forEach((item:any)=> {

            let nowItem: IRecipe = {
                image : item.image,
                name : item.name,
                rating:item.rating,
                cusine:item.cuisine,
                ingredients:item.ingredients,
                difficulty:item.difficulty,
                timeTaken:{
                    prepTimeMinutes:item.prepTimeMinutes,
                    cookTimeMinutes:item.cookTimeMinutes
                },
                caloireCount:item.caloriesPerServing
            };
            recipes.addReceipe(nowItem);
        });
        console.log('fetched all data and recipes successfully');
    } catch (error) {
        console.error('Error fetching recipes:', error);
    }
}


async function searchRecipes(query:string){
    try{
        const response = await fetch(`https://dummyjson.com/recipes/search?q=${query}`);
        const receivedItem = await response.json();
        convertIntoRecipes(receivedItem);
    }catch(error){
        console.log('error while searching recipe');
    }
}

fetchRecipesFromAPI();
setTimeout(()=>{
    console.log('\n\npizza recipes\n');
    searchRecipes('pizza');
},1000);

async function printAllRecipes() {
    await fetchRecipesFromAPI();
    console.log('all recipes:');
    console.log(recipes.allRecipes);
}

printAllRecipes();



"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var _a;
Object.defineProperty(exports, "__esModule", { value: true });
const http = require('http');
const express = require('express');
const recipeRepository_1 = require("./repository/recipeRepository");
let app = express();
app.use(express.json());
const PORT = (_a = process.env.PORT) !== null && _a !== void 0 ? _a : 4500;
app.listen(PORT, () => {
    console.log(`listening to PORT: ${PORT}`);
});
app.get('/', (req, resp) => {
    resp.send('Recipes received successfully');
});
function convertIntoRecipes(recipesReceived) {
    const current = recipesReceived.recipes;
    current.forEach((item) => {
        let nowItem = {
            image: item.image,
            name: item.name,
            rating: item.rating,
            cusine: item.cuisine,
            ingredients: item.ingredients,
            difficulty: item.difficulty,
            timeTaken: {
                prepTimeMinutes: item.prepTimeMinutes,
                cookTimeMinutes: item.cookTimeMinutes
            },
            caloireCount: item.caloriesPerServing
        };
        console.log(nowItem);
    });
}
function fetchRecipesFromAPI() {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const response = yield fetch('https://dummyjson.com/recipes');
            const recipesReceived = yield response.json();
            const current = recipesReceived.recipes;
            current.forEach((item) => {
                let nowItem = {
                    image: item.image,
                    name: item.name,
                    rating: item.rating,
                    cusine: item.cuisine,
                    ingredients: item.ingredients,
                    difficulty: item.difficulty,
                    timeTaken: {
                        prepTimeMinutes: item.prepTimeMinutes,
                        cookTimeMinutes: item.cookTimeMinutes
                    },
                    caloireCount: item.caloriesPerServing
                };
                recipeRepository_1.recipes.addReceipe(nowItem);
            });
            console.log('fetched all data and recipes successfully');
        }
        catch (error) {
            console.error('Error fetching recipes:', error);
        }
    });
}
function searchRecipes(query) {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const response = yield fetch(`https://dummyjson.com/recipes/search?q=${query}`);
            const receivedItem = yield response.json();
            convertIntoRecipes(receivedItem);
        }
        catch (error) {
            console.log('error while searching recipe');
        }
    });
}
fetchRecipesFromAPI();
setTimeout(() => {
    console.log('\n\npizza recipes\n');
    searchRecipes('pizza');
}, 1000);
function printAllRecipes() {
    return __awaiter(this, void 0, void 0, function* () {
        yield fetchRecipesFromAPI();
        console.log('all recipes:');
        console.log(recipeRepository_1.recipes.allRecipes);
    });
}
printAllRecipes();

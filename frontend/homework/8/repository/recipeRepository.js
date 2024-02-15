"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.recipes = void 0;
class Recipes {
    constructor() {
        this.allRecipes = [];
    }
    addReceipe(recipe) {
        this.allRecipes.push(recipe);
    }
}
exports.recipes = new Recipes();

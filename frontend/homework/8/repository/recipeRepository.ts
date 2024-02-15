import { IRecipe} from "../dto/ReicpeDto";

class Recipes{
    allRecipes:IRecipe[];

    constructor(){
        this.allRecipes = [];
    }

    addReceipe(recipe:IRecipe):void{
        this.allRecipes.push(recipe);
    }
}

export const recipes = new Recipes();

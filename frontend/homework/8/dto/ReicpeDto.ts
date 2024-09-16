export interface ITimeTaken{
    prepTimeMinutes:number,
    cookTimeMinutes:number
}
export interface IRecipe{
    image: string,
    name:string,
    rating:number,
    cusine:string,
    ingredients:string[],
    difficulty:string,
    timeTaken:ITimeTaken,
    caloireCount:number
}

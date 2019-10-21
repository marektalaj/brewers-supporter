import { Recipe } from './Recipe';
import { User } from './User';

export class Batch{
    id: number;
    brewingDate: string;
    fermentationTime: string;
    notes: string;
    alcoholByVolume: number;
    originalGravity: number;
    finalGravity: number;
    gravityBeforeBoiling: number;
    amountBeforeBoiling: number;
    amountAfterBoiling: number;
    ibu: number;
    recipe: Recipe;
    author: User;
}
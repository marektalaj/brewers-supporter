import { MaltingIngredient } from './MaltingIngredient';
import { HoopingIngredient } from './HoopingIngredient';
import { AdditionalIngredient } from './AdditionalIngredient';
import { YeastAsIngredient } from './YeastAsIngredient';
import { User } from './User';

export class Recipe{
    name: string;
    notes: string;
    amount: number;
    maltingIngredients: MaltingIngredient[];
    hoopingIngredients: HoopingIngredient[];
    additionalkIngredients: AdditionalIngredient[];
    yeast: YeastAsIngredient;
    author: User

}
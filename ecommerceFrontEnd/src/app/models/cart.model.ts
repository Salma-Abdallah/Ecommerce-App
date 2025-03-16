import { ProductModel } from "./product.model";
import { UserModel } from "./user.model";

export class CartModel{
    user:UserModel;
    product:ProductModel;
    quantity:number;
    isDeleted:number=0;
}
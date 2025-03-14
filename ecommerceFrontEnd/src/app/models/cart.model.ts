import { ProductModel } from "./product.model";
import { UserModel } from "./user.model";

export class CartModel{
    User:UserModel;
    Product:ProductModel;
    Quantity:number;
    IsDeleted:number=0;
}
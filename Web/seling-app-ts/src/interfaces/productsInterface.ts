import { PRODUCTS, PRODUCTS_SALE } from '../actions/types';
export interface ProductsState {
    products: any[],
    products_sale: any[]
}

export interface Product {
    Id: number,
    Name: string,
    Price: number,
    Discount: number,
    CateId: number,
    Description: string,
    Information: string,
    Image: string,
    Stock: number,
    Display: boolean,
    Promotion: number
}

interface GetProductsAction {
    type: typeof PRODUCTS,
    products: any[]
}

interface GetProductsSaleAction {
    type: typeof PRODUCTS_SALE,
    products_sale: any[]
}


export type ProductsActionTypes =
    GetProductsAction
    | GetProductsSaleAction;
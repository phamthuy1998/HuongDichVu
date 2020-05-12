import { PRODUCTS } from '../actions/types';
export interface ProductsState {
    products: any[]
}

export interface Product {
    _id: string,
    name: string,
    picture: string,
    price: number
}

interface GetProductsAction {
    type: typeof PRODUCTS,
    products: any[]
}


export type ProductsActionTypes = GetProductsAction;
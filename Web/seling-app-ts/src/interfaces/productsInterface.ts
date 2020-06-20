import { PRODUCTS, PRODUCTS_SALE, PRODUCT_DETAIL } from '../actions/types';
export interface ProductsState {
    products: any[],
    products_sale: any[],
    product: any
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
    Promotion: string,
    Cost: string
}

interface GetProductsAction {
    type: typeof PRODUCTS,
    products: any[]
}

interface GetProductsSaleAction {
    type: typeof PRODUCTS_SALE,
    products_sale: any[]
}

interface GetProductDetailAction {
    type: typeof PRODUCT_DETAIL,
    product: Product
}


export type ProductsActionTypes =
    GetProductsAction
    | GetProductsSaleAction
    | GetProductDetailAction;
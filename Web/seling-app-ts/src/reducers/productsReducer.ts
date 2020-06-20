import { PRODUCTS, PRODUCTS_SALE, PRODUCT_DETAIL } from '../actions/types';
import { ProductsActionTypes, ProductsState } from '../interfaces/productsInterface';

const initialState: ProductsState = {
    products: [],
    products_sale: [],
    product: null
}

const productsReducer = (state = initialState, action: ProductsActionTypes) => {
    switch (action.type) {
        case PRODUCTS: {
            return { ...state, products: action.products };
        }
        case PRODUCTS_SALE: {
            return { ...state, products_sale: action.products_sale }
        }
        case PRODUCT_DETAIL: {
            return { ...state, product: action.product }
        }
        default: return state;
    }
}

export default productsReducer;
import { PRODUCTS, PRODUCTS_SALE } from '../actions/types';
import { ProductsActionTypes, ProductsState } from '../interfaces/productsInterface';
const initialState: ProductsState = {
    products: [],
    products_sale: []
}

const productsReducer = (state = initialState, action: ProductsActionTypes) => {
    switch (action.type) {
        case PRODUCTS: {
            return { ...state, products: action.products };
        }
        case PRODUCTS_SALE: {
            return { ...state, products_sale: action.products_sale }
        }
        default: return state;
    }
}

export default productsReducer;
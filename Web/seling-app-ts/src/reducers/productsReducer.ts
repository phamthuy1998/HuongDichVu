import { PRODUCTS } from '../actions/types';
import { ProductsActionTypes, ProductsState } from '../interfaces/productsInterface';
const initialState: ProductsState = {
    products: []
}

const productsReducer = (state = initialState, action: ProductsActionTypes) => {
    switch (action.type) {
        case PRODUCTS: {
            return { ...state, products: action.products };
        }
        default: return state;
    }
}

export default productsReducer;
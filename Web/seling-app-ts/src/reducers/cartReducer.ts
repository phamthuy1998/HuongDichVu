import { CART } from '../actions/types';
import { CartState, CartsActionTypes } from '../interfaces/cartInterface';

const initialState: CartState = {
    carts: []
}

const cartReducer = (state = initialState, action: CartsActionTypes) => {
    switch (action.type) {
        case CART:
            return { ...state, carts: action.carts }

        default: return state;
    }
}

export default cartReducer;
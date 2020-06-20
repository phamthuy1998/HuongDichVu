import { CART } from '../actions/types';
export interface CartState {
    carts: any[]
}

interface GetCartsAction {
    type: typeof CART,
    carts: any[]
}

export type CartsActionTypes = GetCartsAction;
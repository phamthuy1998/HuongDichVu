import { PRODUCTS } from './types';
import products from '../data/product.json';
import { Dispatch } from 'react';

const listProduct = products;

export const getListProducts = (type = 1) => (dispatch: any) => {
    dispatch({
        type: PRODUCTS,
        products: listProduct
    });
}
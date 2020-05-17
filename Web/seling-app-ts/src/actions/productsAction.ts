import axios from 'axios';
import { api_allSalePros, api_allPros, PRODUCTS, PRODUCTS_SALE } from './types';
import { Dispatch } from 'react';
import { Product } from '../interfaces/productsInterface';
import { subString } from '../commonJS/helperFuncs';

export const getListProducts = () => async (dispatch: any) => {
    const res = await axios.get(api_allPros);
    if (res.data) {
        res.data.forEach((product: Product) => {
            product.Promotion = product.Price - product.Discount * product.Price;
            product.Description = subString(product.Description, 100);
        });
        dispatch({
            type: PRODUCTS,
            products: res.data
        });
    }
}

export const getListProductsSale = () => async (dispatch: any) => {
    const res = await axios.get(api_allSalePros);
    if (res.data) {
        res.data.forEach((product: Product) => {
            product.Promotion = product.Price - product.Discount * product.Price;
            product.Description = subString(product.Description, 100);
        });
        dispatch({
            type: PRODUCTS_SALE,
            products_sale: res.data
        });
    }
}
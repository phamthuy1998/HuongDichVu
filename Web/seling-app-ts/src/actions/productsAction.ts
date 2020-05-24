import axios from 'axios';
import {
    api_allSalePros, api_allPros, api_allCates,
    PRODUCTS, PRODUCTS_SALE, CATEGORY, PROS_OF_CATE, PRODUCT_DETAIL
} from './types';
import { Product } from '../interfaces/productsInterface';
import { isEmpty, formatMoney } from '../commonJS/helperFuncs';

// get list products
export const getListProducts = () => async (dispatch: any) => {
    const res = await axios.get(api_allPros);
    if (res.data) {
        formatProduct(res.data);
        dispatch({
            type: PRODUCTS,
            products: res.data
        });
    }
}

// get list products sale
export const getListProductsSale = () => async (dispatch: any) => {
    const res = await axios.get(api_allSalePros);
    if (res.data) {
        formatProduct(res.data);
        dispatch({
            type: PRODUCTS_SALE,
            products_sale: res.data
        });
    }
}

// get category
export const getListCategory = () => async (dispatch: any) => {
    const res = await axios.get(api_allCates);
    if (res.data) {
        dispatch({
            type: CATEGORY,
            categorys: res.data
        })
    }
}

// get list product by category id
export const getListProductByCategoryId = (id: number) => async (dispatch: any) => {
    const api_allProsOfCate = `/allProsOfCate?cateId=${id}`;
    let res;
    if (isEmpty(id)) {
        res = await axios.get(api_allPros);
    } else {
        res = await axios.get(api_allProsOfCate);
    }
    if (res.data) {
        formatProduct(res.data);
        dispatch({
            type: PROS_OF_CATE,
            prosOfCate: res.data
        })
    }
}

// get detail product
export const getProductDetail = (id: number) => async (dispatch: any) => {
    const api_proDetail = `/proDetail?proId=${id}`;
    let res = await axios.get(api_proDetail);
    if (res.data) {
        formatProduct(res.data);
        dispatch({
            type: PRODUCT_DETAIL,
            product: res.data[0]
        })
    }
}

// helper function in this class
export const formatProduct = (array: Product[]) => {
    array.forEach((product) => {
        product.Promotion = formatMoney(product.Price - product.Discount * product.Price);
        product.Cost = formatMoney(product.Price);
        // product.Description = subString(product.Description, 100);
    });
}
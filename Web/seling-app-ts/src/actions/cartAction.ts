import axios from 'axios';
import { toast } from 'react-toastify';
import { CART } from './types';
import { formatProduct } from './productsAction';

// add to cart
export const addToCart = (userId, productId, quantity = 1) => async (dispatch: any) => {
    const api_add_cart = `/plusCartItem?userId=${userId}&productId=${productId}&quantity=${quantity}`;
    let res = await axios.put(api_add_cart);
    if ((res.data[0]).result === 1) {
        toast.success((res.data[0]).message, {
            position: "top-right"
        });
        dispatch(getCart(userId));
    } else {
        toast.error((res.data[0]).message, {
            position: "top-right"
        });
    }
}

// get list cart of user
export const getCart = (userId) => (dispatch: any) => {
    const api_get_all_cart = `/allProsOfCart?userId=${userId}`;
    axios.get(api_get_all_cart)
        .then(res => {
            formatProduct(res.data);
            dispatch({
                type: CART,
                carts: res.data
            })
        })
        .catch(err => {
            console.log(err);
        })
}

//delete item from cart
export const deleteItemCart = (userId, productId) => (dispatch: any) => {
    const api_get_all_cart = `/minusCartItem?userId=${userId}&productId=${productId}`;
    axios.get(api_get_all_cart)
        .then(res => {
            dispatch(getCart(userId));
        })
        .catch(err => {
            console.log(err);
        })
}

// payment
export const payment = (data) => async (dispatch: any) => {
    const api_payment = `/checkOut?userId=${data.userId}&name=${data.name}&phone=${data.phone}&email=${data.email}&address=${data.address}&note=${data.note}`;
    let res = await axios.put(api_payment);
    if ((res.data[0]).result === 1) {
        toast.success((res.data[0]).message, {
            position: "top-right"
        });
        dispatch(getCart(data.userId));
    } else {
        toast.error((res.data[0]).message, {
            position: "top-right"
        });
    }
}
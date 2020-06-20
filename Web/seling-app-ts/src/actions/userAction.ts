import axios from 'axios';
import { toast } from 'react-toastify';

import {
    LOGIN, LOGOUT
} from './types';
import { getCart } from './cartAction';


export const login = (data, history) => async (dispatch: any) => {
    const api_login = `/login?userName=${data.account}&password=${data.password}`;
    let res = await axios.get(api_login);

    if ((res.data[0]).result > 0) {
        dispatch(getCurrentUser(((res.data)[0]).result));
        toast.success((res.data[0]).message, {
            position: "top-right"
        });
        dispatch(getCart(((res.data)[0]).result));
        setTimeout(history.goBack(), 3000);
    } else {
        toast.error((res.data[0]).message, {
            position: "top-right"
        });
    }
}

export const getCurrentUser = (userId: number) => async (dispatch: any) => {
    const api_detail_user = `/userInfoById?userId=${userId}`;
    let res = await axios.get(api_detail_user);
    if (res.data) {
        localStorage.setItem("user", JSON.stringify((res.data)[0]));
        dispatch({
            type: LOGIN,
            currentUser: (res.data)[0]
        })
    }
}

export const logout = () => {
    localStorage.removeItem('user');;
    window.location.href = window.location.origin + "/login";
}

export const register = (data, history) => async (dispatch: any) => {
    let _phone = (data.phone).trim();
    console.log(_phone + "thu");
    const api_register = `/signUp?userName=${data.username}&password=${data.password}&name=${data.name}&email=${data.email}&phone=${_phone}&address=${data.address}`;
    let res = await axios.post(api_register);
    if ((res.data[0]).result === 1) {
        history.push("/login");
    } else {
        toast.error((res.data[0]).message, {
            position: "top-right"
        });
    }
}

export const updateInfo = (data, history) => async (dispatch: any) => {
    const api_update_info = `updateUser?userId=${data.userId}&name=${data.name}&email=${data.email}&phone=${data.phone}&address=${data.address}&avatar=${data.avatar}`;
    let res = await axios.put(api_update_info);
    if ((res.data[0]).result === 1) {
        dispatch(getCurrentUser(data.userId));
        history.goBack();
    } else {
        toast.error((res.data[0]).message, {
            position: "top-right"
        });
    }
}
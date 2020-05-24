import { LOGIN } from '../actions/types';
export interface UsersState {
    currentUser: any
}

export interface User {
    Address: string,
    Avatar: string,
    Email: string,
    Id: number,
    Lock: boolean,
    Name: string,
    Password: string,
    Phone: string,
    RoleId: number
    Username: string
}

interface LoginAction {
    type: typeof LOGIN,
    currentUser: any
}



export type UsersActionTypes =
    LoginAction;
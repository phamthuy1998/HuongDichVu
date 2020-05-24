import { LOGIN } from '../actions/types';
import { UsersState, UsersActionTypes } from '../interfaces/userInterface';

const initialState: UsersState = {
    currentUser: null
}

const loginReducer = (state = initialState, action: UsersActionTypes) => {
    switch (action.type) {
        case LOGIN: {
            return { ...state, currentUser: action.currentUser }
        }

        default: return state;
    }
}

export default loginReducer;
import { CLEAR_ERRORS, GET_ERRORS } from '../actions/types';
import { HandleErrorsActionTypes } from '../interfaces/errorsInterface';

const initialState = {}
const errorsReducer = (state = initialState, action: HandleErrorsActionTypes) => {
    switch (action.type) {
        case CLEAR_ERRORS: {
            return {}
        }
        case GET_ERRORS: {
            return action.errors
        }
        default: return state;
    }
}

export default errorsReducer;
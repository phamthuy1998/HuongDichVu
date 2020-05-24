import { GET_ERRORS, CLEAR_ERRORS } from '../actions/types';

interface GetErrorAction {
    type: typeof GET_ERRORS,
    errors: any
}

interface ClearErrorAction {
    type: typeof CLEAR_ERRORS
}

export type HandleErrorsActionTypes =
    GetErrorAction | ClearErrorAction;

import { GET_ERRORS, CLEAR_ERRORS } from './types';

export const handleError = (errors) => {
    return {
        type: GET_ERRORS,
        errors
    }
}
export const handleClearError = () => {
    return {
        type: CLEAR_ERRORS
    }
}


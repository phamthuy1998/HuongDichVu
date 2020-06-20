import { CATEGORY, PROS_OF_CATE } from '../actions/types';
import { CategorysState, CategorysActionTypes } from '../interfaces/categorysInterface';
const initialState: CategorysState = {
    categorys: [],
    prosOfCate: []
}

const categorysReducer = (state = initialState, action: CategorysActionTypes) => {
    switch (action.type) {
        case CATEGORY: {
            return { ...state, categorys: action.categorys };
        }
        case PROS_OF_CATE: {
            return { ...state, prosOfCate: action.prosOfCate };
        }
        default: return state;
    }
}

export default categorysReducer;
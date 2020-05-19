import { combineReducers } from 'redux';
import productsReducer from './productsReducer';
import categorysReducer from './categorysReducer';

const rootReducer = combineReducers({
    productsReducer,
    categorysReducer
});

export default rootReducer;
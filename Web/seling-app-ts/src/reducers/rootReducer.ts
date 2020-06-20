import { combineReducers } from 'redux';
import productsReducer from './productsReducer';
import categorysReducer from './categorysReducer';
import userReducer from './userReducer';
import errorsReducer from './errorsReducer';
import cartReducer from './cartReducer';
const rootReducer = combineReducers({
    productsReducer,
    categorysReducer,
    userReducer,
    errorsReducer,
    cartReducer
});

export default rootReducer;
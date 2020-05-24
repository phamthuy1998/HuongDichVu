import React, { useEffect } from 'react';
import './App.scss';
import './customInput.scss';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

import Header from './components/layouts/header/Header';
import Footer from './components/layouts/footer/Footer';
import Home from './components/home/Home';
import Product from './components/products/Product';
import ViewProducts from './components/products/ViewProducts';
import ViewProductSale from './components/products/ViewProductSale';
import Category from './components/category/Category';
import { useSelector, useDispatch } from 'react-redux';
import { getListCategory } from './actions/productsAction';
import Login from './components/login/Login';
import Register from './components/register/Register';
import { isEmpty } from './commonJS/helperFuncs';
import { getCurrentUser } from './actions/userAction';
import { getCart } from './actions/cartAction';
import Bill from './components/bill/Bill';
import Payment from './components/payment/Payment';
import Profile from './components/user/Profile';
import EditProfile from './components/user/EditProfile';
import ChangePassword from './components/user/ChangePassword';

interface Props {

}
const App: React.FC<Props> = () => {
  const dispatch = useDispatch();
  let currentUser = JSON.parse(localStorage.getItem("user") || '{}');
  if (!isEmpty(currentUser)) {
    dispatch(getCurrentUser(currentUser.Id));
    dispatch(getCart(currentUser.Id));
  }
  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/products-sale" component={ViewProductSale} />
        <Route path="/product/:id" component={Product} />
        <Route path="/login" component={Login} />
        <Route path="/register" component={Register} />
        <Route path="/bill" component={Bill} />
        <Route path="/payment" component={Payment} />
        <Route path="/profile/:id" component={Profile} />
        <Route path="/update-profile/:id" component={EditProfile} />
        <Route path="/change-password/:id" component={ChangePassword} />

        <Switch>
          <Route path="/allProsOfCate/:id" component={ViewProducts} />
          <Route path="/products" component={ViewProducts} />
        </Switch>
      </Switch>
      <Footer />
    </Router>
  );
}

export default App;

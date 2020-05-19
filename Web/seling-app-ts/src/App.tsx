import React, { useEffect } from 'react';
import './App.scss';
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

function App(props: any) {
  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/products-sale" component={ViewProductSale} />
        <Route path="/detail/:id" component={Product} />
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

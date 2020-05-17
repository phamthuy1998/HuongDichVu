import React from 'react';
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

function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/detail/:id" component={Product} />
      </Switch>
      <Footer />
    </Router>
  );
}

export default App;

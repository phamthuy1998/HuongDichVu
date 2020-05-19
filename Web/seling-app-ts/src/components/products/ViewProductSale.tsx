import React, { useEffect } from 'react'
import Products from './Products'
import Title from '../common/Title'
import { useSelector, useDispatch } from 'react-redux'
import { getListProductsSale } from '../../actions/productsAction';

const ViewProductSale = () => {
    const listProductSale = useSelector((state: any) => state.productsReducer.products_sale);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getListProductsSale())
        return () => { }
    }, [])
    return (
        <div className="container">
            <div>breadcrumb</div>
            <Products products={listProductSale} title="Products sale" classname="col-sm-6 col-md-4 col-lg-3 pb-3 " />
        </div>
    )
}

export default ViewProductSale

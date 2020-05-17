import React, { useEffect } from 'react'
import Title from '../common/Title'
import Products from './Products'
import { useSelector, useDispatch } from 'react-redux';
import { getListProducts } from '../../actions/productsAction';

const ViewProducts = () => {
    const listProduct = useSelector((state: any) => state.productsReducer.products);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getListProducts())
        return () => { }
    }, [])
    return (
        <div className="container">
            <div>breadcrumb</div>
            <div className="row">
                <div className="col-md-3">

                </div>
                <div className="col-md-9">
                    <Title title="Products" />
                    <Products products={listProduct} classname="col-sm-6 col-md-4 col-lg-4 pb-3" />
                </div>
            </div>

        </div>
    )
}

export default ViewProducts

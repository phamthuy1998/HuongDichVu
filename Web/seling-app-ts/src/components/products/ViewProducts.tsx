import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';

import Products from './Products';
import Category from '../category/Category';

import { getListCategory, getListProductByCategoryId } from '../../actions/productsAction';

const ViewProducts = (props: any) => {
    const listCategory = useSelector((state: any) => state.categorysReducer.categorys);
    const listProsOfCate = useSelector((state: any) => state.categorysReducer.prosOfCate);

    const dispatch = useDispatch();
    let id = props.match.params.id;

    useEffect(() => {
        window.scrollTo(0, 0);
        dispatch(getListCategory());
        dispatch(getListProductByCategoryId(id));
        return () => { }
    }, [id])
    return (
        <div className="container">
            <div>breadcrumb</div>
            <div className="row ">
                <div className="col-md-3 bg-white" style={{ marginBottom: '20px' }}>
                    <Category categorys={listCategory} />
                </div>
                <div className="col-md-9">
                    <Products products={listProsOfCate} title="Products" classname="col-sm-6 col-md-4 col-lg-4 pb-3" />
                </div>
            </div>
        </div>
    )
}

export default ViewProducts

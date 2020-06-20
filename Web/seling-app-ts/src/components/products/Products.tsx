import React, { useEffect } from 'react'
import styled from 'styled-components';
import { Link, Redirect, RouteComponentProps, withRouter } from 'react-router-dom';
import { Product } from '../../interfaces/productsInterface';
import { isEmpty } from '../../commonJS/helperFuncs';
import Title from '../common/Title';
import { addToCart, getCart } from '../../actions/cartAction';
import { useDispatch, useSelector } from 'react-redux';
import { ToastContainer } from 'react-toastify';
// import { withRouter } from "react-router";

const Product1 = styled.section`
    
`;
const Img = styled.div`
    display: block;
    width: 180px;
    height: 180px;
    margin: 15px auto;
    transition: all ease 300ms;
`;
const NameProduct = styled.h3`
    line-height: 1.3em;
    font-size: 14px;
    padding: 0 10px;
    color: #333;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    text-overflow: ellipsis;
    overflow: hidden;
    margin: 0;
    &:hover {
        color: #288ad6;
    }
`;
const Description = styled.p`
    padding: 0 10px;
    font-size: 12px;
    color: #333;
    line-height: 1.4;
    white-space: normal;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;
    overflow: hidden;
`;
const ItemProduct = styled.div`
    padding: 0 10px;
    // border: 1px solid #eee;
`;

const AddCart = styled.div`
    padding: 0 10px;
    .add-to-cart {
        background-color: #3a5c83;
        height: 38px;
        text-align: center;
        display: inline-block;
        margin-right: 2px;
        i {
            font-size: 22px;
            color: #fff;
        }
    }
    .beta-btn {
        color: #fff;
        border: 1px solid #57a7c6;
        display: inline-block;
        padding: 6px 20px;
        &.primary {
            color: #606366;
            padding: 10px 20px;
            line-height: 100%; 
            i{
                font-size: 10px;
                padding-left: 5px;
                color: #f90;
            }
            &:hover {
                color: #fff;
                background: #3a5c83;
            }
        }
    }
`;
interface Props {
    products: any[],
    classname: string,
    title: string
}
const Products: React.FC<Props & RouteComponentProps> = ({ products, title, classname, history }) => {
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const dispatch = useDispatch();
    const addCart = (id) => {
        if (user) {
            dispatch(addToCart(user.Id, id));
        } else {
            // toggle();
            history.push('/login');
            console.log("history", history);
            console.log("akshdk");
        }

    }
    return (
        <>
            <Title title={title} />
            <Product1 className="product bg-white py-4">
                <div className="row">
                    {products.length !== 0 ?
                        <>
                            {products &&
                                (
                                    products.map((product: Product) => (
                                        <div key={product.Id} className={classname} >
                                            <ItemProduct>
                                                <Link to="">
                                                    <Img className="img">
                                                        {!isEmpty(product.Image) ?
                                                            <img src={product.Image} alt="OPPO Reno3 Pro" />
                                                            :
                                                            <img src="/images/no-image.jpg" alt="OPPO Reno3 Pro" />
                                                        }
                                                    </Img>
                                                    <NameProduct>
                                                        {product.Name}
                                                    </NameProduct>
                                                    <div className="price">
                                                        {product.Discount != 0 ?
                                                            <>
                                                                <strong>{product.Promotion}₫</strong>
                                                                <span>{product.Cost} ₫</span>
                                                            </>
                                                            : <strong>{product.Cost}₫</strong>
                                                        }
                                                    </div>

                                                    <Description>{product.Description}</Description>
                                                    <AddCart>
                                                        <button className="add-to-cart pull-left btn " onClick={() => addCart(product.Id)}><i className="fa fa-shopping-cart"></i></button>
                                                        <Link className="beta-btn primary" to={`/product/${product.Id}`}>Details <i className="fa fa-chevron-right"></i></Link>
                                                    </AddCart>
                                                </Link>
                                            </ItemProduct>

                                        </div>
                                    ))
                                )
                            } </>
                        :
                        <>
                            <div className="col-sm-12 pl-2">
                                <p className="pl-4">Không tìm thấy sản phẩm</p>
                            </div>
                        </>

                    }

                </div>
            </Product1>
            <ToastContainer />

        </>

    )
}

Products.propTypes = {

}

export default withRouter(Products)

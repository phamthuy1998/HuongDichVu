import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { ToastContainer } from 'react-toastify';
import { useDispatch, useSelector } from 'react-redux';
import { getProductDetail } from '../../actions/productsAction';
import { isEmpty } from '../../commonJS/helperFuncs';
import Title from '../common/Title';
import { addToCart } from '../../actions/cartAction';

const Img = styled.div`
    padding: 0 30px;
`;
const NameProduct = styled.h1`
    overflow: hidden;
    font-size: 24px;
    color: #333;
    line-height: 40px;
`;
const Info = styled.div`
    display: block;
    overflow: hidden;
    border: 1px solid #ddd;
    border-radius: 4px;
    position: relative;
    margin: 12px 0;
    background: #fff;
    padding-bottom: 10px;
    strong {
        display: block;
        overflow: hidden;
        font-size: 15px;
        color: #333;
        padding: 15px 15px 10px 15px;
        text-transform: uppercase;
    }
    span {
        display: block;
        overflow: hidden;
        font-size: 14px;
        color: #333;
        padding: 0px 15px 10px 15px;
    }
`;
const BuyProduct = styled.div`
    display: block;
    overflow: hidden;
    width: 260px;
    border: 1px solid orangered;
    
`;
const ButtonBuy = styled.button`
    text-align: center;
    background: -webkit-linear-gradient(top,#f59000,#fd6e1d);
    padding: 10px;
    color: white;
    border: none;
    width: 100%;
    font-size: 20px;
    i {
        font-size: 20px;
        padding-right: 10px;
    }
`;
const ButtonUnder = styled.div`
    text-align: center;
    padding: 10px 0;
    input {
        width: 50px !important;
        font-size: 16px;
        font-weight: 400;
        box-sizing: border-box;
        text-align: center;
        cursor: text !important;
        border-radius: 0;
    }
    button {
        outline: none;
        border: none;
        background: none;
        margin: 0 10px;
        font-size: 25px;
        i {
            color: #f59000;
        }
    }
`;
const Product = (props) => {
    const [count, setCount] = useState(1);
    const [formData, setFormData] = useState({
        account: "",
        password: ""
    });
    const [modal, setModal] = useState(false);

    const dispatch = useDispatch();
    const product = useSelector((state: any) => state.productsReducer.product);
    useEffect(() => {
        dispatch(getProductDetail(props.match.params.id));
        return () => { }
    }, []);

    const toggle = () => setModal(!modal);
    const handleChange = (e) => {
        if (e.target.value > 100) {
            setCount(100);
        } else {
            setCount(parseInt(e.target.value));
        }

    }

    const handleBlur = (e) => {
        if (e.target.value < 1 || e.target.value == '') {
            setCount(1);
        }
    }

    const add = () => {
        setCount(count + 1 > 100 ? 100 : count + 1);
    }

    const sub = () => {
        setCount(count - 1 < 1 ? 1 : count - 1);
    }

    const addCart = () => {
        let account = JSON.parse(localStorage.getItem('user') || '{}');
        console.log("user", account);
        if (!isEmpty(account)) {
            dispatch(addToCart(account.Id, product.Id, count));
        } else {
            // toggle();
            props.history.push('/login');
        }

    }

    const handleChangeLogin = (e) => {
        setFormData({
            ...formData, [e.target.name]: e.target.value
        })
    }

    const handleSubmit = (e) => {
        e.preventDefault();
    }

    const Back = () => {
        props.history.goBack();
    }
    return (
        <div className="bg-white">
            <div className="container">
                {product &&
                    <div className="row pb-5">
                        <div className="col-sm-12">
                            <Title title={product.Name} />
                        </div>
                        <div className="col-sm-12 col-md-4 pt-3">
                            <Img >
                                {!isEmpty(product.Image) ?
                                    <img src={product.Image} alt="OPPO Reno3 Pro" />
                                    :
                                    <img src="/images/no-image.jpg" alt="OPPO Reno3 Pro" />
                                }
                            </Img>
                        </div>
                        <div className="col-sm-12 col-md-7 ml-5">
                            <NameProduct>{product.Name}</NameProduct>
                            <div className="price detail-price">
                                {product.Discount != 0 ?
                                    <>
                                        <strong>{product.Promotion}₫</strong>
                                        <span>{product.Cost} ₫</span>
                                    </>
                                    : <strong>{product.Cost}₫</strong>
                                }
                            </div>
                            <Info>
                                <strong>Thông tin sản phẩm</strong>
                                <span>{product.Description}</span>
                            </Info>
                            <BuyProduct>

                                <ButtonUnder>
                                    <span>Số lượng: </span>
                                    <button onClick={add}><i className="fa fa-plus-circle"></i></button>
                                    <input className="_btn" type="number" onChange={handleChange} onBlur={handleBlur} value={!count ? '' : count} />
                                    <button onClick={sub}><i className="fa fa-minus-circle"></i></button>
                                </ButtonUnder>
                                <ButtonBuy onClick={addCart}><i className="fa fa-cart-arrow-down"></i> Thêm vào giỏ hàng</ButtonBuy>
                            </BuyProduct>
                        </div>
                        <div className="col-sm-12">
                            <button onClick={Back} className="btn btn-primary pull-right">Quay lại</button>
                        </div>
                    </div>
                }

                <ToastContainer />
            </div>
        </div>

    )
}

export default Product

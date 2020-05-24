import React, { useEffect, useState } from 'react'
import Title from '../common/Title'
import styled from 'styled-components';
import { useSelector, useDispatch } from 'react-redux';
import { getCart } from '../../actions/cartAction';
import { Link } from 'react-router-dom';

const Content = styled.div`
   // padding: 20px 0;
   .name {
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        text-overflow: ellipsis;
        overflow: hidden;
    }
`;
const CartImage = styled.div`
    width: 95px;
    height: 80px;
    
`;
const Bill = () => {
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const carts = useSelector((state: any) => state.cartReducer.carts);
    const [totalPrice, setTotalPrice] = useState(0);

    const dispatch = useDispatch();
    useEffect(() => {
        if (user) {
            dispatch(getCart(user.Id));
            let total = 0;
            carts.map(item => {
                total += item.Quantity * (item.Price - item.Discount * item.Price);
            });
            setTotalPrice(Math.round(total * 100) / 100);

        }
        return () => { }
    }, [])
    return (
        <div className="bg-white py-4">
            <div className="container">
                <Title title="Đơn hàng" />
                <Content>
                    <table className="table table-hover mb-5">
                        <thead>
                            <tr>
                                <th scope="col">Hình ảnh</th>
                                <th scope="col">Tên</th>
                                <th scope="col">Giá gốc</th>
                                <th scope="col">Giảm giá</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">Tổng tiền</th>
                            </tr>
                        </thead>
                        <tbody>
                            {carts && carts.map(cart => (
                                <tr>
                                    <td>
                                        <CartImage>
                                            <img src={cart.Image} />
                                        </CartImage>
                                    </td>
                                    <td style={{ width: '200px' }}>
                                        <p className="name">{cart.Name}</p>
                                    </td>
                                    <td>
                                        <p>{cart.Cost} ₫ </p>
                                    </td>
                                    <td>{cart.Discount * 100} %</td>
                                    <td>{cart.Quantity} </td>
                                    <td>
                                        <p>{((Math.round(cart.Quantity * (cart.Price - cart.Discount * cart.Price) * 100) / 100) + "").replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")} ₫ </p>
                                    </td>
                                </tr>
                            ))
                            }
                        </tbody>
                    </table>
                    <hr />
                    <div className="text-right">
                        <p>Tổng tiền: {(totalPrice + "").replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")} ₫</p>
                    </div>

                    <div className="text-right">
                        <Link to="/payment" className="btn btn-primary">Tiến hành thanh toán</Link>
                    </div>

                </Content>
            </div>
        </div>
    )
}

export default Bill

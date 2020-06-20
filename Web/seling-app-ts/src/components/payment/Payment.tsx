import React, { useEffect, useState } from 'react'
import TextFieldGroup from '../common/TextFieldGroup'
import { useSelector, useDispatch } from 'react-redux';
import { ToastContainer } from 'react-toastify';
import { payment } from '../../actions/cartAction';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

const Confirm = styled.div`
    position: relative;
    height: 75vh;
`;
const Content = styled.div`
    position: absolute;
    width: 530px;
    height: 250px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
    i{
        font-size: 50px;
        color: green;
    }
    h4{
        color: green;
    }
`;
const Payment = () => {
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const carts = useSelector((state: any) => state.cartReducer.carts);

    const [formData, setFormData] = useState({
        userId: null,
        name: "",
        email: "",
        note: "",
        phone: "",
        address: ""
    })
    const [isDisabled, setIsDisabled] = useState(true);

    const error = useSelector((state: any) => state.errorsReducer);
    const dispatch = useDispatch();
    useEffect(() => {
        checkDisable();
        if (user) {
            setFormData({ ...formData, userId: user.Id });
        }
        return () => {
            console.log("cleanup");
        };
    }, [formData.name, formData.phone, formData.email])

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }

    const checkDisable = () => {
        if (formData.name && formData.phone && formData.email) {
            setIsDisabled(false)
        } else {
            setIsDisabled(true)
        }
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch(payment(formData));
        setFormData({
            userId: null,
            name: "",
            email: "",
            note: "",
            phone: "",
            address: ""
        })

    }
    return (
        <div className="bg-white">
            <div className="container">
                <div className="row py-5">
                    {carts && carts.length === 0 ?
                        <div className="col-sm-12">
                            <Confirm>
                                <Content>
                                    <p><i className="fa fa-check-circle"></i></p>
                                    <h4>Xác nhận thanh toán thành công</h4>
                                    <p>Cảm ơn bạn đã mua hàng! Chúng tôi sẽ giao đến địa chỉ mà bạn yêu cầu</p>
                                    <Link to="/" className="btn btn-primary"> Mua sắm tiếp</Link>
                                </Content>

                            </Confirm>
                        </div>
                        :
                        <div className="col-md-6 mx-auto mForm">
                            <h1>Thông tin người nhận</h1>
                            <form onSubmit={handleSubmit}>
                                <TextFieldGroup required={true} error={error.name} type="text" value={formData.name} label="Họ tên" onChange={handleChange} name="name" />
                                <TextFieldGroup required={true} error={error.email} value={formData.email} type="email" label="Email" onChange={handleChange} name="email" />
                                <TextFieldGroup required={true} error={error.phone} type="number" value={formData.phone} label="Số điện thoại" onChange={handleChange} name="phone" />
                                <TextFieldGroup required={true} error={error.address} type="text" value={formData.address} label="Địa chỉ" onChange={handleChange} name="address" />
                                <TextFieldGroup error={error.address} type="text" value={formData.note} label="Ghi chú" onChange={handleChange} name="note" />

                                <div className="form-group mt-4">
                                    <button className="btn btn-primary btn-block  " disabled={isDisabled}>Thanh toán</button>
                                </div>
                            </form>
                        </div>
                    }


                </div>
            </div>
            <ToastContainer />
        </div>
    )
}

export default Payment

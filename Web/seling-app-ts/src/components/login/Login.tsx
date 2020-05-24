import React, { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { login } from '../../actions/userAction';
import TextFieldGroup from '../common/TextFieldGroup';
import { ToastContainer } from 'react-toastify';

const Login = (props) => {
    const dispatch = useDispatch();
    const [formData, setFormData] = useState({
        account: "",
        password: ""
    });

    const [isDisabled, setIsDisabled] = useState(true);
    const error = useSelector((state: any) => state.errorsReducer);
    useEffect(() => {
        checkDisable();

        return () => { };
    }, [formData.account, formData.password])

    const handleChange = (e) => {
        setFormData({
            ...formData, [e.target.name]: e.target.value
        })
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch(login(formData, props.history));
    }

    const checkDisable = () => {
        if (formData.account && formData.password) {
            setIsDisabled(false)
        } else {
            setIsDisabled(true)
        }
    }
    // register

    return (
        <div className="bg-white">
            <div className="container">
                <div className="row py-5">
                    <div className="col-md-6 mx-auto mForm">
                        <h1>Log In</h1>
                        <form onSubmit={handleSubmit}>
                            <TextFieldGroup required={true} error={error.message} value={formData.account} type="text" label="Tên đăng nhập, email, SĐT" onChange={handleChange} name="account" />
                            <TextFieldGroup required={true} error={error.message} value={formData.password} type="password" label="Mật khẩu" onChange={handleChange} name="password" />
                            <div className="form-group mt-4">
                                <button className="btn btn-block btn-danger flexbox" type="submit" disabled={isDisabled}><div style={{ display: "inline" }} className="mr-4">Đăng nhập</div> </button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
            <ToastContainer />
        </div>
    )
}

export default Login;

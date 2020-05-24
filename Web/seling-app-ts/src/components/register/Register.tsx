import React, { useEffect, useState } from 'react'
import Title from '../common/Title'
import TextFieldGroup from '../common/TextFieldGroup'
import { useSelector, useDispatch } from 'react-redux'
import { ToastContainer } from 'react-toastify'
import { register } from '../../actions/userAction'

const Register = (props) => {
    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
        password2: "",
        username: "",
        phone: "",
        address: ""
    })
    const [validpassword2, setValidrpassword2] = useState('');
    const [isDisabled, setIsDisabled] = useState(true);

    const error = useSelector((state: any) => state.errorsReducer);
    const dispatch = useDispatch();
    useEffect(() => {
        checkDisable();
        return () => {
            console.log("cleanup");
        };
    }, [formData.username, formData.phone, formData.email, formData.password, formData.password2])

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }

    const checkDisable = () => {
        if (formData.username && formData.phone && formData.email && formData.password && formData.password2) {
            setIsDisabled(false)
        } else {
            setIsDisabled(true)
        }
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        if (formData.password === formData.password2) {
            dispatch(register(formData, props.history));
        } else {
            if (formData.password !== formData.password2) {
                setValidrpassword2("Passwords must match")
            } else {
                setValidrpassword2('');
            }
        }

    }
    return (
        <div className="bg-white">
            <div className="container">
                <div className="row py-5">
                    <div className="col-md-6 mx-auto mForm">
                        <h1>Sign Up</h1>
                        <form onSubmit={handleSubmit}>
                            <TextFieldGroup required={true} error={error.userName} type="text" value={formData.username} label="Tên đăng nhập" onChange={handleChange} name="username" />
                            <TextFieldGroup required={true} error={error.email} value={formData.email} type="email" label="Email" onChange={handleChange} name="email" />
                            <TextFieldGroup required={true} error={error.password} type="password" value={formData.password} label="Password" onChange={handleChange} name="password" />
                            <TextFieldGroup required={true} error={validpassword2} type="password" value={formData.password2} label="Xác nhận password" onChange={handleChange} name="password2" />
                            <TextFieldGroup required={true} error={error.phone} type="number" value={formData.phone} label="Số điện thoại" onChange={handleChange} name="phone" />
                            <TextFieldGroup required={false} error={error.name} type="text" value={formData.name} label="Họ tên" onChange={handleChange} name="name" />
                            <TextFieldGroup error={error.address} type="text" value={formData.address} label="Địa chỉ" onChange={handleChange} name="address" />

                            <div className="form-group mt-4">
                                <button className="btn btn-primary btn-block  " disabled={isDisabled}>Đăng kí</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <ToastContainer />
        </div>
    )
}

export default Register

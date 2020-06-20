import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { getCurrentUser, updateInfo } from '../../actions/userAction';
import TextFieldGroup from '../common/TextFieldGroup';
import { ToastContainer } from 'react-toastify';
import { isEmpty } from '../../commonJS/helperFuncs';

const EditProfile = (props) => {
    const dispatch = useDispatch();
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const [formData, setFormData] = useState({
        name: "",
        email: "",
        avatar: "",
        phone: "",
        address: "",
        userId: ""
    });
    const [validEmail, setValidEmail] = useState('');
    const [validPhone, setValidPhone] = useState('');
    useEffect(() => {
        window.scrollTo(0, 0);
        dispatch(getCurrentUser(props.match.params.id));
        return () => { }
    }, []);

    useEffect(() => {
        if (user != null) {
            let _name = !isEmpty(user.Name) ? user.Name : '';
            let _email = !isEmpty(user.Email) ? user.Email : '';
            let _phone = !isEmpty(user.Phone) ? user.Phone : '';
            let _address = !isEmpty(user.Address) ? user.Address : '';
            let _avatar = !isEmpty(user.Avatar) ? user.Avatar : '';

            setFormData({
                name: _name,
                email: _email,
                avatar: _avatar,
                phone: _phone,
                address: _address,
                userId: user.Id
            })

        }
        return () => { }
    }, [user])

    const back = () => {
        props.history.goBack();
    }
    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        if (formData.email && formData.phone) {
            dispatch(updateInfo(formData, props.history));
            // props.history.push("/dashboard");
        } else {
            if (formData.email === "") {
                setValidEmail("Email is require");
            } else {
                setValidEmail('')
            }
            if (formData.phone === "") {
                setValidPhone("Phone is require");
            } else {
                setValidPhone('')
            }

        }

    }
    return (
        <div className="bg-white">
            <div className="container">
                <div className="row py-5">
                    <div className="col-md-6 mx-auto mForm">
                        <h1>Cập nhật thông tin</h1>
                        <form onSubmit={handleSubmit}>
                            <TextFieldGroup error={validEmail} required={true} value={formData.email} type="email" label="Email" onChange={handleChange} name="email" />
                            <TextFieldGroup error={validPhone} required={true} type="text" value={(formData.phone).trim()} label="Số điện thoại" onChange={handleChange} name="phone" />
                            <TextFieldGroup type="text" value={formData.name} label="Họ tên" onChange={handleChange} name="name" />
                            <TextFieldGroup type="text" value={formData.avatar} label="Avatar" onChange={handleChange} name="avatar" />
                            <TextFieldGroup type="text" value={formData.address} label="Địa chỉ" onChange={handleChange} name="address" />

                            <div className="form-group mt-4">
                                <button className="btn btn-primary btn-block  ">Lưu</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <ToastContainer />
        </div>
    )
}

export default EditProfile

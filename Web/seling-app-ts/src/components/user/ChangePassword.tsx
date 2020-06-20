import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { getCurrentUser } from '../../actions/userAction';
import TextFieldGroup from '../common/TextFieldGroup';
import { ToastContainer } from 'react-toastify';

const ChangePassword = (props) => {
    const dispatch = useDispatch();
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const [formData, setFormData] = useState({
        password: "",
        password2: ""
    });
    const [isDisabled, setIsDisabled] = useState(true);

    useEffect(() => {
        window.scrollTo(0, 0);
        dispatch(getCurrentUser(props.match.params.id));
        checkDisable();

        return () => { }
    }, [formData.password, formData.password2]);

    const checkDisable = () => {
        if (formData.password && formData.password2) {
            setIsDisabled(false)
        } else {
            setIsDisabled(true)
        }
    }
    const back = () => {
        props.history.goBack();
    }
    const handleSubmit = (e) => {
        e.preventDefault();


    }
    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }
    return (
        <div className="bg-white">
            <div className="container">
                <div className="row py-5">
                    <div className="col-md-6 mx-auto mForm">
                        <h1>Sign Up</h1>
                        <form onSubmit={handleSubmit}>
                            <TextFieldGroup required={true} type="password" value={formData.password} label="Password" onChange={handleChange} name="password" />
                            <TextFieldGroup required={true} type="password" value={formData.password2} label="Xác nhận password" onChange={handleChange} name="password2" />

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

export default ChangePassword

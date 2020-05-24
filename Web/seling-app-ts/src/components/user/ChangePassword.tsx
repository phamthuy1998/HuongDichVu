import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { getCurrentUser, changePassword } from '../../actions/userAction';
import TextFieldGroup from '../common/TextFieldGroup';
import { ToastContainer } from 'react-toastify';
import Title from '../common/Title';

const ChangePassword = (props) => {
    const dispatch = useDispatch();
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const [formData, setFormData] = useState({
        oldPass: "",
        newPass: "",
        userId: props.match.params.id
    });
    const [isDisabled, setIsDisabled] = useState(true);

    useEffect(() => {
        window.scrollTo(0, 0);
        dispatch(getCurrentUser(props.match.params.id));
        checkDisable();

        return () => { }
    }, [formData.oldPass, formData.newPass]);

    const checkDisable = () => {
        if (formData.oldPass && formData.newPass) {
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
        dispatch(changePassword(formData, props.history))

    }
    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }
    return (
        <div className="bg-white">
            <div className="container">
                <div className="row">
                    <div className="col-md-12">
                        <Title title="Đổi mật khẩu" />
                    </div>
                </div>
                <button onClick={back} className="btn btn-danger pull-right">Quay lại</button>

                <div className="row py-5">
                    <div className="col-md-6 mx-auto mForm">
                        <h1>Đổi mật khẩu</h1>
                        <form onSubmit={handleSubmit}>
                            <TextFieldGroup required={true} type="password" value={formData.oldPass} label="Mật khẩu cũ" onChange={handleChange} name="oldPass" />
                            <TextFieldGroup required={true} type="password" value={formData.newPass} label="Mật khẩu mới" onChange={handleChange} name="newPass" />

                            <div className="form-group mt-4">
                                <button className="btn btn-primary btn-block  " disabled={isDisabled}>Lưu</button>
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

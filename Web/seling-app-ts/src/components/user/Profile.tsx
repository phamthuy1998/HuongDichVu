import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { getCurrentUser } from '../../actions/userAction';
import Title from '../common/Title';
import { isEmpty } from '../../commonJS/helperFuncs';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

const Avatar = styled.div`

`;
const Profile = (props) => {
    const dispatch = useDispatch();
    const user = useSelector((state: any) => state.userReducer.currentUser);

    useEffect(() => {
        window.scrollTo(0, 0);
        dispatch(getCurrentUser(props.match.params.id));
        return () => { }
    }, []);

    const back = () => {
        props.history.goBack();
    }
    return (
        <div className="bg-white">
            <div className="container">
                <div className="row">
                    <div className="col-md-12">
                        <Title title="Profile" />
                    </div>
                </div>
                <div className="row py-4">
                    {user && <>

                        <div className="col-md-3 ">
                            <Avatar>
                                {!isEmpty(user.Avatar) ?
                                    <div className="img">
                                        <img className="img-thumbnail" src={user.Avatar} alt="OPPO Reno3 Pro" />
                                    </div>

                                    :
                                    <div className="img">
                                        <img className="img-thumbnail" src="/images/no-avatar.png" alt="No avatar" />
                                    </div>

                                }

                                <h4 className="text-center pt-2">{user.Name}</h4>
                            </Avatar>

                        </div>
                        <div className="col-md-9" style={{ paddingLeft: "100px" }}>
                            <h4 className="text-center">Thông tin chi tiết</h4>
                            <div className="row">
                                <div className="col-sm-2">
                                    <p>Họ tên: </p>
                                </div>
                                <div className="col-sm-10">
                                    <p>{user.Name}</p>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-sm-2">
                                    <p>Email: </p>
                                </div>
                                <div className="col-sm-10">
                                    <p>{user.Email}</p>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-sm-2">
                                    <p>Số di động: </p>
                                </div>
                                <div className="col-sm-10">
                                    <p>{user.Phone}</p>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-sm-2">
                                    <p>Địa chỉ: </p>
                                </div>
                                <div className="col-sm-10">
                                    <p>{user.Address}</p>
                                </div>
                            </div>
                            <div className="row mt-3">
                                <div className="col-sm-12 text-center">
                                    <button onClick={back} className="btn btn-danger">Quay lại</button>
                                    <Link to={`/update-profile/${user.Id}`} className="btn btn-primary ml-2">Cập nhật thông tin</Link>
                                    <Link to={`/change-password/${user.Id}`} className="btn btn-success ml-2">Đổi mật khẩu</Link>
                                </div>
                            </div>
                        </div>
                    </>}
                </div>
            </div>

        </div>
    )
}

export default Profile

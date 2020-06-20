import React from 'react'
import styled from 'styled-components';
import { Link } from 'react-router-dom';

const Ul = styled.ul`

`;
const Li = styled.li`

`;
const FooterBottom = styled.div`
    text-align: center;
    padding: 10px 0;
`;
interface Props {
}
const Footer: React.FC<Props> = () => {
    const year = new Date();
    return (
        <>
            <footer className="bg-white mt-5 py-3">
                <div className="container">
                    <div className="row">
                        <div className="col-4">
                            <Ul className="colfoot">
                                <Li>
                                    <Link to="#">Tìm hiểu về mua trả góp</Link>
                                </Li>
                                <Li>
                                    <Link to="#">Chính sách bảo hành</Link>
                                </Li>
                                <Li>
                                    <Link to="#"> Chính sách đổi trả</Link>
                                </Li>
                                <Li>
                                    <Link to="#"> Giao hàng & Thanh toán</Link>
                                </Li>
                            </Ul>
                        </div>
                        <div className="col-4">
                            <Ul className="colfoot">
                                <Li>
                                    <Link to="#">Giới thiệu công ty (mwg.vn)</Link>
                                </Li>
                                <Li>
                                    <Link to="#">Tuyển dụng</Link>
                                </Li>
                                <Li>
                                    <Link to="#"> Gửi góp ý, khiếu nại</Link>
                                </Li>
                                <Li>
                                    <Link to="#"> Tìm siêu thị (2.022 shop)</Link>
                                </Li>
                            </Ul>
                        </div>
                        <div className="col-4">
                            <Ul className="colfoot">
                                <Li>
                                    <p>Giới thiệu công ty (mwg.vn)</p>
                                </Li>
                                <Li>
                                    <p>Tuyển dụng</p>
                                </Li>
                                <Li>
                                    <p> Gửi góp ý, khiếu nại</p>
                                </Li>
                                <Li>
                                    <p> <img src="/images/registed.png" /> </p>
                                </Li>
                            </Ul>
                        </div>
                    </div>
                </div>
            </footer>

            <FooterBottom>
                Copyright  © {year.getFullYear()}  PTIT TEAM
            </FooterBottom>
        </>

    )
}


export default Footer



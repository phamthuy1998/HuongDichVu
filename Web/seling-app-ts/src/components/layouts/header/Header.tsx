import React, { useEffect } from 'react'
import styled from 'styled-components';
import { Link, NavLink } from 'react-router-dom';
import { device } from '../../common/device';
import { useSelector, useDispatch } from 'react-redux';
import { logout, getCurrentUser } from '../../../actions/userAction';
import { getCart, deleteItemCart } from '../../../actions/cartAction';
import { isEmpty } from '../../../commonJS/helperFuncs';
import { Row } from 'reactstrap';
import { Product } from '../../../interfaces/productsInterface';

const Topbar = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 5px 0;
    background: #e7e2e2;
    @media ${device.tabletPro} {
        display: none;
    }
`;
const Wellcom = styled.span`
    color: #333;
`;
const ActionAccount = styled.div`
    span:first-child {
        margin-right: 20px;
        border-right: 1px solid white;
        padding-right: 20px;
    }
    span > a {
        text-decoration: none;
    }
`;
const Nav = styled.nav`
    background: #2196F3;
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    padding: 5px 0;
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    z-index: 999;
`;
const Logo = styled.label`
    color: white;
    font-size: 35px;
    font-weight: bold;
    @media ${device.tabletPro} {
        font-size: 30px;
    }
`;
const Ul = styled.ul`
    margin-right: 20px;
    margin-bottom: 0;
    @media ${device.tabletPro} {
        position: fixed;
        width: 36%;
        height: 100vh;
        background: #2c3e50;
        top: 63px;
        left: -100%;
        text-align: center;
        transition: all 0.5s;
    }
`;
const Li = styled.li`
    display: inline-block;
    margin: 0 5px;
    padding: 7px 13px;
    &.register, &.login {
        display: none;
    }
    &.dropdown {
        position: relative;
        display: inline-block;
    }
    &.dropdown:hover .dropdown-content {
        display: block;
    }
    a.type-product {
        display: block;
    }
    @media ${device.tabletPro} {
        display: block;
        margin: 30px 0;
        line-height: 30px;
        &.register, &.login {
            display: block;
        }
        .account {
            display: none;
        }
    }

`;
const Checkbox = styled.input`
    display: none;
    @media ${device.tabletPro} {
        &:checked ~ ul {
            left: 0px;
        }
    }
    
`;
const Bar = styled.label`
    font-size: 30px;
    color: white;
    float: right;
    cursor: pointer;
    display: none;
    @media ${device.tabletPro} {
        display: block;
    }
`;
const Cart = styled.p`
    margin-bottom: 0;
    color: white;
    position: relative;
    i {
        font-size: 30px;
    }

    .number {
        position: absolute;
        top: -7px;
        left: 17px;
        border: 1px solid red;
        border-radius: 10px;
        font-size: 14px;
        color: red;
        background: white;
        padding: 0 5px;
    }
    .cart-dropdown-content {
        position: absolute;
        border: 1px solid $dd-color;
        right: -85px;
        transform: translateY(6px);
        padding: 20px;
        border-radius: 1px;
        box-shadow: 0px 0px 10px -1px $dd-color;
        width: 425px;
        display: none;
        background: white;
        &:after {
            content: "";
            position: absolute;
            border-left: 1px solid $dd-color;
            border-top: 1px solid $dd-color;
            top: -8px;
            right: 85px;
            width: 14px;
            height: 14px;
            background: white;
            transform: rotate(45deg);
        }
        h3 {
            color: $dd-color;
            text-align: center;
            padding-bottom: 40px;
        }
        .btnCheckout {
            text-align: center;
            width: 100%;
            background: #fc7710;
            color: white;
            text-transform: uppercase;
            cursor: pointer;
            padding: 7px;
            font-size: 17px;
            border: none;
            &:focus {
                outline: none;
            }
        }

        .content {
            height: 260px;
            overflow-y: auto;
            .cart-item {
                align-items: center;
                width: 100%;
                margin: 0 !important;
                border-bottom: 1px solid #999;
                padding: 5px 0;
                .cart_img {
                    flex-basis: 20% !important;
                    height: 75px;
                }
                .name_price {
                    flex-basis: 45% !important;
                    padding: 0 10px;
                    overflow: hidden;
                    p:first-child {
                        display: -webkit-box;
                        -webkit-line-clamp: 1;
                        -webkit-box-orient: vertical;
                        text-overflow: ellipsis;
                        overflow: hidden;
                    }
                    p {
                        color: #999;
                        font-size: 14px;
                        margin: 0 !important;
                    }
                }
                .total_price {
                    flex-basis: 22% !important;
                    p:first-child {
                        color: #999;
                    }
                    p {
                        margin: 0 !important;
                        font-size: 14px;
                        color: #999;
                    }
                }
                .delete {
                    flex-basis: 7% !important;
                    height: 24px;
                    line-height: 24px;
                    font-size: 18px;
                    color: #ccc;
                    margin-left: 11px;
                }
            }
        }
    }
    &:hover {
        .cart-dropdown-content {
            display: block;
        }
    }
`;
const Dropdown = styled.ul`
    display: none;
    position: absolute;
    background: #2196F3;
    min-width: 210px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.4);
    padding: 12px 16px;
    top: 38px;
    z-index: 1;
    @media ${device.tabletPro} {
        background: #2c3e50;
    }
    
`;

interface Props { }
const Header: React.FC<Props> = () => {
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const carts = useSelector((state: any) => state.cartReducer.carts);
    const dispatch = useDispatch();
    useEffect(() => {
        if (user) {
            dispatch(getCart(user.Id));
        }
        return () => { }
    }, [])
    const handleLogout = (e) => {
        e.preventDefault();
        dispatch(logout());
    }
    const handleDelete = (id) => {
        if (user) {
            dispatch(deleteItemCart(user.Id, id));
        }
    }
    return (
        <>
            {/* <Topbar>
                <div className="container  d-flex align-items-center justify-content-between">
                    <Wellcom>Wellcom to PTIT</Wellcom>
                    <ActionAccount>
                        <span><Link to="/register">Register</Link></span>
                        <span><Link to="/login">Login</Link></span>
                    </ActionAccount>
                </div>
            </Topbar> */}
            <Nav>
                <div className="container d-flex align-items-center justify-content-between">
                    <Logo>PTIT</Logo>
                    <Checkbox id="check" type="checkbox" />
                    <Bar htmlFor="check"><i className="fa fa-bars"></i></Bar>
                    <Ul>
                        <Li>
                            <NavLink className="active" to="/">Home</NavLink>
                        </Li>

                        <Li className="dropdown">
                            <NavLink to="#">Products</NavLink>
                            <Dropdown className="dropdown-content">
                                <Li >
                                    <Link to="/products" className="type-product">Products</Link>
                                </Li>
                                <Li >
                                    <Link to="/products-sale" className="type-product">Products sale</Link>
                                </Li>
                            </Dropdown>
                        </Li>
                        <Li>
                            <NavLink to="/">Contact</NavLink>
                        </Li>
                        <Li>
                            <Cart> <i className="fa fa-cart-arrow-down"></i>
                                <div className="number">
                                    {carts && <> {carts.length}</>}

                                </div>
                                <div className="cart-dropdown-content"  >
                                    {carts && <>
                                        {carts.length !== 0 ?
                                            <>
                                                <div className="content scrollbar" id="scroll">
                                                    {carts.map((item) => (
                                                        <Row className="cart-item" key={item.Id}>
                                                            <div className="cart_img">
                                                                {item.Image ? <img src={item.Image} alt="" /> :
                                                                    <img src="/images/no-image.jpg" alt="" />
                                                                }

                                                            </div>
                                                            <div className="name_price">
                                                                <p>{item.Name}</p>
                                                                <p>{item.Promotion} ₫ </p>
                                                            </div>
                                                            <div className="total_price text-right">
                                                                <p>{item.Quantity} No.</p>
                                                                <p>{((Math.round(item.Quantity * (item.Price - item.Discount * item.Price) * 100) / 100) + "").replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")} ₫ </p>
                                                            </div>
                                                            <div className="delete text-right" onClick={() => handleDelete(item.Id)}>
                                                                <p><i className="fa fa-minus-circle"></i></p>
                                                            </div>
                                                        </Row>
                                                    ))}
                                                </div>
                                                <Link className="btn btnCheckout" to="/bill">Xem giỏ hàng </Link>
                                            </>
                                            :
                                            <>
                                                <div className="no_content">
                                                    <img src="images/empty-cart.png" alt="" />
                                                    <h3> Giỏ hàng trống</h3>
                                                </div>
                                                <button disabled className="btn btnCheckout" >Xem giỏ hàng </button>
                                            </>
                                        }</>}
                                </div>
                            </Cart>
                        </Li>
                        {isEmpty(user) ?
                            <>
                                <Li>
                                    <ActionAccount className="account">
                                        <span><Link to="/register">Register</Link></span>
                                        <span><Link to="/login">Login</Link></span>
                                    </ActionAccount>
                                </Li>
                                <Li className="register">
                                    <Link to="/register">Register</Link>
                                </Li>
                                <Li className="login">
                                    <Link to="/login">Login</Link>
                                </Li>
                            </>
                            :
                            <>
                                <Li className="dropdown avatar-user">
                                    <Link to="#">
                                        {!isEmpty(user.Avatar) ?
                                            <div className="img">
                                                <img src={user.Avatar} alt="OPPO Reno3 Pro" />
                                            </div>

                                            :
                                            <div className="img">
                                                <img src="/images/no-avatar.png" alt="No avatar" />
                                            </div>

                                        }
                                        <span >Hi, {user.Name}  </span>

                                    </Link>
                                    <Dropdown className="dropdown-content">
                                        <Li >
                                            <Link to={`/profile/${user.Id}`} className="type-product">View Profile</Link>
                                        </Li>
                                        <Li >
                                            <a href="" onClick={handleLogout}> Logout</a>
                                        </Li>
                                    </Dropdown>
                                </Li>
                            </>
                        }


                    </Ul>
                </div>
            </Nav>
        </>
    )
}

export default React.memo(Header);

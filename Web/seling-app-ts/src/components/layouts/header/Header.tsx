import React from 'react'
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { device } from '../../common/device';

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
    i {
        font-size: 30px;
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

const Header = React.memo(props => {

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
                            <Link className="active" to="/">Home</Link>
                        </Li>

                        <Li className="dropdown">
                            <Link to="/products">Products</Link>
                            <Dropdown className="dropdown-content">
                                <Li >
                                    <a className="type-product" href="#products1">Products type 1</a>
                                </Li>
                                <Li >
                                    <a className="type-product" href="#products2">Products type 2</a>
                                </Li>
                                <Li >
                                    <a className="type-product" href="#products3">Products type 3</a>
                                </Li>
                            </Dropdown>
                        </Li>
                        <Li>
                            <Link to="/">Contact</Link>
                        </Li>
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
                        <Li>
                            <Cart> <i className="fa fa-cart-arrow-down"></i></Cart>
                        </Li>
                    </Ul>
                </div>
            </Nav>
        </>
    )
})

export default Header

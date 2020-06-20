import React, { useEffect } from 'react'
import OwlCarousel from 'react-owl-carousel';
import 'owl.carousel/dist/assets/owl.carousel.css';
import 'owl.carousel/dist/assets/owl.theme.default.css';
import styled from 'styled-components';

import { useSelector, useDispatch } from 'react-redux';

import { getListProducts, getListProductsSale } from '../../actions/productsAction';
import Products from '../products/Products';

const Item = styled.div``;

const UnderSlider = styled.div`
    margin: 10px 0;
`;

interface Props {
    // props: any;
}
const Home: React.FC<Props> = (props) => {
    const user = useSelector((state: any) => state.userReducer.currentUser);
    const listProductSale = useSelector((state: any) => state.productsReducer.products_sale);
    const listProduct = useSelector((state: any) => state.productsReducer.products);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getListProductsSale());
        dispatch(getListProducts());
        return () => { }
    }, [])

    console.log("home", props);
    return (
        <>
            <OwlCarousel id="slider"
                className="owl-theme"
                loop
                margin={10}
                items={1}
                autoplay={true}
            >
                <Item className="item"><img className="img" src={'/images/slider1.gif'} /></Item>
                <Item className="item"><img className="img" src={'/images/slider2.png'} /></Item>
                <Item className="item"><img className="img" src={'/images/slider3.png'} /></Item>
                <Item className="item"><img className="img" src={'/images/slider4.png'} /></Item>
            </OwlCarousel>


            {/* load product by category */}
            <div className="container">
                <UnderSlider>
                    <img src="/images/underSlide.gif" alt="OPPO Reno3 Pro" />
                </UnderSlider>
                {/* load product sale list */}
                <Products products={listProductSale} title="Products sale" classname="col-sm-6 col-md-4 col-lg-3 pb-3" />
                {/* load product list */}
                <Products products={listProduct} title="All Products" classname="col-sm-6 col-md-4 col-lg-3 pb-3 " />
            </div>
        </>
    )
}


export default Home

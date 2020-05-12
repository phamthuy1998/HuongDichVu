import React, { useEffect } from 'react'
import OwlCarousel from 'react-owl-carousel';
import 'owl.carousel/dist/assets/owl.carousel.css';
import 'owl.carousel/dist/assets/owl.theme.default.css';
import styled from 'styled-components';

import { useSelector, useDispatch } from 'react-redux';

import { getListProducts } from '../../actions/productsAction';
import { Product } from '../../interfaces/productsInterface';
import { Link } from 'react-router-dom';
import Products from '../products/Products';

const Item = styled.div``;
const Category = styled.div`
    background: #fff;
    height: 3.75rem;
    border-bottom: 1px solid rgba(0,0,0,.05);
    padding: 0 1.25rem;
    display: flex;
    align-items: center;
    background: white;
`;
const Title = styled.div`
    font-size: 1rem;
    font-weight: 500;
    flex: 1;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-right: 1.25rem;
    text-transform: uppercase;
`;

const UnderSlider = styled.div`
    margin: 10px 0;
`;

interface Props {

}
const Home: React.FC<Props> = () => {
    const listProduct = useSelector((state: any) => state.productsReducer.products);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getListProducts());
        return () => { }
    }, [])
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
                {/* load product list */}
                <Category id="products1" >
                    <Title>
                        <span>Products type 1</span>
                    </Title>
                </Category>

                <Products products={listProduct} />
                {/* product2 */}
                <Category id="products2" className="mt-3">
                    <Title>
                        <span>Products type 2</span>
                    </Title>
                </Category>
                <Products products={listProduct} />
            </div>
        </>
    )
}


export default Home

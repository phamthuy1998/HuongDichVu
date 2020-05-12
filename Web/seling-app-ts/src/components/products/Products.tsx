import React from 'react'
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Product } from '../../interfaces/productsInterface';

const Product1 = styled.section`
    
`;
const Img = styled.div`
    display: block;
    width: 180px;
    height: 180px;
    margin: 15px auto;
    transition: all ease 300ms;
`;
const NameProduct = styled.h3`
    line-height: 1.3em;
    font-size: 14px;
    padding: 0 10px;
    color: #333;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    text-overflow: ellipsis;
    overflow: hidden;
    margin: 0;
    &:hover {
        color: #288ad6;
    }
`;
const Description = styled.p`
    padding: 0 10px;
    font-size: 12px;
    color: #333;
    line-height: 1.4;
    white-space: normal;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;
    overflow: hidden;
`;
const ItemProduct = styled.div`
    padding: 0 10px;
    // border: 1px solid #eee;
`;
interface Props {
    products: any[]
}
const Products: React.FC<Props> = ({ products }) => {
    return (
        <Product1 className="product bg-white">
            <div className="row mb-2">
                {products &&
                    (
                        products.map((product: Product) => (
                            <div key={product._id} className="col-sm-6 col-md-4 col-lg-3 pb-3 " >
                                <ItemProduct>
                                    <Link to="">
                                        <Img className="img">
                                            <img src="/images/samsung.jpg" alt="OPPO Reno3 Pro" />
                                        </Img>
                                        <NameProduct>
                                            {product.name}
                                        </NameProduct>
                                        <div className="price d-flex justify-content-between align-items-center flex-wrap">
                                            <strong>{product.price}₫</strong>
                                            <button className="btn btn-outline-primary">Add to cart</button>
                                        </div>
                                        <Description>Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati, molestias?</Description>
                                    </Link>
                                </ItemProduct>

                            </div>
                        ))
                    )
                }
            </div>
        </Product1>
    )
}

Products.propTypes = {

}

export default Products

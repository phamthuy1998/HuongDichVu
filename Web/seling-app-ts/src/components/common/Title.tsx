import React from 'react';
import styled from 'styled-components';

const Category = styled.div`
    background: #fff;
    height: 3.75rem;
    border-bottom: 1px solid rgba(0,0,0,.05);
    padding: 0 1.25rem;
    display: flex;
    align-items: center;
    background: white;
`;
const MainTitle = styled.div`
    font-size: 1rem;
    font-weight: 500;
    flex: 1;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-right: 1.25rem;
    text-transform: uppercase;
`;
interface Props {
    title: string
}
const Title: React.FC<Props> = ({ title }) => {
    return (
        <Category id="products1" >
            <MainTitle>
                <span>{title}</span>
            </MainTitle>
        </Category>
    )
}

export default Title

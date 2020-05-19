import React from 'react'
import Title from '../common/Title'
import styled from 'styled-components';
import { Link } from 'react-router-dom';
const Ul = styled.ul`
`;
const Li = styled.li`
    padding: 10px 0;
    border-bottom: 1px solid #e5e4e4;
`;
interface Props {
    categorys: any[]
}
const Category: React.FC<Props> = ({ categorys }) => {
    return (
        <>
            <Title title="Categorys" />
            <Ul>
                <Li >
                    <Link to="/products">Tất cả sản phẩm</Link>
                </Li>

                {categorys.map(category => (
                    <Li key={category.CateId}>
                        <Link to={`/allProsOfCate/${category.CateId}`}>{category.CateName}</Link>
                    </Li>
                ))}

            </Ul>
        </>
    )
}

export default React.memo(Category)

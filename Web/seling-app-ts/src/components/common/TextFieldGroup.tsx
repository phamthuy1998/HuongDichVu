import React from 'react';
import classnames from 'classnames';
import PropTypes from 'prop-types';

const TextFieldGroup = ({
    name,
    placeholder,
    value,
    label,
    error,
    info,
    type,
    onChange,
    disabled,
    classname,
    autocomplete,
    required

}) => {

    return (
        <div className="custom-form-group mt-4">
            <input type={type} placeholder={placeholder} autoComplete={autocomplete} name={name} value={value} onChange={onChange} disabled={disabled} required={required}
                className={classnames(classname, {
                    'is-invalid': error
                })}
            />
            {label && <label>{label}</label>}
            <span></span>
            {info && <small className="form-text text-muted">{info}</small>}
            {error && <div className="invalid-feedback d-block">{error}</div>}
        </div>
    );

};

TextFieldGroup.propTypes = {
    name: PropTypes.string.isRequired,
    placeholder: PropTypes.string,
    value: PropTypes.string.isRequired,
    info: PropTypes.string,
    error: PropTypes.string,
    type: PropTypes.string.isRequired,
    onChange: PropTypes.func.isRequired,
    disabled: PropTypes.string,
    label: PropTypes.string,
    classname: PropTypes.string,
    autocomplete: PropTypes.oneOf(['on', 'off']),
    required: PropTypes.bool
};


TextFieldGroup.defaultProps = {
    type: 'text'
};

export default TextFieldGroup;
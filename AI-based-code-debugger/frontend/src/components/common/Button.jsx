import React from 'react';
import styled from 'styled-components';

const StyledButton = styled.button`
  background-color: ${props => props.variant === 'secondary' ? '#6c757d' : '#007bff'};
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1rem;
  transition: background-color 0.2s;

  &:hover {
    background-color: ${props => props.variant === 'secondary' ? '#5a6268' : '#0056b3'};
  }

  &:disabled {
    background-color: #ccc;
    cursor: not-allowed;
  }
`;

const Button = ({ children, onClick, disabled, variant }) => {
    return (
        <StyledButton onClick={onClick} disabled={disabled} variant={variant}>
            {children}
        </StyledButton>
    );
};

export default Button;

import React from 'react';
import styled from 'styled-components';

const Panel = styled.div`
  background-color: white;
  border-radius: 8px;
  padding: 1.5rem;
  box-shadow: 0 4px 6px rgba(0,0,0,0.05);
  margin-bottom: 1.5rem;
`;

const Title = styled.h3`
  margin-top: 0;
  color: #dc3545;
  border-bottom: 1px solid #eee;
  padding-bottom: 0.5rem;
`;

const ErrorItem = styled.div`
  background-color: #fff5f5;
  border-left: 4px solid #dc3545;
  padding: 1rem;
  margin-bottom: 0.5rem;
`;

const ErrorPanel = ({ errors }) => {
    if (!errors || errors.length === 0) return null;

    return (
        <Panel>
            <Title>Errors Found ({errors.length})</Title>
            {errors.map((error, index) => (
                <ErrorItem key={index}>
                    <strong>Line {error.line}:</strong> {error.message}
                    <div style={{ fontSize: '0.9rem', color: '#666', marginTop: '0.25rem' }}>
                        Suggestion: {error.suggestion}
                    </div>
                </ErrorItem>
            ))}
        </Panel>
    );
};

export default ErrorPanel;

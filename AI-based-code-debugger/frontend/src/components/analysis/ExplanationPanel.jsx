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
  color: #6c757d;
  border-bottom: 1px solid #eee;
  padding-bottom: 0.5rem;
`;

const Content = styled.div`
  white-space: pre-line;
  color: #333;
  line-height: 1.6;
`;

const ExplanationPanel = ({ feedback }) => {
    if (!feedback) return null;

    return (
        <Panel>
            <Title>AI Analysis</Title>
            <Content>{feedback}</Content>
        </Panel>
    );
};

export default ExplanationPanel;

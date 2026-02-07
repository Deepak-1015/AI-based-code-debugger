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
  color: #007bff;
  border-bottom: 1px solid #eee;
  padding-bottom: 0.5rem;
`;

const Metric = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.5rem;
  font-weight: 500;
`;

const Badge = styled.span`
  background-color: #e7f1ff;
  color: #007bff;
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  font-size: 0.9rem;
`;

const Description = styled.p`
  color: #555;
  line-height: 1.5;
`;

const ComplexityPanel = ({ complexity }) => {
    if (!complexity) return null;

    return (
        <Panel>
            <Title>Complexity Analysis</Title>
            {complexity.timeComplexity && (
                <Metric>
                    Time Complexity <Badge>{complexity.timeComplexity}</Badge>
                </Metric>
            )}
            {complexity.spaceComplexity && (
                <Metric>
                    Space Complexity <Badge>{complexity.spaceComplexity}</Badge>
                </Metric>
            )}
            <Description>{complexity.description}</Description>
        </Panel>
    );
};

export default ComplexityPanel;

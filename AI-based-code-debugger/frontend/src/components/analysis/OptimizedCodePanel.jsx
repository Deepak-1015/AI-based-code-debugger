import React from 'react';
import styled from 'styled-components';
import Editor from '@monaco-editor/react';

const Panel = styled.div`
  background-color: white;
  border-radius: 8px;
  padding: 1.5rem;
  box-shadow: 0 4px 6px rgba(0,0,0,0.05);
  margin-bottom: 1.5rem;
`;

const Title = styled.h3`
  margin-top: 0;
  color: #28a745;
  border-bottom: 1px solid #eee;
  padding-bottom: 0.5rem;
`;

const EditorWrapper = styled.div`
  border: 1px solid #ced4da;
  border-radius: 4px;
  overflow: hidden;
  height: 300px;
  margin-top: 1rem;
`;

const OptimizedCodePanel = ({ optimization, language }) => {
    if (!optimization) return null;

    return (
        <Panel>
            <Title>Optimization Suggestions</Title>
            <p>{optimization.explanation}</p>

            {optimization.optimizedCode && (
                <EditorWrapper>
                    <Editor
                        height="100%"
                        language={language.toLowerCase()}
                        value={optimization.optimizedCode}
                        theme="light"
                        options={{
                            readOnly: true,
                            minimap: { enabled: false },
                            scrollBeyondLastLine: false,
                        }}
                    />
                </EditorWrapper>
            )}

            {optimization.improvements && (
                <ul>
                    {optimization.improvements.map((item, index) => (
                        <li key={index}>{item}</li>
                    ))}
                </ul>
            )}
        </Panel>
    );
};

export default OptimizedCodePanel;

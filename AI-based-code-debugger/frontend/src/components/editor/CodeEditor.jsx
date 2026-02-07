import React from 'react';
import Editor from '@monaco-editor/react';
import styled from 'styled-components';

const EditorContainer = styled.div`
  border: 1px solid #ced4da;
  border-radius: 4px;
  overflow: hidden;
  height: 500px;
`;

const CodeEditor = ({ code, language, onChange }) => {
    return (
        <EditorContainer>
            <Editor
                height="100%"
                language={language.toLowerCase()}
                value={code}
                theme="light"
                onChange={onChange}
                options={{
                    minimap: { enabled: false },
                    fontSize: 14,
                    scrollBeyondLastLine: false,
                }}
            />
        </EditorContainer>
    );
};

export default CodeEditor;

import React, { useState } from 'react';
import styled from 'styled-components';
import CodeEditor from '../components/editor/CodeEditor';
import LanguageSelector from '../components/editor/LanguageSelector';
import AgendaSelector from '../components/editor/AgendaSelector';
import Button from '../components/common/Button';
import Loader from '../components/common/Loader';
import Toast from '../components/common/Toast';
import ErrorPanel from '../components/analysis/ErrorPanel';
import ComplexityPanel from '../components/analysis/ComplexityPanel';
import OptimizedCodePanel from '../components/analysis/OptimizedCodePanel';
import ExplanationPanel from '../components/analysis/ExplanationPanel';
import { analyzeCode } from '../services/analysisApi';

const Container = styled.div`
  max-width: 1200px;
  margin: 2rem auto;
  padding: 0 1rem;
`;

const Controls = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1rem;
  background-color: white;
  padding: 1rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.05);
`;

const ControlGroup = styled.div`
  display: flex;
  align-items: center;
`;

const ResultsContainer = styled.div`
  margin-top: 2rem;
`;

const Dashboard = () => {
    const [code, setCode] = useState('// Write your code here...');
    const [language, setLanguage] = useState('JAVA');
    const [agenda, setAgenda] = useState('ALL');
    const [loading, setLoading] = useState(false);
    const [result, setResult] = useState(null);
    const [error, setError] = useState(null);

    const handleAnalyze = async () => {
        setLoading(true);
        setError(null);
        setResult(null);
        try {
            const data = await analyzeCode(code, language);
            setResult(data);
        } catch (err) {
            setError(err.message || 'An error occurred during analysis');
        } finally {
            setLoading(false);
        }
    };

    return (
        <Container>
            <Controls>
                <ControlGroup>
                    <LanguageSelector selectedLanguage={language} onSelect={setLanguage} />
                    <AgendaSelector selectedAgenda={agenda} onSelect={setAgenda} />
                </ControlGroup>
                <Button onClick={handleAnalyze} disabled={loading}>
                    {loading ? 'Analyzing...' : 'Analyze Code'}
                </Button>
            </Controls>

            <div style={{ display: 'grid', gridTemplateColumns: '1fr', gap: '2rem' }}>
                <CodeEditor code={code} language={language} onChange={setCode} />

                {loading && <Loader />}

                {result && (
                    <ResultsContainer>
                        <ErrorPanel errors={result.errors} />
                        <ComplexityPanel complexity={result.complexity} />
                        <OptimizedCodePanel optimization={result.optimization} language={language} />
                        <ExplanationPanel feedback={result.aiFeedback} />
                    </ResultsContainer>
                )}
            </div>

            {error && <Toast message={error} type="error" onClose={() => setError(null)} />}
        </Container>
    );
};

export default Dashboard;

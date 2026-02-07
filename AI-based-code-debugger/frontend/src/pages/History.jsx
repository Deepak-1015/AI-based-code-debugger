import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { getHistory } from '../services/analysisApi';
import { formatDate } from '../utils/formatter';
import Loader from '../components/common/Loader';

const Container = styled.div`
  max-width: 800px;
  margin: 2rem auto;
  padding: 0 1rem;
`;

const Title = styled.h2`
  color: #333;
  margin-bottom: 2rem;
`;

const HistoryList = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1rem;
`;

const HistoryItem = styled.div`
  background-color: white;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.05);
  cursor: pointer;
  transition: transform 0.2s;

  &:hover {
    transform: translateY(-2px);
  }
`;

const HistoryHeader = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 0.5rem;
`;

const LanguageBadge = styled.span`
  background-color: #e7f1ff;
  color: #007bff;
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  font-size: 0.9rem;
`;

const CodeSnippet = styled.pre`
  background-color: #f8f9fa;
  padding: 0.5rem;
  border-radius: 4px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 0.9rem;
  color: #666;
`;

const History = () => {
    const [history, setHistory] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchHistory = async () => {
            try {
                const data = await getHistory();
                setHistory(data);
            } catch (error) {
                console.error('Failed to fetch history', error);
            } finally {
                setLoading(false);
            }
        };

        fetchHistory();
    }, []);

    if (loading) return <Loader />;

    return (
        <Container>
            <Title>Analysis History</Title>
            <HistoryList>
                {history.map((item) => (
                    <HistoryItem key={item.id}>
                        <HistoryHeader>
                            <LanguageBadge>{item.language}</LanguageBadge>
                            <span style={{ color: '#999', fontSize: '0.9rem' }}>{formatDate(item.createdAt)}</span>
                        </HistoryHeader>
                        <CodeSnippet>{item.code}</CodeSnippet>
                    </HistoryItem>
                ))}
            </HistoryList>
        </Container>
    );
};

export default History;

import React from 'react';
import styled from 'styled-components';

const Select = styled.select`
  padding: 0.5rem;
  border-radius: 4px;
  border: 1px solid #ced4da;
  font-size: 1rem;
`;

const AgendaSelector = ({ selectedAgenda, onSelect }) => {
    const agendas = [
        { value: 'ALL', label: 'Full Analysis' },
        { value: 'SYNTAX', label: 'Check Syntax Only' },
        { value: 'COMPLEXITY', label: 'Check Complexity' },
        { value: 'OPTIMIZATION', label: 'Suggest Optimization' }
    ];

    return (
        <Select value={selectedAgenda} onChange={(e) => onSelect(e.target.value)}>
            {agendas.map((agenda) => (
                <option key={agenda.value} value={agenda.value}>
                    {agenda.label}
                </option>
            ))}
        </Select>
    );
};

export default AgendaSelector;

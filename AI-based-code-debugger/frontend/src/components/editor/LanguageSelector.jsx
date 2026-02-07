import React from 'react';
import styled from 'styled-components';
import { LANGUAGES } from '../../utils/constants';

const Select = styled.select`
  padding: 0.5rem;
  border-radius: 4px;
  border: 1px solid #ced4da;
  font-size: 1rem;
  margin-right: 1rem;
`;

const LanguageSelector = ({ selectedLanguage, onSelect }) => {
    return (
        <Select value={selectedLanguage} onChange={(e) => onSelect(e.target.value)}>
            {LANGUAGES.map((lang) => (
                <option key={lang.value} value={lang.value}>
                    {lang.label}
                </option>
            ))}
        </Select>
    );
};

export default LanguageSelector;

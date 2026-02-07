import axios from 'axios';
import { API_BASE_URL } from '../utils/constants';

const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

export const analyzeCode = async (code, language) => {
    try {
        const response = await api.post('/analysis/analyze', { code, language });
        return response.data;
    } catch (error) {
        throw error.response ? error.response.data : new Error('Network Error');
    }
};

export const getHistory = async () => {
    try {
        const response = await api.get('/analysis/history');
        return response.data;
    } catch (error) {
        throw error;
    }
};

export const getHistoryById = async (id) => {
    try {
        const response = await api.get(`/analysis/history/${id}`);
        return response.data;
    } catch (error) {
        throw error;
    }
};

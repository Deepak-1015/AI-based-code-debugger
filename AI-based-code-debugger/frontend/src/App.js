import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Dashboard from './pages/Dashboard';
import History from './pages/History';
import styled from 'styled-components';

const AppContainer = styled.div`
  font-family: 'Inter', sans-serif;
  background-color: #f8f9fa;
  min-height: 100vh;
`;

const NavBar = styled.nav`
  background-color: #ffffff;
  padding: 1rem 2rem;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const Logo = styled.h1`
  font-size: 1.5rem;
  color: #333;
  margin: 0;
`;

function App() {
  return (
    <Router>
      <AppContainer>
        <NavBar>
          <Logo>AI Code Debugger</Logo>
        </NavBar>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/history" element={<History />} />
        </Routes>
      </AppContainer>
    </Router>
  );
}

export default App;

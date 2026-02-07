# Coded Frontend - AI Code Debugger

This is the React frontend for the AI-based Code Debugger application.

## Project Structure

- `public/`: Static assets (HTML, favicon)
- `src/`: Source code
    - `components/`: Reusable UI components
        - `editor/`: Code editor and selectors
        - `analysis/`: Analysis result panels
        - `common/`: Shared components
    - `pages/`: Application pages (Dashboard, History)
    - `services/`: API integration
    - `utils/`: Helper functions

## how to Run

1.  **Install Dependencies**:
    ```bash
    npm install
    ```

2.  **Start the Application**:
    ```bash
    npm start
    ```

The application will be available at `http://localhost:3000`.

## Features

- **Code Editor**: Monaco-based editor with syntax highlighting.
- **Analysis**: View errors, complexity, and optimizations.
- **AI Feedback**: Receive detailed explanations from the AI backend.
- **History**: View past analysis results.

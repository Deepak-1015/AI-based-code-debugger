# AI Code Debugger (Spring Boot + React)

This project provides a starter scaffold for an AI-based code debugging workflow, with a Spring Boot API and a React UI.

## Backend (Spring Boot)

```bash
cd backend
mvn spring-boot:run
```

API endpoint:

- `POST /api/debug`
  - Body: `{ "repoPath": "/path/to/repo", "issueDescription": "Bug summary" }`

## Frontend (React + Vite)

```bash
cd frontend
npm install
npm run dev
```

The UI currently uses a mocked response. Wire it up to the backend by calling `http://localhost:8080/api/debug` from the form handler.

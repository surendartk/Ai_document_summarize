# AI-Powered Document Intelligence Platform

## Overview

A full-stack application that allows users to upload PDF documents and ask questions about their content using AI.

The application consists of:

* React Frontend
* Spring Boot Backend
* Python FastAPI Service for PDF text extraction

---

## Features

* Upload PDF documents
* View uploaded documents
* Extract text from PDFs
* Ask questions about uploaded documents
* AI-powered document analysis

---

## Tech Stack

### Frontend

* React
* React Router
* Axios

### Backend

* Java 21
* Spring Boot
* Maven

### AI Service

* Python
* FastAPI
* PyPDF2

---

## Project Structure

```text
frontend/
backend/
 ├── springboot-service/
 └── document-ai-service/
uploads/
```

---

## Run Locally

### 1. Start Spring Boot Backend

```bash
cd backend/springboot-service

mvn spring-boot:run
```

Runs on:

```text
http://localhost:8080
```

---

### 2. Start Python Service

Create virtual environment:

```bash
python -m venv venv
```

Activate:

Windows:

```bash
venv\Scripts\activate
```

Install dependencies:

```bash
pip install -r requirements.txt
```

Run FastAPI:

```bash
uvicorn app:app --reload --port 8000
```

Runs on:

```text
http://localhost:8000
```

---

### 3. Start React Frontend

```bash
cd frontend

npm install

npm run dev
```

Runs on:

```text
http://localhost:5173
```

---

## Workflow

```text
Upload PDF
    ↓
Store File
    ↓
Extract Text
    ↓
Ask Question
    ↓
AI Response
```

---

## Future Improvements

* ChromaDB Integration
* Retrieval-Augmented Generation (RAG)
* Multi-document Search
* Document Summarization
* AWS Deployment
* Docker Support

---



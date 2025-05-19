import React, { useState } from 'react';
import ResumeJDForm from './ResumeJDForm';
import Interview from './Interview';
import ScoreViewer from './ScoreViewer';

function App() {
  const [page, setPage] = useState("upload");

  return (
    <div style={{ padding: 20 }}>
      <button onClick={() => setPage("upload")}>Resume & JD Upload</button>
      <button onClick={() => setPage("interview")}>Interview</button>
      <button onClick={() => setPage("score")}>View Score</button>
      {page === "upload" ? <ResumeJDForm /> :
       page === "interview" ? <Interview /> :
       <ScoreViewer />}
    </div>
  );
}

export default App;
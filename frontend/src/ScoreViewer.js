import React, { useState } from 'react';
import axios from 'axios';
import ScoreChart from './ScoreChart';

function ScoreViewer() {
  const [sessionId, setSessionId] = useState('');
  const [score, setScore] = useState(null);

  const fetchScore = async () => {
    const response = await axios.post('http://localhost:8080/api/scoring/generate', null, {
      params: { sessionId }
    });
    setScore(response.data);
  };

  const downloadPDF = () => {
    window.open(`http://localhost:8080/api/pdf/download?scoreId=${score.id}`, '_blank');
  };

  return (
    <div>
      <h2>Generate Score & Report</h2>
      <input
        type="text"
        placeholder="Session ID"
        value={sessionId}
        onChange={(e) => setSessionId(e.target.value)}
      />
      <button onClick={fetchScore}>Get Score</button>
      {score && (
        <>
          <ScoreChart score={score} />
          <button onClick={downloadPDF}>Download PDF Report</button>
        </>
      )}
    </div>
  );
}

export default ScoreViewer;
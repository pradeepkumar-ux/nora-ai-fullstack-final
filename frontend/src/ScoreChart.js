import React from 'react';
import { BarChart, Bar, XAxis, YAxis, Tooltip, CartesianGrid } from 'recharts';

function ScoreChart({ score }) {
  const data = [
    { name: 'Communication', value: score.communication },
    { name: 'Problem Solving', value: score.problemSolving },
    { name: 'Confidence', value: score.confidence },
  ];

  return (
    <div>
      <h3>Performance Score</h3>
      <BarChart width={400} height={300} data={data}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="name" />
        <YAxis domain={[0, 10]} />
        <Tooltip />
        <Bar dataKey="value" fill="#8884d8" />
      </BarChart>
    </div>
  );
}

export default ScoreChart;
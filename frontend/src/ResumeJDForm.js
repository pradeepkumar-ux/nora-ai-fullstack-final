import React, { useState } from 'react';
import axios from 'axios';

function ResumeJDForm() {
  const [resumeData, setResumeData] = useState({
    name: '', email: '', phone: '', skills: '', text: ''
  });
  const [jdData, setJdData] = useState({
    position: '', skills: '', text: ''
  });

  const handleResumeChange = (e) => setResumeData({ ...resumeData, [e.target.name]: e.target.value });
  const handleJdChange = (e) => setJdData({ ...jdData, [e.target.name]: e.target.value });

  const submitResume = async () => {
    await axios.post('http://localhost:8080/api/interview/upload-resume', null, { params: resumeData });
    alert('Resume Uploaded');
  };

  const submitJD = async () => {
    await axios.post('http://localhost:8080/api/interview/upload-jd', null, { params: jdData });
    alert('Job Description Uploaded');
  };

  return (
    <div>
      <h2>Resume Upload</h2>
      {['name','email','phone','skills','text'].map((field) => (
        <div key={field}>
          <input name={field} placeholder={field} onChange={handleResumeChange} />
        </div>
      ))}
      <button onClick={submitResume}>Submit Resume</button>

      <h2 style={{ marginTop: 30 }}>Job Description Upload</h2>
      {['position','skills','text'].map((field) => (
        <div key={field}>
          <input name={field} placeholder={field} onChange={handleJdChange} />
        </div>
      ))}
      <button onClick={submitJD}>Submit JD</button>
    </div>
  );
}

export default ResumeJDForm;
import React, { useState, useEffect } from 'react';

function Interview() {
  const [question, setQuestion] = useState("Tell me about yourself.");
  const [answer, setAnswer] = useState("");
  const [isSpeaking, setIsSpeaking] = useState(false);

  const speak = (text) => {
    const utterance = new SpeechSynthesisUtterance(text);
    utterance.onend = () => setIsSpeaking(false);
    setIsSpeaking(true);
    window.speechSynthesis.speak(utterance);
  };

  const startListening = () => {
    const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
    const recognition = new SpeechRecognition();
    recognition.lang = 'en-US';
    recognition.interimResults = false;
    recognition.maxAlternatives = 1;
    recognition.onresult = (event) => {
      const transcript = event.results[0][0].transcript;
      setAnswer(transcript);
      // Here you can send the answer to backend for processing
    };
    recognition.start();
  };

  useEffect(() => {
    speak(question);
  }, [question]);

  return (
    <div style={{ padding: 20 }}>
      <h2>Interview</h2>
      <p><strong>Question:</strong> {question}</p>
      <textarea value={answer} onChange={(e) => setAnswer(e.target.value)} rows={4} cols={50} />
      <br />
      <button onClick={startListening}>Start Speaking</button>
      <button onClick={() => speak(answer)}>Read Answer</button>
    </div>
  );
}

export default Interview;
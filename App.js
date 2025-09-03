import React, { useState, useEffect } from "react";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/hello")
      .then((res) => res.text())
      .then(setMessage)
      .catch((err) => setMessage("Failed to fetch message"));
  }, []);

  return (
    <div style={{ marginTop: "50px", textAlign: "center" }}>
      <h1>HelloWorld From React</h1>
      <h2>{message}</h2>
    </div>
  );
}

export default App;


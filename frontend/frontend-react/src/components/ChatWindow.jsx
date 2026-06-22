import { useState } from "react";
import axios from "axios";

function ChatWindow() {
  const [question, setQuestion] = useState("");
  const [answer, setAnswer] = useState("");
  const [loading, setLoading] = useState(false);

  const askQuestion = async () => {
    if (!question.trim()) return;

    try {
      setLoading(true);

      const response = await axios.post("http://localhost:8080/api/chat/ask", {
        fileName: "ml_project.pdf",
        question: question,
      });

      setAnswer(response.data);
    } catch (error) {
      console.error(error);
      setAnswer("Failed to get response");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <textarea
        rows="5"
        cols="60"
        value={question}
        onChange={(e) => setQuestion(e.target.value)}
        placeholder="Ask anything from documents..."
      />

      <br />

      <button onClick={askQuestion} disabled={loading}>
        {loading ? "Thinking..." : "Ask"}
      </button>

      {answer && (
        <div
          style={{
            marginTop: "20px",
            padding: "10px",
            border: "1px solid gray",
          }}
        >
          <strong>Answer:</strong>
          <p>{answer}</p>
        </div>
      )}
    </div>
  );
}

export default ChatWindow;

import ChatWindow from "../components/ChatWindow";

function ChatPage() {
  return (
    <div
      style={{
        minHeight: "90vh",
        background: "#f8fafc",
        padding: "40px",
      }}
    >
      <div
        style={{
          maxWidth: "1000px",
          margin: "0 auto",
          background: "white",
          borderRadius: "20px",
          padding: "30px",
          boxShadow: "0 10px 30px rgba(0,0,0,0.1)",
        }}
      >
        <h1
          style={{
            color: "#1e293b",
            marginBottom: "10px",
          }}
        >
          AI Document Chat
        </h1>

        <p
          style={{
            color: "#64748b",
            marginBottom: "25px",
          }}
        >
          Ask questions from your uploaded documents
        </p>

        <ChatWindow />
      </div>
    </div>
  );
}

export default ChatPage;

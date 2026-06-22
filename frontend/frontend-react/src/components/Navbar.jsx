import { Link } from "react-router-dom";
import "./Navbar.css";
function Navbar() {
  return (
    <nav
      style={{
        display: "flex",
        justifyContent: "center",
        gap: "25px",
        padding: "18px 30px",
        background: "linear-gradient(135deg, #0f172a, #1e293b)",
        boxShadow: "0 8px 30px rgba(0,0,0,0.25)",
        position: "sticky",
        top: 0,
        zIndex: 1000,
      }}
    >
      <Link to="/" style={linkStyle}>
        Upload
      </Link>

      <Link to="/documents" style={linkStyle}>
        Documents
      </Link>

      <Link to="/chat" style={linkStyle}>
        AI Chat
      </Link>
    </nav>
  );
}

const linkStyle = {
  color: "#f8fafc",
  textDecoration: "none",
  padding: "12px 24px",
  borderRadius: "12px",
  fontWeight: "600",
  fontSize: "16px",
  transition: "all 0.3s ease",
  background: "rgba(255,255,255,0.08)",
  backdropFilter: "blur(10px)",
  boxShadow: "0 4px 15px rgba(0,0,0,0.15)",
};

export default Navbar;

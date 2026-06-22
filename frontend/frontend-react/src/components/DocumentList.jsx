import { useEffect, useState } from "react";
import api from "../api/api";

function DocumentList() {
  const [documents, setDocuments] = useState([]);

  useEffect(() => {
    const fetchDocuments = async () => {
      try {
        const response = await api.get("");
        console.log(response.data);

        setDocuments([...response.data]);
      } catch (error) {
        console.error(error);
      }
    };

    fetchDocuments();
  }, []);

  return (
    <div>
      <h3>Total Documents: {documents.length}</h3>

      <ul>
        {documents.map((doc) => (
          <li key={doc}>{doc}</li>
        ))}
      </ul>
    </div>
  );
}

export default DocumentList;

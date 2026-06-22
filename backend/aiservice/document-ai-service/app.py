from fastapi import FastAPI, UploadFile
from pypdf import PdfReader
import tempfile

app = FastAPI()

@app.post("/extract")
async def extract_text(file: UploadFile):

    with tempfile.NamedTemporaryFile(delete=False) as temp:

        temp.write(await file.read())

        reader = PdfReader(temp.name)

        text = ""

        for page in reader.pages:
            text += page.extract_text() or ""

    return {
        "text": text
    }


   
package org.example.factory;

import org.example.impl.Document;
import org.example.impl.PdfDocumentImpl;

public class PdfDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new PdfDocumentImpl();
    }
}

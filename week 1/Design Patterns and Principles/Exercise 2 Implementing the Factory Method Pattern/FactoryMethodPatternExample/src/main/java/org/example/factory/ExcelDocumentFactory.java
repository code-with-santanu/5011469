package org.example.factory;

import org.example.impl.Document;
import org.example.impl.ExcelDocumentImpl;

public class ExcelDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new ExcelDocumentImpl();
    }
}

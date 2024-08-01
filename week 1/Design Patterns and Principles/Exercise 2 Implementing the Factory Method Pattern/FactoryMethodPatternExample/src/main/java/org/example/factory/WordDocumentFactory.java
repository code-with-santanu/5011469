package org.example.factory;

import org.example.impl.Document;
import org.example.impl.WordDocumentImpl;

public class WordDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new WordDocumentImpl();
    }
}

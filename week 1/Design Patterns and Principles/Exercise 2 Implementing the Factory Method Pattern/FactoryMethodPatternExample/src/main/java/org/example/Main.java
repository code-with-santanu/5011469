package org.example;

import org.example.factory.DocumentFactory;
import org.example.factory.ExcelDocumentFactory;
import org.example.factory.PdfDocumentFactory;
import org.example.factory.WordDocumentFactory;
import org.example.impl.Document;

public class Main {
    public static void main(String[] args) {
        // Create a Word document using the factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        // Create a PDF document using the factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        // Create an Excel document using the factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}
package org.example.impl;

public class ExcelDocumentImpl implements ExcelDocument{
    @Override
    public void open() {
        System.out.println("Opening Excel document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document.");
    }
}

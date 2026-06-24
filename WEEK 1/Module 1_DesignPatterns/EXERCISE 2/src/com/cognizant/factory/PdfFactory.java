package com.cognizant.factory;


public class PdfFactory extends DocumentFactory {


    public Document createDocument(){

        return new PdfDocument();

    }


}
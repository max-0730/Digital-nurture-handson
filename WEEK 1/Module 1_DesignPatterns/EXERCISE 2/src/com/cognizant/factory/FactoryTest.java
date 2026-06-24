package com.cognizant.factory;


public class FactoryTest {


public static void main(String[] args){



    DocumentFactory factory;



    factory = new WordFactory();

    Document word = factory.createDocument();

    word.open();




    factory = new PdfFactory();

    Document pdf = factory.createDocument();

    pdf.open();





    factory = new ExcelFactory();

    Document excel = factory.createDocument();

    excel.open();



}


}
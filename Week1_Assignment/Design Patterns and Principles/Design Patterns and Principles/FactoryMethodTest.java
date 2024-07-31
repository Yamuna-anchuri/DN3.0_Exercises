public class FactoryMethodTest { 
    public static void main(String[] args) { 
        // Create a Word document using WordDocumentFactory 
        DocumentFactory wordFactory = new WordDocumentFactory(); 
        Document wordDoc = wordFactory.createDocument(); 
        wordDoc.open(); 
        wordDoc.save(); 
        wordDoc.close(); 
 
        // Create a PDF document using PdfDocumentFactory 
        DocumentFactory pdfFactory = new PdfDocumentFactory(); 
        Document pdfDoc = pdfFactory.createDocument(); 
        pdfDoc.open(); 
        pdfDoc.save(); 
        pdfDoc.close(); 
 
        // Create an Excel document using ExcelDocumentFactory 
        DocumentFactory excelFactory = new ExcelDocumentFactory(); 
        Document excelDoc = excelFactory.createDocument(); 
        excelDoc.open(); 
        excelDoc.save(); 
        excelDoc.close(); 
    } 
}
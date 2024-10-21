package LLDPractice.SingleResponsibility;

public class Main {
    //Single responsibility principal
    // Open/close principal
    // Liskov substitution principal
    // Interface segmented principal
    // Dependency Inversion principal

    public static void main(String[] args) {
        System.out.println("without Single responsibility principal");
        Invoice invoice = new Invoice(10, 5);
        System.out.println(invoice.getPrice());// Single responsibility principal-> everything in single file
        invoice.printLogs();
        invoice.saveToDb();

        System.out.println("with Single responsibility principal");
        InvoiceDAO invoiceDAO = new InvoiceDAO(10, 5);
        System.out.println(invoiceDAO.getPrice());
        PrintInvoice printInvoice = new PrintInvoice(invoiceDAO);
        printInvoice.print();

        SaveInvoice saveInvoice = new SaveInvoice(invoiceDAO, "DB");
        saveInvoice.save();
    }
}

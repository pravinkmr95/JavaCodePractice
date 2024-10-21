package LLDPractice.SingleResponsibility;

public class SaveInvoice {
    InvoiceDAO invoice;
    String storageType;
    public SaveInvoice(InvoiceDAO invoice, String storageType){
        this.invoice = invoice;
        this.storageType = storageType;
    }

    public void save(){
        if (storageType.equalsIgnoreCase("DB")){
            System.out.println("Saving the invoice data " + invoice.getPrice() + " to " + storageType);
            // logic
        } else if (storageType.equalsIgnoreCase("Mongo")){
            System.out.println("Saving the invoice data " + invoice.getPrice() + " to " + storageType);
        }
    }
}

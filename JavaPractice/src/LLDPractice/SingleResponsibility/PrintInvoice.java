package LLDPractice.SingleResponsibility;

public class PrintInvoice {
    InvoiceDAO invoice;
    public PrintInvoice(InvoiceDAO invoice){
        this.invoice = invoice;
    }

    public void print(){
        int value = invoice.getPrice();
        System.out.println("Print invoice " + value);
    }
}

package LLDPractice.SingleResponsibility;

public class InvoiceDAO {
    protected int count;
    protected int price;
    public InvoiceDAO(int count, int price){
        this.count = count;
        this.price = price;
    }

    public int getPrice(){
        return price*count;
    }

}

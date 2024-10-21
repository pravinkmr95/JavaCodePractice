package LLDPractice.SingleResponsibility;


public class Invoice {
    protected int count;
    protected int price;
    public Invoice(int count, int price){
        this.count = count;
        this.price = price;
    }

    public int getPrice(){
        return price*count;
    }

    public void printLogs(){
        System.out.println("printing Logs");
    }

    public void saveToDb(){
        System.out.println("Saving to db");
    }
}

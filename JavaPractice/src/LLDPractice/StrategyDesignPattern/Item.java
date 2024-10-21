package LLDPractice.StrategyDesignPattern;

public class Item {
    private String name;
    private String details;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.details = "";
    }

    public Item(String name, int price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

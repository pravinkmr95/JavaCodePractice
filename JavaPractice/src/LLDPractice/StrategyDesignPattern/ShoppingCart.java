package LLDPractice.StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> itemList;

    public ShoppingCart(){
        itemList = new ArrayList<>();
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public int calculateTotal(){
        int total = 0;
        for (Item item: itemList){
            total += item.getPrice();
        }
        return total;
    }

    public void pay(PaymentStrategy paymentStrategy){
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}

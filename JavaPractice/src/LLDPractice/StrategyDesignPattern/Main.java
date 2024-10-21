package LLDPractice.StrategyDesignPattern;

public class Main {
    /* The Strategy Design Pattern is a behavioral design pattern that allows you to define a family of algorithms,
     encapsulate each one as a separate class, and make them interchangeable. This pattern lets the algorithm vary
      independently from the clients that use it, promoting flexibility and reusability.
     */
    public static void main(String[] args) {
        Item item1 = new Item("item1", 10);
        Item item2 = new Item("item2", 20, "details of item2");
        Item item3 = new Item("item3", 220, "details of item3");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.addItem(item3);

        PaymentStrategy paypal = new Paypal("username", "password");
        shoppingCart.pay(paypal);

        Item item4 = new Item("item4", 2220, "details of item4");
        shoppingCart.addItem(item4);
        PaymentStrategy creditCardPayment = new CreditCardPayment("abcd", "20/30", 770);
        shoppingCart.pay(creditCardPayment);
    }
}

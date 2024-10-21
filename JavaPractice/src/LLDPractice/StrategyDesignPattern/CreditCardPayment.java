package LLDPractice.StrategyDesignPattern;

public class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    private String expiry;
    private int CVV;

    public CreditCardPayment(String cardNumber, String expiry, int CVV){
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.CVV = CVV;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Payment via credit card of " + amount);
        return true;
    }
}

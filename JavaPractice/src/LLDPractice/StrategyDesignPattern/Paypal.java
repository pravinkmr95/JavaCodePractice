package LLDPractice.StrategyDesignPattern;

public class Paypal implements PaymentStrategy{
    private String username;
    private String password;

    public Paypal(String username, String password){
        this.username = username;
        this.password  = password;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Payment done via paypal of " + amount);
        return true;
    }
}

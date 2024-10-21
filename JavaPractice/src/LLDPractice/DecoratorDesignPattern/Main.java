package LLDPractice.DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Pizza pineApplePizza = new PineApplePizza(new Jalapino());
        System.out.println(pineApplePizza.price());
        Pizza pineAppleWithCheesePizza = new CheesePizza(pineApplePizza);

        System.out.println(pineAppleWithCheesePizza.price());

        Pizza jalapinoAndCheese = new CheesePizza(new Jalapino());
        System.out.println(jalapinoAndCheese.price());

        Pizza exp = new CheesePizza(jalapinoAndCheese);
        System.out.println(exp.price());
    }
}

package LLDPractice.DecoratorDesignPattern;


public class PineApplePizza implements Pizza{
    BasePizza basePizza;

    public PineApplePizza(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int price() {
        return this.basePizza.price() + 20;
    }
}

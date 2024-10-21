package LLDPractice.DecoratorDesignPattern;

public class CheesePizza implements Pizza{
    BasePizza basePizza;

    public CheesePizza(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int price() {
        return this.basePizza.price() + 10;
    }
}

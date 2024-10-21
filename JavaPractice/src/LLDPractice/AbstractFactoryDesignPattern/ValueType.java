package LLDPractice.AbstractFactoryDesignPattern;

public enum ValueType {
    TWOWHEELER,
    FOURWHEELER;

    public static void main(String[] args) {
        System.out.println(ValueType.FOURWHEELER);
        System.out.println(ValueType.TWOWHEELER);
    }
}

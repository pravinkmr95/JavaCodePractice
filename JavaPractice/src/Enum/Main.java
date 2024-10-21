package Enum;

public class Main {
    public static void main(String[] args) {
        for (Days day : Days.values()) {
            System.out.println(day.ordinal());
        }
        Days day = Days.valueOf("WEDNESDAY");
        System.out.println(day.name());

        DaysParam dayEnum = DaysParam.getEnum(5);
        if (dayEnum != null) {
            System.out.println(dayEnum.getComment());
        }
    }
}

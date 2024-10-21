package Enum;

public enum DaysParam {
    MONDAY(1, "First"),
    TUESDAY(2, "Second"),
    WEDNESDAY(3, "Third"),
    THURSDAY(4, "Fourth"),
    FRIDAY(5, "Fifth"),
    SATURDAY(6, "Sixth"),
    SUNDAY(7, "Seventh");

    private int number;
    private String comment;

    DaysParam(int number, String comment){
        this.number = number;
        this.comment = comment;
    }

    public int getNumber(){
        return this.number;
    }

    public String getComment(){
        return this.comment;
    }

    public static DaysParam getEnum(int num){
        for (DaysParam dayEnum: DaysParam.values()){
            if (dayEnum.getNumber() == num){
                return dayEnum;
            }
        }
        return null;
    }
}

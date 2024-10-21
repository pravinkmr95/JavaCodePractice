package InterfacePractice;

public interface Dog {
    default int legs(){
        return 2;
    }
}

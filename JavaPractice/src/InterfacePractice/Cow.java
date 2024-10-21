package InterfacePractice;

public interface Cow {
    default int legs(){
        return 2;
    }
}

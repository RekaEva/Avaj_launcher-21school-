public class WrongArgumentExeption extends RuntimeException {
    public WrongArgumentExeption() {
        super("Wrong Argument! The programm takes only one argument");
    }
}

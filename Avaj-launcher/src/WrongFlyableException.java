public class WrongFlyableException extends RuntimeException{
    public WrongFlyableException(String string) {
        super(string + "flyable is not found");
    }
}

package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public String error;
    public NegativeRadiusException(String error) {
        this.error = error;
    }
}
// END

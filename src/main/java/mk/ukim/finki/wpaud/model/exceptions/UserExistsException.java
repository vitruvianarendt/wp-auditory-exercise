package mk.ukim.finki.wpaud.model.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String username) {
        super(String.format("User with username: %s already exists", username));
    }
}

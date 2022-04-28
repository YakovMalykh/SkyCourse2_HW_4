package pro.sky.java.course2.skycourse2_hw_4.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestEmployeeException extends RuntimeException{
    public BadRequestEmployeeException(String message) {
        super(message);
    }

    public BadRequestEmployeeException() {
    }
}

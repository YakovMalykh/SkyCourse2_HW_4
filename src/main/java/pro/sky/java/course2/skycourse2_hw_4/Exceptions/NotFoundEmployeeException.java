package pro.sky.java.course2.skycourse2_hw_4.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEmployeeException extends RuntimeException{
    public NotFoundEmployeeException(String message) {
        super(message);
    }

    public NotFoundEmployeeException() {
    }
}

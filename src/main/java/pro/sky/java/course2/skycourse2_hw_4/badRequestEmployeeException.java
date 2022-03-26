package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class badRequestEmployeeException extends RuntimeException{
    public badRequestEmployeeException(String message) {
        super(message);
    }

    public badRequestEmployeeException() {
    }
}

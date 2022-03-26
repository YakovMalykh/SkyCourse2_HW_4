package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class notFoundEmployeeException extends RuntimeException{
    public notFoundEmployeeException(String message) {
        super(message);
    }

    public notFoundEmployeeException() {
    }
}

package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class internalServerErrorException extends RuntimeException{
    public internalServerErrorException(String message) {
        super(message);
    }

    public internalServerErrorException() {
    }
}

package mvcsample.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,
				reason="User Not Found")
public class UserNotFoundException extends RuntimeException{
	
}
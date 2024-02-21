if (player==null) throw new UserNotFoundException("id: "+id);

(1) Exception Class
(2) Exception Handler Class
(3) ErrorMessage Class

* do not have ErrorMessages enum, because it is hard coded: ("id: "+id)
* it is still working without: extends ResponseEntityExceptionHandler


//////////////////////////////////////////////////////////////////////////////////////////
@ResponseStatus(code=HttpStatus.NOT_FOUND) // 404 (before is 500) // do this convert class to ResponseEntity
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message) {
		super(message); //pass message to RuntimeException 
	}
}

////////////////////////////////////////////////////////////////////////////////////////// return sample - this is default object return
{
    "timestamp": "2024-02-21T04:08:01.942+00:00",
    "status": 404,
    "error": "Not Found",
    "trace": .................. (disable dev tool, it will be gone)
    "message": "id: 123",
    "path": "/players/123"
}

//////////////////////////////////////////////////////////////////////////////////////////
@ControllerAdvice // need this to be picked up by spring framework
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
	ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
			ex.getMessage(),
			request.getDescription(false));
	
	return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
	ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
			ex.getMessage(),
			request.getDescription(false));
	
	return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

}
//////////////////////////////////////////////////////////////////////////////////////////
package com.example.resr.webservices.restfulwebservices;

import java.time.LocalDate;

public class ErrorDetails {
	
	private LocalDate timestamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDate timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}

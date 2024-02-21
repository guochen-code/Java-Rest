if(userDetails.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FILED.getErrorMessage());

(1) custom exception class
(2) ErrorMessages enum
(3) ErrorMessage class
(4) Exception Hanlder Class

//////////////////////////////////////////////////////////////////////////////////////////////////////////// ErrorMessages enum
public enum ErrorMessages {
	
	MISSING_REQUIRED_FILED("missing required filed. please check documentation for required fields."),
	RECORD_ALREADY_EXISTS("record already exists."),
	INTERNAL_SERVER_ERROR("internal server error"),
	NO_RECORD_FOUND("record with provided id is not found."),
	AUTHENTICATION_FAILED("authentication failed."),
	COULD_NOT_UPDATE_RECORD("could not update record"),
	COULD_NOT_DELETE_RECORD("could not delete record"),
	EMAIL_ADDRESS_NOT_VERIFIED("email address could not be verified");
	
	private String errorMessage;
	
	ErrorMessages(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////// UserServiceException (custom exception class)
public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = -813550069695786855L;
	
	public UserServiceException(String message) {
		super(message);
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////// UserServiceException Handler - return plain message
@ControllerAdvice
public class AppExceptionsHandler {

	@ExceptionHandler(value= {UserServiceException.class})
	public ResponseEntity<Object> handleUserSerciceException(UserServiceException ex,WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); /////////////////// note it not returns an object, just plain message: ex.getMessage()
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////// how to return object, not plain message (ErrorMessage class)
public class ErrorMessage {
	
	private Date timestamp;
	private String message;
	
	
	public ErrorMessage() {}
	
	
	public ErrorMessage(Date timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////// return object
@ControllerAdvice
public class AppExceptionsHandler {
	@ExceptionHandler(value= {UserServiceException.class})
	public ResponseEntity<Object> handleUserSerciceException(UserServiceException ex,WebRequest request){
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		// note this returns object 
	}	
}

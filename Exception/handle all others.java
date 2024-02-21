// (1) can handle multiple exceptions together
@ControllerAdvice
public class AppExceptionsHandler {
	@ExceptionHandler(value= {UserServiceException.class, NullPointerException.class})
	public ResponseEntity<Object> handleMultipleException(Exception ex,WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		// note this returns object 
	}
	
}

// (2) hanlde all other exceptions
@ControllerAdvice
public class AppExceptionsHandler {
	@ExceptionHandler(value= {UserServiceException.class})
	public ResponseEntity<Object> handleUserSerciceException(UserServiceException ex,WebRequest request){	
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleOtherExceptions(Exception ex,WebRequest request){	
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
}

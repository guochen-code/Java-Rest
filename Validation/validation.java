<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

Maven dependency -> jakarta.validation -> jakarta.validation.constraints (lookup all the avaiable validation methods)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@PostMapping(path="/players")
	public ResponseEntity<Player> CreateOne(@Valid @RequestBody Player player){   //////////////////////////////////////////// @Valid
		Player savedPlayer = playerDaoService.CreateOne(player);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/players/{id}")
				.buildAndExpand(savedPlayer.getId())
				.toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package com.example.resr.webservices.restfulwebservices.player;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Player {
	
	private int id;
	
	@Size(min=2) //////////////////////////////////////////////////////////////////////////////////////////////////////////////// @Size(min=2,message="Name should have at least 2 characters)
	private String name;
	
	@Past //////////////////////////////////////////////////////////////////////////////////////////////////////////////// @Past(message = "birth date should be in the past")
	private LocalDate birthday;
	
	public Player(int id, String name, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
up to this stage, it only returns: 400 - invalid request content, but not telling users what is invalid. Need to customize that to give user more information to rectify their submission.

@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
  ex.getMessage(), request.getDescription(false));
  return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
further customize, because above returned message is too long, even though below is printed out, but buried in verbosed context, hard to locate these messages:
@Size(min=2,message="Name should have at least 2 characters)
@Past(message = "birth date should be in the past")

@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
  ex.getFieldError().getDefaultMessage(), request.getDescription(false)); // get first error associated with a field, if any // only show first error at a time
  return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
}

// ex.getFieldErrors(), then you can loop over it and return all errors at one time
// or  
// ex.getErrorCount()
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
  "Total Errors: " + ex.getErrorCount() + "; First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false)); // get first error associated with a field, if any // only show first error at a time
  return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
}


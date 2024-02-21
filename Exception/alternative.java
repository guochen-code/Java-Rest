if (player==null) throw new UserNotFoundException("id: "+id);


//////////////////////////////////////////////////////////////////////////////////////////
@ResponseStatus(code=HttpStatus.NOT_FOUND) // 404 (before is 500)
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message) {
		super(message); //pass message to RuntimeException 
	}
}

////////////////////////////////////////////////////////////////////////////////////////// return sample
{
    "timestamp": "2024-02-21T04:08:01.942+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "id: 123",
    "path": "/players/123"
}

//////////////////////////////////////////////////////////////////////////////////////////

package smarty.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

}

package smarty.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFetchResponse {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

}

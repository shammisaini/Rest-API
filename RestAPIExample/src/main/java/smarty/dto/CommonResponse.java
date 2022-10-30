package smarty.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse<T> {
	
	private Boolean result;
	private String message;
	private int statusCode;
	private T data;
}

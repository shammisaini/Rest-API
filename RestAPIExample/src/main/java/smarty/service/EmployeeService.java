package smarty.service;

import java.util.List;

import smarty.dto.EmployeeFetchResponse;
import smarty.dto.EmployeeRequest;

public interface EmployeeService {

	String saveEmployee(EmployeeRequest employeeRequest);

	List<EmployeeFetchResponse> fetchAll();

}

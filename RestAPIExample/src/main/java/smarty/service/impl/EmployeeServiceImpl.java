package smarty.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import smarty.dto.EmployeeFetchResponse;
import smarty.dto.EmployeeRequest;
import smarty.model.Employee;
import smarty.repository.EmployeeRepository;
import smarty.service.EmployeeService;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String saveEmployee(EmployeeRequest employeeRequest) {
		log.info("Enter in saveEmployee method present in EmployeeServiceImpl class  at line number 20");
		Employee emp;

		try {
			emp = new Employee();
			emp.setFirstName(employeeRequest.getFirstName());
			emp.setLastName(employeeRequest.getLastName());
			emp.setEmail(employeeRequest.getEmail());
			emp = employeeRepository.save(emp);
			if (emp.getId() > 0) {
				return "Record save Successfull";

			}

			else {
				return "unable to save Record";
			}

		} catch (Exception e) {

			return "unable to save Record";

		}

	}

	@Override
	public List<EmployeeFetchResponse> fetchAll() {
		log.info("Enter in fetchAll method present in EmployeeServiceImpl class  at line number 52");
		List<EmployeeFetchResponse> listEmployeeFetchResponse = new ArrayList<>();

		try {
			List<Employee> listEmployee = employeeRepository.findAll();

			if (!listEmployee.isEmpty()) {

				for (Employee ee : listEmployee) {
					EmployeeFetchResponse employeeFetchResponse = new EmployeeFetchResponse();
					employeeFetchResponse.setId(ee.getId());
					employeeFetchResponse.setFirstName(ee.getFirstName());
					employeeFetchResponse.setLastName(ee.getLastName());
					employeeFetchResponse.setEmail(ee.getEmail());
					listEmployeeFetchResponse.add(employeeFetchResponse);

				}

			}

		} catch (Exception e) {
			Collections.emptyList();
		}
		return listEmployeeFetchResponse;
	}

}

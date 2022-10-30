package smarty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import smarty.dto.EmployeeFetchResponse;
import smarty.dto.EmployeeRequest;
import smarty.service.EmployeeService;

@RestController
@Slf4j
public class APIRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody EmployeeRequest employeeRequest) {
		log.info("Enter in saveEmployee method present in APIRestController at line number 20");

		String response = employeeService.saveEmployee(employeeRequest);
		if (response.contains("Successfull")) {

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		else {

			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/fetch")
	public ResponseEntity<List<EmployeeFetchResponse>> fetch() {
		log.info("Enter in fetchAll method present in APIRestController  at line number 48");
		List<EmployeeFetchResponse> response = employeeService.fetchAll();
		if (!response.isEmpty()) {
			return new ResponseEntity<>(response, HttpStatus.OK);

		} else {

			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

		}

	}

}

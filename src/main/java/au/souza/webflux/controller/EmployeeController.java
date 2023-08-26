package au.souza.webflux.controller;

import au.souza.webflux.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import au.souza.webflux.service.EmployeeService;

import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
	this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Flux<Employee> getAllEmployees() {
	return employeeService.findAll();
    }
}

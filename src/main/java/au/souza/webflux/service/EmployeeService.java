package au.souza.webflux.service;

import au.souza.webflux.model.Employee;
import au.souza.webflux.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
	this.employeeRepository = employeeRepository;
    }

    public Flux<Employee> findAll() {
	return employeeRepository.findAll();
    }
}

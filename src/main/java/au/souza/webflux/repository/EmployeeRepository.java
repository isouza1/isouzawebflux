package au.souza.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import au.souza.webflux.model.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
}

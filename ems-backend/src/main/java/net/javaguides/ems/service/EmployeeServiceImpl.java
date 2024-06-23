package net.javaguides.ems.service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee saveEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(saveEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with given ID " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		 Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				 ()-> new ResourceNotFoundException("Employee does not exist with given id :"+employeeId));
		 
		 employee.setFirstName(updatedEmployee.getFirstName());
		 employee.setLastName(updatedEmployee.getLastName());;
		 employee.setEmail(updatedEmployee.getEmail());
		 
		 Employee updatedEmployeeObjEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObjEmployee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				 ()-> new ResourceNotFoundException("Employee does not exist with given id :"+employeeId));
		employeeRepository.deleteById(employeeId);
		
	}

}

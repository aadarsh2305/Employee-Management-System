package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Add a employee
    @PostMapping("/")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
      return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Get employee by Id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    
    //Get All employees
    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
    	List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
    	return ResponseEntity.ok(allEmployees);
    }
    
    //Update employee 
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId , @RequestBody EmployeeDto updatedEmployee){
    	EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
    	return ResponseEntity.ok(employeeDto);
    }
    
    //Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
    	employeeService.deleteEmployee(employeeId);
    	return ResponseEntity.ok("Employee Deleted successfully");
    }
}

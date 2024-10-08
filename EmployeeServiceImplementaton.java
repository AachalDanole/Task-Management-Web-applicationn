package TaskManagement_ServiceImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import TaskManagement_Repository.EmployeeRepository;
import TaskManagement_Service.Employee;
import Task_managementService_interface.EmployeeService;

@Service
public class EmployeeServiceImplementaton implements EmployeeService{

	
	@Autowired
	public EmployeeRepository employeeRepository;
	

	public EmployeeServiceImplementaton(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	
	
	@Override

	public Employee saveEmployee(Employee emp)
	{
		return employeeRepository.save(emp);  
	}


public Optional<Employee> getTaskById(int empId) {
		
		Optional<Employee> emp = employeeRepository.findById(empId);  
		return emp;
		
	}

@Override
public void deleteTaskById(int empId) {
	employeeRepository.deleteById(empId);

}


@Override
public Employee updateTaskById(Optional<Employee> empDet, Employee newVal) {


 Employee emp=empDet.get();
 emp.setTask(newVal.getTask());
emp.setDueDate(newVal.getDueDate());
	
		

		return employeeRepository.save(emp);
	
}
	

}

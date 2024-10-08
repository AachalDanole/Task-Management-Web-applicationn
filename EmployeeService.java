package Task_managementService_interface;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



import TaskManagement_Service.Employee;


@Service
public interface EmployeeService {


	Employee saveEmployee(Employee obj);
	
	Optional<Employee> getTaskById(int empId);
	
	
    Employee updateTaskById( Optional<Employee> empDet,Employee newVal);

	void deleteTaskById(int userID);
	

}





package TaskManagement_Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import TaskManagement_Repository.EmployeeRepository;
import TaskManagement_Service.Employee;
import TaskManagement_ServiceImplementation.EmployeeServiceImplementaton;


@CrossOrigin(origins = "http://localhost:4200")  
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	
	private EmployeeServiceImplementaton service;
	
	
	public EmployeeController(EmployeeServiceImplementaton service) {
		this.service = service;
	}
	
	//add new task
	@PostMapping("/saveEmp")
	public ResponseEntity <Employee> saveEmployee(@RequestBody Employee employee){
		try {
		return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED);
	  }
		catch(Exception exception) {
   			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getemp/{id}")
	public ResponseEntity<Employee>  getTaskById(@PathVariable("id")  int empId){
		System.out.println(empId); 
		Optional<Employee> emp = service.getTaskById(empId);
		
		if(emp.isPresent()) {
		return new ResponseEntity<>(emp.get(), HttpStatus.OK);
	        }
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	
	@DeleteMapping("delete/{id}")	
	public ResponseEntity<String> deleteTaskById(@PathVariable("id")  int empId)
	{
		Optional<Employee> empdata=service.getTaskById(empId);

		try {
			if(empdata.isPresent())
			{
				service.deleteTaskById(empId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
   }

	
	@PutMapping("update/{empId}")
	public ResponseEntity<Employee> updateTaskById(@PathVariable int empId, @RequestBody Employee employee){
		
		Optional<Employee> empdata=service.getTaskById(empId);

		if(empdata.isPresent())
		{

			service.updateTaskById(empdata, employee);
		return new ResponseEntity<>(service.updateTaskById(empdata,employee ),HttpStatus.OK);

	}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}

	
	

}
